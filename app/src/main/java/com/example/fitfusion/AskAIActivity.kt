package com.example.fitfusion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitfusion.databinding.ActivityAskAiactivityBinding
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking


class AskAIActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAskAiactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAskAiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.btnAskAI.setOnClickListener {
            val prompt = binding.questionInput.text.toString()
            val generativeModel = GenerativeModel(
                modelName = "gemini-1.5-flash",

                apiKey = "AIzaSyC8k-xqczWjpsJt3G3kzoFm6calwuEzAfk"
            )
            runBlocking {
                val response = generativeModel.generateContent(prompt)
                binding.resultOutput.text = response.text

            }
        }

    }
}