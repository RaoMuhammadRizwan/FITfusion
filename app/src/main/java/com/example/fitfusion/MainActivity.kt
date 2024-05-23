//this is just for sample and will be deleted later
package com.example.fitfusion

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitfusion.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    //Declaring an instance of FirebaseAuth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Intializing FireBase Auth
        auth = FirebaseAuth.getInstance()

        binding.btnLogout.setOnClickListener {
            Firebase.auth.signOut()

            val intent = Intent(this , LoginActivity::class.java)
            startActivity(intent)
            finish()

        }

        enableEdgeToEdge()
        setContentView(binding.root)




    }
}