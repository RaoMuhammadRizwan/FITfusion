package Exercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitfusion.R

data class Exercise(
    val name: String,
    val description: String,
    val difficulty: String,
    val imageResId: Int
)

class ExerciseAdapter(private val exercises: List<Exercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exerciseName: TextView = itemView.findViewById(R.id.tvExerciseName)
        val exerciseDescription: TextView = itemView.findViewById(R.id.tvExerciseDescription)
        val exerciseDifficulty: TextView = itemView.findViewById(R.id.tvExerciseDifficulty)
        val exerciseImage: ImageView = itemView.findViewById(R.id.ivExerciseImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.exercise_list_items, parent, false)
        return ExerciseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentExercise = exercises[position]
        holder.exerciseName.text = currentExercise.name
        holder.exerciseDescription.text = currentExercise.description
        holder.exerciseDifficulty.text = currentExercise.difficulty
        holder.exerciseImage.setImageResource(currentExercise.imageResId)
    }

    override fun getItemCount() = exercises.size
}
