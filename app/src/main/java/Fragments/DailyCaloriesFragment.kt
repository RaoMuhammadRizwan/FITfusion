package Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitfusion.Food.Food
import DailyCalories.FoodAdapter
import DailyCalories.MainViewModel
import com.example.fitfusion.R
import com.example.fitfusion.databinding.FragmentDailyCaloriesBinding

class DailyCaloriesFragment : Fragment() {
    private var _binding: FragmentDailyCaloriesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDailyCaloriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodAdapter = FoodAdapter(emptyList())
        binding.rvFoodList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = foodAdapter
        }

        viewModel.foodList.observe(viewLifecycleOwner, Observer {
            foodAdapter.foodList = it
            foodAdapter.notifyDataSetChanged()
        })

        binding.btnAddFood.setOnClickListener {
            showAddFoodDialog()
        }

        binding.btnClearAll.setOnClickListener {
            viewModel.clearFoodList()
        }
    }

    private fun showAddFoodDialog() {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_add_food, null)
        val etFoodName = dialogView.findViewById<EditText>(R.id.etFoodName)
        val etFoodCalories = dialogView.findViewById<EditText>(R.id.etFoodCalories)

        AlertDialog.Builder(requireContext())
            .setTitle("Add Food")
            .setView(dialogView)
            .setPositiveButton("Add") { dialog, _ ->
                val foodName = etFoodName.text.toString()
                val foodCalories = etFoodCalories.text.toString().toIntOrNull()

                if (foodName.isNotEmpty() && foodCalories != null) {
                    viewModel.addFood(Food(foodName, foodCalories))
                } else {
                    Toast.makeText(requireContext(), "Please enter valid data", Toast.LENGTH_SHORT).show()
                }

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
