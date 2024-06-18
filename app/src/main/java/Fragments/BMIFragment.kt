package Fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.fitfusion.BMIResultActivity
import com.example.fitfusion.R
import com.example.fitfusion.databinding.FragmentBMIBinding

class BMIFragment : Fragment() {

    private var _binding: FragmentBMIBinding? = null
    private val binding get() = _binding!!

    private var isMaleSelected = false
    private var isFemaleSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBMIBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.cvMale.setOnClickListener {
            isMaleSelected = true
            isFemaleSelected = false
            updateCardViewSelection()
        }

        binding.cvFemale.setOnClickListener {
            isMaleSelected = false
            isFemaleSelected = true
            updateCardViewSelection()
        }

        binding.btnCalculate.setOnClickListener {
            if (validateInput()) {
                calculateBMI()
            }
        }

        return view
    }

    private fun updateCardViewSelection() {
        if (isMaleSelected) {
            binding.cvMale.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selected_card))
            binding.cvFemale.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.default_card))
        } else if (isFemaleSelected) {
            binding.cvMale.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.default_card))
            binding.cvFemale.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selected_card))
        } else {
            binding.cvMale.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.default_card))
            binding.cvFemale.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.default_card))
        }
    }

    private fun validateInput(): Boolean {
        val weight = binding.etWeight.text.toString().trim()
        val height = binding.etHeight.text.toString().trim()
        val age = binding.etAge.text.toString().trim()

        if (!isMaleSelected && !isFemaleSelected) {
            Toast.makeText(requireContext(), "Please select gender", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(weight)) {
            Toast.makeText(requireContext(), "Please enter your weight", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(height)) {
            Toast.makeText(requireContext(), "Please enter your height", Toast.LENGTH_SHORT).show()
            return false
        }
        if (TextUtils.isEmpty(age)) {
            Toast.makeText(requireContext(), "Please enter your age", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun calculateBMI() {
        val weight = binding.etWeight.text.toString().toFloat()
        val heightCm = binding.etHeight.text.toString().toFloat()
        val heightM = heightCm / 100 // Convert height to meters
        val bmi = weight / (heightM * heightM)

        val category: String
        val imageResId: Int
        val colorResId: Int

        when {
            bmi < 18.5 -> {
                category = "Underweight"
                imageResId = R.drawable.underweight_image
                colorResId = R.color.underweight_color
            }
            bmi < 25 -> {
                category = "Normal weight"
                imageResId = R.drawable.normal_weight_image
                colorResId = R.color.normal_weight_color
            }
            bmi < 30 -> {
                category = "Overweight"
                imageResId = R.drawable.overweight_image
                colorResId = R.color.overweight_color
            }
            else -> {
                category = "Obese"
                imageResId = R.drawable.obese_image
                colorResId = R.color.obese_color
            }
        }
        Toast.makeText(requireContext(), "Your BMI is: %.2f".format(bmi), Toast.LENGTH_LONG).show()

        val intent = Intent(requireContext(), BMIResultActivity::class.java).apply {
            putExtra("BMI_VALUE", bmi)
            putExtra("BMI_CATEGORY", category)
            putExtra("BMI_IMAGE_RES_ID", imageResId)
            putExtra("BMI_COLOR_RES_ID", colorResId)
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
