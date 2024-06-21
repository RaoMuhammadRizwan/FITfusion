package Quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitfusion.Quotes.Quotesfile
import com.example.fitfusion.databinding.ActivityDisplayQuoteBinding

class DisplayQuoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayQuoteBinding
    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userName = intent.getStringExtra("USER_NAME") ?: "User"

        binding.newQuoteButton.setOnClickListener {
            val randomQuote = Quotesfile.quotes.random()
            binding.quoteTextView.text = "$userName, $randomQuote"
        }

        // Display the first quote when the activity starts
        val initialQuote = Quotesfile.quotes.random()
        binding.quoteTextView.text = "$userName, $initialQuote"
    }
}