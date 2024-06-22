package Diet

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitfusion.Diet.DietPlan
import com.example.fitfusion.databinding.ActivityDietDetailsBinding

class DietDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDietDetailsBinding
    private lateinit var dietPlan: DietPlan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDietDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Receive diet plan details from intent
        dietPlan = intent.getParcelableExtra<DietPlan>("dietPlan") ?: return

        // Display diet plan details
        with(binding) {
            imageViewDietPlan.setImageResource(dietPlan.imageResId)
            textViewDietPlanName.text = dietPlan.name
            textViewOverview.text = dietPlan.overview
            textViewHealthBenefits.text = dietPlan.healthBenefits
            textViewOtherBenefits.text = dietPlan.otherBenefits
            textViewDownsides.text = dietPlan.downsides

            // Set click listeners for Learn More and Watch Video buttons
            buttonLearnMore.setOnClickListener {
                dietPlan.websiteUrl?.let { it1 -> navigateToWebLink(it1) }
            }

            buttonWatchVideo.setOnClickListener {
                dietPlan.youtubeUrl?.let { it1 -> navigateToYouTubeVideo(it1) }
            }
        }
    }

    private fun navigateToWebLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun navigateToYouTubeVideo(videoUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
        startActivity(intent)
    }
}
