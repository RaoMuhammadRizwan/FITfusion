package com.example.fitfusion

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.webkit.WebViewCompat
import androidx.webkit.WebViewFeature
import org.json.JSONException
import org.json.JSONObject

class AvatarCreation : AppCompatActivity() {
    companion object {
        private const val CAMERA_PERMISSION_REQUEST_CODE = 100
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (!(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Camera permission required for scanning")
                    .show()
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avatar_creation)
        val myWebView: WebView = findViewById(R.id.webview)
        val webSettings: WebSettings = myWebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.mediaPlaybackRequiresUserGesture = false
        // Override user agent to support sign-in with google
        webSettings.userAgentString = "Mozilla/5.0 (Linux; Android 12) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.5359.128 Mobile Safari/537.36"

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_REQUEST_CODE)
        }

        myWebView.webChromeClient = object : WebChromeClient() {
            override fun onPermissionRequest(request: PermissionRequest) {
                request.grant(request.resources)
            }
        }

        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                // Open all redirects in web-view
                return false
            }

            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                // Always enable sign in with redirect in web-view
                view.evaluateJavascript("window.avaturnFirebaseUseSignInWithRedirect = true;", null)
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                // Always enable sign in with redirect in web-view
                view.evaluateJavascript("window.avaturnFirebaseUseSignInWithRedirect = true;", null)
            }
        }

        val URL = "https://demo.avaturn.dev/iframe" // project's domain
        val uri: Uri = Uri.parse(URL)
        val projectDomain = "${uri.scheme}://${uri.host}"

        if (WebViewFeature.isFeatureSupported(WebViewFeature.WEB_MESSAGE_LISTENER)) {
            WebViewCompat.addWebMessageListener(myWebView, "native_app", setOf(projectDomain)) { view, message, sourceOrigin, isMainFrame, replyProxy ->
                try {
                    val obj = JSONObject(message.data ?: return@addWebMessageListener)
                    val data = obj.getJSONObject("data")

                    if (obj.getString("eventName") != "v2.avatar.exported") {
                        return@addWebMessageListener
                    }

                    val urlType = data.getString("urlType")
                    val url = data.getString("url")
                    if (urlType == "httpURL") {
                        AlertDialog.Builder(this)
                            .setTitle("Received http URL for glb file")
                            .setMessage(url)
                            .show()
                    } else {
                        val glbBytes = Base64.decode(url.substring(url.lastIndexOf(",") + 1), Base64.DEFAULT)
                        AlertDialog.Builder(this)
                            .setTitle("Received data URL for glb file")
                            .setMessage(String.format("Glb file has %.2f Mb size", glbBytes.size / 1024.0 / 1024))
                            .show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        }

        myWebView.loadUrl(URL)
    }
}


