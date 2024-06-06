package Exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitfusion.R
import com.example.fitfusion.databinding.ActivityExerciseListBinding

class ExerciseListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExerciseListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val level = intent.getStringExtra("level")
        title = level
        binding.tvLevel.text = level

        val exercises = getExercisesForLevel(level)
        val adapter = ExerciseAdapter(exercises)

        binding.recyclerViewExercises.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewExercises.adapter = adapter
    }

    private fun getExercisesForLevel(level: String?): List<Exercise> {
        return when (level) {
            "Beginner Level" -> listOf(
                Exercise("Push-Up", "A basic upper body exercise", "Easy", R.drawable.exercise_image),
                Exercise("Squat", "A fundamental lower body exercise", "Easy", R.drawable.exercise_image),
                Exercise("Lunges", "Great for leg muscles", "Easy", R.drawable.exercise_image)
            )
            "Intermediate Level" -> listOf(
                Exercise("Pull-Up", "Strengthens the upper body", "Medium", R.drawable.exercise_image),
                Exercise("Deadlift", "A total body strength exercise", "Medium", R.drawable.exercise_image),
                Exercise("Bench Press", "Great for chest muscles", "Medium", R.drawable.exercise_image)
            )
            "Advanced Level" -> listOf(
                Exercise("Clean and Jerk", "A complex weightlifting move", "Hard", R.drawable.exercise_image),
                Exercise("Snatch", "Advanced Olympic lift", "Hard", R.drawable.exercise_image ),
                Exercise("Muscle-Up", "A challenging upper body move", "Hard", R.drawable.exercise_image)
            )
            "Expert Level" -> listOf(
                Exercise("Iron Cross", "Requires extreme upper body strength", "Expert", R.drawable.exercise_image),
                Exercise("Planche", "Advanced gymnastics move", "Expert", R.drawable.exercise_image),
                Exercise("One-Arm Pull-Up", "Extreme upper body strength", "Expert", R.drawable.exercise_image)
            )
            else -> emptyList()
        }
    }
}
