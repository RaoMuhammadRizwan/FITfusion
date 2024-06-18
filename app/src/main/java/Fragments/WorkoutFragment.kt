package Fragments

import Exercise.ExerciseListActivity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fitfusion.databinding.FragmentWorkoutBinding


class WorkoutFragment : Fragment() {
    private var _binding: FragmentWorkoutBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardViewBeginner.setOnClickListener {
            navigateToExerciseList("Beginner Level")
        }

        binding.cardViewIntermediate.setOnClickListener {
            navigateToExerciseList("Intermediate Level")
        }

        binding.cardViewAdvanced.setOnClickListener {
            navigateToExerciseList("Advanced Level")
        }

        binding.cardViewExpert.setOnClickListener {
            navigateToExerciseList("Expert Level")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToExerciseList(level: String) {
        val intent = Intent(requireContext(), ExerciseListActivity::class.java)
        intent.putExtra("level", level)
        startActivity(intent)
    }
}