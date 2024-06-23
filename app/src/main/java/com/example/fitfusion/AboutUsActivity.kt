package com.example.fitfusion

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.fitfusion.databinding.ActivityAboutUsBinding
import com.example.fitfusion.databinding.DialogTermsConditionsBinding

class AboutUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTerms.setOnClickListener {
            showTermsDialog()
        }

        binding.ivGmail.setOnClickListener {
            openUrl("https://www.gmail.com")
        }

        binding.ivGithub.setOnClickListener {
            openUrl("https://github.com/RaoMuhammadRizwan")
        }

        binding.ivLinkedin.setOnClickListener {
            openUrl("https://www.linkedin.com/in/raorixwan/")
        }
    }

    private fun showTermsDialog() {
        val dialog = Dialog(this)
        val dialogBinding = DialogTermsConditionsBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)

        // Replace with your actual terms and conditions text
        val termsText = "\nTerms and Conditions for FITfusion Fitness App" +
                "\nBy using this app, you agree to the following terms:" +
                "\n" +
                "\n1. Use of the App" +
                "\n   * You must be 18 years or older to use FITfusion." +
                "\n    * Consult your healthcare provider before starting any fitness program." +
                "\n2. Account Responsibilities" +
                "\n" +
                "\n    * Keep your account information confidential." +
                "\n    * You are responsible for all activities under your account." +
                "\n" +
                "\n3. Content Usage" +
                "\n    * FITfusion owns the app and its content." +
                "\n" +
                "\n4. Limitation of Liability" +
                "\n    * FITfusion is provided as is. We are not liable for any damages from using the app." +
                "\n" +
                "\n5. Changes" +
                "\n    * We may update these terms. Continued use of the app means you accept the changes." +
                "\n" +
                "\n6. Contact" +
                "\n" +
                "\nIf you have questions, contact us at raorixwan69@gmail.com"
        dialogBinding.textViewTermsContent.text = termsText

        dialogBinding.buttonClose.setOnClickListener {
            dialog.dismiss()
        }

        // Adjust dialog width (optional)
        val width = (resources.displayMetrics.widthPixels * 0.9).toInt() // 90% of screen width
        dialog.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        dialog.show()
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}