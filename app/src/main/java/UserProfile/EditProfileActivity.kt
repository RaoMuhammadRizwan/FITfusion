package UserProfile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitfusion.databinding.ActivityEditProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference.child("Users").child(auth.currentUser!!.uid)

        // Retrieve the user data from Firebase and set to EditText fields
        database.get().addOnSuccessListener { snapshot ->
            val user = snapshot.getValue(User::class.java)
            if (user != null) {
                binding.etName.setText(user.name)
                binding.etGender.setText(user.gender)
                binding.etAge.setText(user.age.toString())
                binding.etHeight.setText(user.height.toString())
                binding.etWeight.setText(user.weight.toString())
                binding.etTargetWeight.setText(user.targetWeight.toString())
                binding.etBMI.setText(user.bmi.toString())
                binding.etEmail.setText(user.email)
            } else {
                Toast.makeText(this, "Failed to load user data", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSave.setOnClickListener {
            // Update user details
            val user = User(
                name = binding.etName.text.toString(),
                gender = binding.etGender.text.toString(),
                age = binding.etAge.text.toString().toInt(),
                height = binding.etHeight.text.toString().toInt(),
                weight = binding.etWeight.text.toString().toInt(),
                targetWeight = binding.etTargetWeight.text.toString().toInt(),
                bmi = binding.etBMI.text.toString().toDouble(),
                email = binding.etEmail.text.toString()
            )

            // Save updated user details to Firebase
            database.setValue(user).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Failed to update profile: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
