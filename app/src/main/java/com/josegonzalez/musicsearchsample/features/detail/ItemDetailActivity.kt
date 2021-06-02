package com.josegonzalez.musicsearchsample.features.detail

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.josegonzalez.musicsearchsample.R
import com.josegonzalez.musicsearchsample.common.BaseActivity

class ItemDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        val toolbar = findViewById<Toolbar>(R.id.detail_toolbar)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            val arguments = Bundle()
            arguments.putString(ARTIST_KEY, intent.getStringExtra(ARTIST_KEY))
            arguments.putString(TRACK_KEY, intent.getStringExtra(TRACK_KEY))
            arguments.putString(IMAGE_KEY, intent.getStringExtra(IMAGE_KEY))

            val fragment = ItemDetailFragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit()
        }
    }

    companion object {
        const val ARTIST_KEY = "artist"
        const val TRACK_KEY = "track"
        const val IMAGE_KEY = "image"
    }

}