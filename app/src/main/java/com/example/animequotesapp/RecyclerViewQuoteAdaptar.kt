package com.example.animequotesapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewQuoteAdaptar constructor(private val getActivity: MainActivity, private val quotes: List<Quote>):
    RecyclerView.Adapter<RecyclerViewQuoteAdaptar.QuoteViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genres_item, parent, false)
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
       holder.title.text = quotes[position].title
        holder.image.setImageResource(quotes[position].image)
        holder.cardView.setOnClickListener {

            val intent = Intent(getActivity, QuoteScreen::class.java)
            intent.putExtra("quote", quotes[position].title)
            getActivity.startActivity(intent)





        }

    }

    override fun getItemCount(): Int {
        return quotes.size
    }



    class QuoteViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.genreTitle)
        val image = itemView.findViewById<ImageView>(R.id.genreImage)
        val cardView : CardView = itemView.findViewById(R.id.genreCard)

    }

}