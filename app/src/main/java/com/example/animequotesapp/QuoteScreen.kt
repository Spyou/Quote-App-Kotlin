package com.example.animequotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.animequotesapp.databinding.ActivityMainBinding
import com.example.animequotesapp.databinding.ActivityQuoteScreenBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class QuoteScreen : AppCompatActivity() {
    lateinit var binding: ActivityQuoteScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getQuote()


    }

    private fun getQuote() {
        setInProgress(true)
        lifecycleScope.launch {
            val requestTitle = intent.getStringExtra("quote")
            binding.titleAnime.text=requestTitle.toString()
            val response = if (requestTitle.toString().toLowerCase()
                    .equals("randoms")
            ) RetrofitInstance.quoteApi.getRandomQuote() else RetrofitInstance.quoteApi.getQuoteByTitle(
                title = requestTitle.toString()
            )
            if (response.isSuccessful) {
                setInProgress(false)
                response.body()?.let {
                    setUi(it)
                }
                Log.d("w", "onCreate: ${response.body()}")

            } else {
                setInProgress(false)
            }

        }


    }//goo telegram

    private fun setUi(quote: QuoteResponse) {
        binding.quotes.text = quote.quote
        binding.character.text = " --  " + quote.character + " from " + quote.anime

        binding.copy.setOnClickListener {
            val text = quote.quote
            val clipboard = android.content.ClipData.newPlainText("Copied Text", text)
            val primaryClip = getSystemService(android.content.Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
            primaryClip.setPrimaryClip(clipboard)
        }
        binding.share.setOnClickListener {
            val sendIntent: android.content.Intent = android.content.Intent().apply {
                action = android.content.Intent.ACTION_SEND
                putExtra(android.content.Intent.EXTRA_TEXT, quote.quote + "\n" +  " --  " + quote.character + " from " + quote.anime)
                type = "text/plain"
            }
            val shareIntent = android.content.Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        binding.nextBtn.setOnClickListener {getQuote()}
        binding.backbtn.setOnClickListener {finish()}
    }

    private fun setInProgress(
        inProgress: Boolean
    ) {
        if (inProgress) {
            binding.progressBar.visibility = View.VISIBLE

        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

}