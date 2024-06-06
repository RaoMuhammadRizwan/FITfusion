package com.example.fitfusion

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitfusion.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance().reference.child("Users").child(auth.currentUser!!.uid)

        binding.ivProfileImage.setImageResource(R.drawable.ic_profile)

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(User::class.java)
                if (user != null) {
                    binding.tvName.text = "Name: ${user.name}"
                    binding.tvGender.text = "Gender: ${user.gender}"
                    binding.tvAge.text = "Age: ${user.age}"
                    binding.tvHeight.text = "Height: ${user.height} cm"
                    binding.tvWeight.text = "Weight: ${user.weight} kg"
                    binding.tvTargetWeight.text = "Targeted Weight: ${user.targetWeight} kg"
                    binding.tvBMI.text = "BMI: ${user.bmi}"
                    binding.tvEmail.text = "Email: ${user.email}"
                } else {
                    Toast.makeText(
                        this@ProfileActivity,
                        "Failed to load user data",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@ProfileActivity,
                    "Database error: ${error.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

    }

}

