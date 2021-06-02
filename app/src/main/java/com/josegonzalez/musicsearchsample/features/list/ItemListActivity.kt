package com.josegonzalez.musicsearchsample.features.list

import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.josegonzalez.musicsearchsample.R
import com.josegonzalez.musicsearchsample.common.BaseActivity
import com.josegonzalez.musicsearchsample.common.ITEM_DETAIL_DEEP_LINK
import com.josegonzalez.musicsearchsample.features.detail.ItemDetailActivity
import com.josegonzalez.musicsearchsample.features.list.CustomAdapter.TrackAdapterCallback
import com.josegonzalez.musicsearchsample.model.TrackListDto

class ItemListActivity : BaseActivity(), ItemListView, TrackAdapterCallback {

    private var wordToSearch: String? = null
    private var errorMessage: TextView? = null
    private var spinner: Spinner? = null
    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var itemListPresenter: ItemListPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)
        itemListPresenter = ItemListPresenter(this)
        init()
    }

    private fun init() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title
        initRecyclerView()
        errorMessage = findViewById(R.id.error_message)
        spinner = findViewById(R.id.spinner)
        onLoading()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        initItemList()
    }

    private fun initItemList() {
        if (intent != null && intent.extras != null) {
            val extras = intent.extras
            wordToSearch = extras!!.getString(WORD_TO_SEARCH_KEY)
            if (itemListPresenter != null) {
                itemListPresenter!!.searchWord(wordToSearch)
            }
        }
    }

    override fun addTrackList(listDto: TrackListDto?) {
        recyclerView!!.visibility = View.VISIBLE
        errorMessage!!.visibility = View.GONE
        spinner!!.visibility = View.GONE
        adapter = CustomAdapter(listDto!!.results, this)
        recyclerView!!.adapter = adapter
    }

    override fun onError() {
        recyclerView!!.visibility = View.GONE
        errorMessage!!.visibility = View.VISIBLE
        spinner!!.visibility = View.GONE
    }

    override fun onLoading() {
        recyclerView!!.visibility = View.GONE
        errorMessage!!.visibility = View.GONE
        spinner!!.visibility = View.VISIBLE
    }

    override fun showDetails(artistName: String?, trackName: String?, imageUrl: String?) {
        val bundle = Bundle()
        bundle.putString(ItemDetailActivity.ARTIST_KEY, artistName)
        bundle.putString(ItemDetailActivity.TRACK_KEY, trackName)
        bundle.putString(ItemDetailActivity.IMAGE_KEY, imageUrl)
        startActivityDeepLink(ITEM_DETAIL_DEEP_LINK, bundle)
    }

    override fun onListItemClicked(position: Int) {
        itemListPresenter!!.onItemSelected(position)
    }

    companion object {
        const val WORD_TO_SEARCH_KEY = "word"
    }

}