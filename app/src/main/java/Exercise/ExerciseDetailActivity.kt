package Exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitfusion.databinding.ActivityExerciseDetailBinding

class ExerciseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exerciseName = intent.getStringExtra("exercise_name")
        val exerciseDescription = intent.getStringExtra("exercise_description")
        val exerciseInstructions = intent.getStringExtra("exercise_instructions")
        val exerciseImageResId = intent.getIntExtra("exercise_image_res_id", 0)

        binding.tvExerciseDetailName.text = exerciseName
        binding.tvExerciseDetailDescription.text = exerciseDescription
        binding.tvExerciseDetailInstructions.text = exerciseInstructions
        binding.ivExerciseDetailImage.setImageResource(exerciseImageResId)
    }
}
