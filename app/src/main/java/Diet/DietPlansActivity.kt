package com.example.fitfusion.Diet

import Diet.DietDetailsActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitfusion.R
import com.example.fitfusion.databinding.ActivityDietPlansBinding

class DietPlansActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDietPlansBinding
    private lateinit var dietPlansAdapter: DietPlansAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDietPlansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val dietPlans = getDietPlans()
        dietPlansAdapter = DietPlansAdapter(dietPlans) { dietPlan ->
            navigateToDietDetails(dietPlan)
        }

        binding.recyclerViewDietPlans.apply {
            layoutManager = LinearLayoutManager(this@DietPlansActivity)
            adapter = dietPlansAdapter
        }
    }

    private fun getDietPlans(): List<DietPlan> {
        return listOf(
            DietPlan(
                "Mediterranean Diet",
                R.drawable.mediterranean_diet,
                "Overview: Emphasizes fruits, vegetables, whole grains, fish, nuts, olive oil, and limits red meat and processed foods.",
                "Health Benefits: Associated with reduced risk of chronic diseases, improved heart health, and potential for weight loss.",
                "Other Benefits: Rich in antioxidants and healthy fats, promotes longevity and overall well-being.",
                "Downsides: Requires planning and adjustment to traditional diets.",
                "https://www.healthline.com/nutrition/mediterranean-diet-meal-plan",
                "https://youtu.be/2N0cRpuWz5U"
            ),
            DietPlan(
                "DASH Diet",
                R.drawable.dash_diet,
                "Overview: Focuses on fruits, vegetables, whole grains, lean proteins, and low-fat dairy while reducing salt intake.",
                "Health Benefits: Effective in lowering blood pressure, reducing heart disease risk, and supporting weight management.",
                "Other Benefits: May improve cholesterol levels and overall cardiovascular health.",
                "Downsides: May be difficult to follow in social situations.",
                "https://www.healthline.com/nutrition/dash-diet",
                "https://youtu.be/4OPpRp7zZ3Q"
            ),
            DietPlan(
                "Plant-Based Diets",
                R.drawable.plant_based_diet,
                "Overview: Plant-based diets focus on fruits, vegetables, legumes, and grains, while flexitarian allows occasional meat consumption.",
                "Health Benefits: Reduces risk of chronic diseases like type 2 diabetes, promotes weight loss, and supports environmental sustainability.",
                "Other Benefits: High in fiber, vitamins, and antioxidants, while potentially lowering cholesterol and blood pressure.",
                "Downsides: Requires careful planning to ensure nutritional needs are met.",
                "https://www.healthline.com/nutrition/plant-based-diet-guide",
                "https://youtu.be/kmBIt10jdlQ"
            ),
            DietPlan(
                "MIND Diet",
                R.drawable.mind_diet,
                "Overview: Combines elements of Mediterranean and DASH diets to promote brain health.",
                "Health Benefits: Linked to reduced risk of Alzheimer's disease, improved cognitive function, and potential for weight management.",
                "Other Benefits: Flexible approach with emphasis on specific brain-boosting foods and overall dietary quality.",
                "Downsides: Specific dietary guidelines may be challenging to maintain.",
                "https://www.healthline.com/nutrition/mind-diet",
                "https://youtu.be/c4lWpVcM5mE"
            ),
            DietPlan(
                "WW (Weight Watchers)",
                R.drawable.ww_diet,
                "Overview: Uses a points-based system to encourage balanced eating and portion control.",
                "Health Benefits: Effective for weight loss and weight maintenance, promotes healthy eating habits without strict food restrictions.",
                "Other Benefits: Provides support through community, flexible meal planning, and behavioral changes.",
                "Downsides: Requires subscription and may not fit all dietary preferences.",
                "https://www.verywellfit.com/pros-and-cons-of-weight-watchers-3496212",
                "https://youtu.be/baT1-ranqq8"
            ),
            DietPlan(
                "Intermittent Fasting",
                R.drawable.intermittent_fasting,
                "Overview: Cycling between periods of eating and fasting, such as 16/8 or 5:2 methods.",
                "Health Benefits: Supports weight loss, improves metabolic health, and may reduce inflammation and improve heart health.",
                "Other Benefits: Simplifies meal planning, potentially enhances longevity, and aids in insulin sensitivity.",
                "Downsides: May cause initial discomfort or hunger during fasting periods.",
                "https://www.healthline.com/nutrition/intermittent-fasting-guide",
                "https://youtu.be/ahnl7GaV_rU"
            ),
            DietPlan(
                "Volumetrics Diet",
                R.drawable.volumetrics_diet,
                "Overview: Focuses on low-calorie, nutrient-dense foods that promote fullness and satisfaction.",
                "Health Benefits: Supports weight loss by emphasizing foods with high water and fiber content, while reducing calorie-dense choices.",
                "Other Benefits: Encourages overall dietary quality, helps manage hunger, and may reduce risk of chronic diseases.",
                "Downsides: Requires careful food selection and portion control to achieve desired results.",
                "https://www.healthline.com/nutrition/volumetrics-diet",
                "https://youtu.be/c_Kr8wpfHNg"
            ),
            DietPlan(
                "Flexitarian Diet",
                R.drawable.flexitarian_diet,
                "Overview: A flexible approach to plant-based eating, allowing occasional consumption of meat and animal products.",
                "Health Benefits: Similar to vegetarian diets in promoting weight loss, reducing disease risk, and supporting sustainability.",
                "Other Benefits: Provides flexibility and variety, potentially easier to maintain long-term compared to strict vegetarianism or veganism.",
                "Downsides: Requires conscious food choices to ensure balanced nutrition.",
                "https://www.healthline.com/nutrition/flexitarian-diet-guide",
                "https://youtu.be/6e4Hy8fh3UU"
            ),
            DietPlan(
                "Low-Carb Diet",
                R.drawable.low_carb_diet,
                "Overview: Restricts carbohydrates, emphasizing protein and fats, popular variants include Atkins and South Beach diets.",
                "Health Benefits: Rapid weight loss due to reduced insulin levels and increased fat burning, improves metabolic health.",
                "Other Benefits: May reduce appetite, stabilize blood sugar levels, and enhance lipid profiles in some individuals.",
                "Downsides: Initial side effects like 'keto flu' and may not be suitable for everyone long-term.",
                "https://www.healthline.com/nutrition/low-carb-diet-meal-plan-and-menu",
                "https://youtu.be/rhM-BckSBp4"
            )
        )
    }

    private fun navigateToDietDetails(dietPlan: DietPlan) {
        val intent = Intent(this, DietDetailsActivity::class.java)
        intent.putExtra("dietPlan", dietPlan)
        startActivity(intent)
    }

}
