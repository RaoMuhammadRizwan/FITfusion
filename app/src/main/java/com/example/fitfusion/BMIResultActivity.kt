package com.example.fitfusion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fitfusion.databinding.ActivityBmiresultBinding

class BMIResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiresultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiresultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the passed data
        val bmiValue = intent.getFloatExtra("BMI_VALUE", 0f)
        val category = intent.getStringExtra("BMI_CATEGORY")
        val imageResId = intent.getIntExtra("BMI_IMAGE_RES_ID", 0)
        val colorResId = intent.getIntExtra("BMI_COLOR_RES_ID", 0)

        // Display the data
        binding.bmiValue.text = getString(R.string.bmi_value, bmiValue)
        binding.bmiCategory.text = category
        binding.bmiImage.setImageResource(imageResId)
        binding.bmiColor.setBackgroundColor(ContextCompat.getColor(this, colorResId))
    }
}
