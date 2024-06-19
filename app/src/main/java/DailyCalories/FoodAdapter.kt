package DailyCalories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitfusion.Food.Food
import com.example.fitfusion.R

class FoodAdapter(var foodList: List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodName: TextView = view.findViewById(R.id.foodName)
        val foodCalories: TextView = view.findViewById(R.id.foodCalories)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.foodName.text = food.name
        holder.foodCalories.text = "${food.calories} kcal"
    }

    override fun getItemCount(): Int = foodList.size
}
