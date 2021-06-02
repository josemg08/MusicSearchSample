package com.josegonzalez.musicsearchsample.features.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.josegonzalez.musicsearchsample.R
import com.josegonzalez.musicsearchsample.model.TrackDto
import com.josegonzalez.musicsearchsample.features.list.CustomAdapter.TrackViewHolder

class CustomAdapter(private val dataSet: List<TrackDto>, private val trackAdapterCallback: TrackAdapterCallback) : RecyclerView.Adapter<TrackViewHolder>() {
    private var context: Context? = null

    interface TrackAdapterCallback {
        fun onListItemClicked(position: Int)
    }

    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName: TextView = itemView.findViewById<View>(R.id.textViewName) as TextView
        var textViewVersion: TextView = itemView.findViewById<View>(R.id.textViewVersion) as TextView
        var imageViewIcon: ImageView = itemView.findViewById<View>(R.id.imageView) as ImageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cards_layout, parent, false)
        context = parent.context
        val myViewHolder = TrackViewHolder(view)
        myViewHolder.itemView.setOnClickListener {
            trackAdapterCallback.onListItemClicked(myViewHolder.adapterPosition)
        }
        return myViewHolder
    }

    override fun onBindViewHolder(holder: TrackViewHolder, listPosition: Int) {
        val textViewName = holder.textViewName
        val textViewVersion = holder.textViewVersion
        val imageView = holder.imageViewIcon
        textViewName.text = dataSet[listPosition].trackName
        textViewVersion.text = dataSet[listPosition].artistName
        if (dataSet[listPosition].artworkUrl100 != null && !dataSet[listPosition].artworkUrl100?.isEmpty()!!) {
            context?.let {
                Glide.with(it)
                        .load(dataSet[listPosition].artworkUrl100)
                        .into(imageView)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}