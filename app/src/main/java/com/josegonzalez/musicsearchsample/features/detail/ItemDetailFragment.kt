package com.josegonzalez.musicsearchsample.features.detail

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.josegonzalez.musicsearchsample.R

class ItemDetailFragment : Fragment() {

    private var artist: String? = null
    private var track: String? = null
    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        if (arguments!!.containsKey(ItemDetailActivity.ARTIST_KEY)) {
            artist = arguments!!.getString(ItemDetailActivity.ARTIST_KEY)
            val activity: Activity? = this.activity
            val appBarLayout: CollapsingToolbarLayout = activity!!.findViewById(R.id.toolbar_layout)
            appBarLayout.title = artist
        }
        track = arguments!!.getString(ItemDetailActivity.TRACK_KEY)
        imageUrl = arguments!!.getString(ItemDetailActivity.IMAGE_KEY)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)
        val imageView = rootView.findViewById<ImageView>(R.id.imageView)
        if (artist != null) {
            (rootView.findViewById<View>(R.id.artist_name) as TextView).text = artist
        }
        if (track != null) {
            (rootView.findViewById<View>(R.id.track_name) as TextView).text = track
        }
        if (imageUrl != null && imageUrl!!.isNotEmpty()) {
            Glide.with(context)
                    .load(imageUrl)
                    .into(imageView)
        }
        return rootView
    }

}