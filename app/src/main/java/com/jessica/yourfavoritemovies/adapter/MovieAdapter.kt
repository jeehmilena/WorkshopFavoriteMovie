package com.jessica.yourfavoritemovies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jessica.yourfavoritemovies.Constants.BASE_IMAGE_URL
import com.jessica.yourfavoritemovies.R
import com.jessica.yourfavoritemovies.model.Result

class MovieAdapter(
    var listMovie: MutableList<Result>,
    val onClick: (item: Result) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listMovie[position])
        holder.favorite.setOnClickListener {
            holder.favorite.setImageDrawable(
                ResourcesCompat.getDrawable(
                    holder.itemView.resources,
                    R.drawable.ic_favorite,
                    null
                )
            )
            onClick(listMovie[position])
        }
    }

    override fun getItemCount(): Int = listMovie.size

    fun updateList(results: MutableList<Result>) {
        listMovie = results
        notifyDataSetChanged()
    }

    fun removeItem(result: Result) {
        listMovie.remove(result)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.tv_title)
        private val image = itemView.findViewById<ImageView>(R.id.iv_movie)
        val favorite = itemView.findViewById<ImageView>(R.id.iv_favorite)

        fun onBind(result: Result) {
            title.text = result.title

            Glide.with(itemView.context).load("$BASE_IMAGE_URL${result.posterPath}")
                .placeholder(R.mipmap.ic_movie)
                .into(image)
        }
    }
}