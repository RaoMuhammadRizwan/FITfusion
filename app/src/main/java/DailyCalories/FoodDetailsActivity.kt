package DailyCalories

import Fragments.DailyCaloriesFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitfusion.databinding.ActivityFoodDetailsBinding
import com.example.fitfusion.R

class FoodDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DailyCaloriesFragment())
            .commit()
    }
}
