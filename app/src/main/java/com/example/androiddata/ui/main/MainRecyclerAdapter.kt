package com.example.androiddata.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androiddata.R
import com.example.androiddata.data.Film

class MainRecyclerAdapter(val context: Context,
                          val films: List<Film>,
                          val itemListener: MonsterItemListener):
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>()

{

    var Tag = "image"
    var Tag2 = "title"

    override fun getItemCount() = films.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.monster_grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val film = films[position]

        with(holder) {
            releaseDate?.let {
                it.text = film.release_date.toString()
                it.contentDescription = film.description
            nameText?.let { it.text = film.title }
            }

//            Glide.with(context)
//                .load(getThumbnail(context))
//                .centerCrop()
//                .into(holder.monsterImage)


             fun getPosterName(): String? { //example: My Neighbor Totoro = my_neighbor_totoro_poster
                return film.title.toLowerCase().replace(" ", "_").replace("'", "")+"_poster";
            }

            fun getPoster(context: Context): Int {
                return context.getResources().getIdentifier(getPosterName(), "drawable", context.getPackageName())
            }
        val imageUrl = getPoster(context)
            // loading album cover using Glide library
            Glide.with(context).load(film.getThumbnail(context)).into(filmImage)
//            Glide.with(contex)

//            val tilte1: String = monster.title.toLowerCase().replace(" ", "_").replace("'", "");
//            Log.i(Tag2, tilte1)
//            val image1 = monster.getThumbnail(context)
//            Log.i(Tag, image1.toString())

            holder.itemView.setOnClickListener{
                itemListener.onMonsterItemClick(film)
            }
        }
    }

    inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.findViewById<TextView>(R.id.nameText)
        val releaseDate = itemView.findViewById<TextView>(R.id.release_date)
        val filmImage = itemView.findViewById<ImageView>(R.id.filmImage)
        val producer = itemView.findViewById<ImageView>(R.id.producer_title)
        val director = itemView.findViewById<ImageView>(R.id.director_title)
    }

    interface MonsterItemListener {
        fun onMonsterItemClick(film: Film)
    }
}