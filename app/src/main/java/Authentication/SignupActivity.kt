package Authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.fitfusion.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {
    //finding Views
    private val binding: ActivitySignupBinding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    //Declaring an instance of FirebaseAuth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        //Intializing FireBase Auth
         auth = FirebaseAuth.getInstance()


        binding.alreadyHaveAccBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCreateAccount.setOnClickListener {
            //getting data from text fields
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val retypePassword = binding.etRetypePassword.text.toString()
            
            //Checking if any field is Empty/Blank
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || retypePassword.isEmpty()) {
                Toast.makeText(this, "PLEASE fill all the Details", Toast.LENGTH_SHORT).show()

            }else if (password != retypePassword){
                Toast.makeText(this,"Passwords MissMatch", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email , password)
                    .addOnCompleteListener(this){task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Registration Successful !", Toast.LENGTH_SHORT).show()
                            //where will the user go if successfull
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else{
                            Toast.makeText(this, "Refistration Failed : ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }


        }



    }
}