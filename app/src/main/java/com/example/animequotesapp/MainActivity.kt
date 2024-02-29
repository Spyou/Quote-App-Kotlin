package com.example.animequotesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerViewQuoteAdaptar? = null
    private var quotes = mutableListOf<Quote>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       quotes = ArrayList()

        recyclerView = findViewById<View>(R.id.mediaInfoGenresRecyclerView) as RecyclerView
        adapter = RecyclerViewQuoteAdaptar(this@MainActivity, quotes)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 2)

        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = adapter

        QuoteListData()

//        val characterButton = findViewById<View>(R.id.character_chip)
//        characterButton.setOnClickListener {
//            val intent = Intent(this, CharacterScreen::class.java)
//            startActivity(intent)
//        }


    }
    private fun QuoteListData() {

        quotes.add(Quote("Randoms", R.drawable.vinland_saga))
        quotes.add(Quote("Naruto", R.drawable.naruto))
        quotes.add(Quote("Naruto Shippuden", R.drawable.naruto_shippuden))
        quotes.add(Quote("One Piece", R.drawable.one_piece))
        quotes.add(Quote("Bleach", R.drawable.bleach))
        quotes.add(Quote("Berserk", R.drawable.berserk))
        quotes.add(Quote("Vinland Saga", R.drawable.vinland_saga))
        quotes.add(Quote("Dragon Ball", R.drawable.dragon_ball))
        quotes.add(Quote("Attack on Titan", R.drawable.attackontitan))
        quotes.add(Quote("Death Note", R.drawable.death_note))
        quotes.add(Quote("Monster", R.drawable.monster))
        quotes.add(Quote("Demon Slayer", R.drawable.demon_slayer))
        quotes.add(Quote("One Punch Man", R.drawable.one_punch_man))
        quotes.add(Quote("Tokyo Ghoul", R.drawable.tokyo_ghoul))
        quotes.add(Quote("Cowboy Bepop", R.drawable.cowboy_bepop))
        quotes.add(Quote("Fairy Tail", R.drawable.fairy_tail))
        quotes.add(Quote("Jujutsu Kaisen", R.drawable.jujutsu_kaisen))
        quotes.add(Quote("My Hero Academia", R.drawable.my_hero_academia))



        adapter!!.notifyDataSetChanged()
    }
}