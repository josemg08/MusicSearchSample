package com.josegonzalez.musicsearchsample.features.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.josegonzalez.musicsearchsample.R
import com.josegonzalez.musicsearchsample.common.BaseActivity
import com.josegonzalez.musicsearchsample.common.ITEM_LIST_DEEP_LINK
import com.josegonzalez.musicsearchsample.features.list.ItemListActivity

class SearchActivity : BaseActivity(), SearchView {

    private var editText: TextInputEditText? = null
    private var searchPresenter: SearchPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)
        searchPresenter = SearchPresenter(this)
        init()
    }

    private fun init() {
        editText = findViewById(R.id.wordToSearch)
        if (editText != null) {
            editText!!.setOnKeyListener(View.OnKeyListener { _: View?, keyCode: Int, event: KeyEvent ->
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    onSearchButtonPressed()
                    return@OnKeyListener true
                }
                false
            })
        }
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fab)
        floatingActionButton.setOnClickListener { onSearchButtonPressed() }
    }

    override fun onSearchButtonPressed() {
        searchPresenter!!.onSearch(editText!!.text.toString())
    }

    override fun goToMusicList(wordToSearch: String?) {
        val bundle = Bundle()
        bundle.putString(ItemListActivity.WORD_TO_SEARCH_KEY, wordToSearch)
        startActivityDeepLink(ITEM_LIST_DEEP_LINK, bundle)
    }

}