package ru.kmosunoff.sEstateTest.dao

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.joke_card.view.*
import ru.kmosunoff.sEstateTest.R

class JokesAdapter(var jokes: List<Joke>, private val context: Context?): RecyclerView.Adapter<JokesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.joke_card, parent, false))
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: JokesAdapter.ViewHolder, position: Int) {
        holder.jokeTextView.text = jokes.get(position).joke
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardView: CardView = view.cardView
        val jokeTextView: TextView = view.jokeTextView
    }
}