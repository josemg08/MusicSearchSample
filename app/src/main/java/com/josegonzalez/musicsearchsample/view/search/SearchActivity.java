package com.josegonzalez.musicsearchsample.view.search;

import android.os.Bundle;
import android.view.KeyEvent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.josegonzalez.musicsearchsample.R;
import com.josegonzalez.musicsearchsample.presenter.SearchPresenter;
import com.josegonzalez.musicsearchsample.view.BaseActivity;

import static com.josegonzalez.musicsearchsample.view.itemList.ItemListActivity.ITEM_LIST_DEEP_LINK;
import static com.josegonzalez.musicsearchsample.view.itemList.ItemListActivity.WORD_TO_SEARCH_KEY;

public class SearchActivity extends BaseActivity implements SearchView {

    public static final String HOME_DEEP_LINK = HOST + "home";

    private TextInputEditText editText;

    private SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        searchPresenter = new SearchPresenter(this);

        init();
    }

    private void init() {
        editText = findViewById(R.id.wordToSearch);
        editText.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                onSearchButtonPressed();
                return true;
            }
            return false;
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(v -> onSearchButtonPressed());
    }

    public void onSearchButtonPressed() {
        searchPresenter.onSearch(editText.getText().toString());
    }

    public void goToMusicList(String wordToSearch) {
        final Bundle bundle = new Bundle();
        bundle.putString(WORD_TO_SEARCH_KEY, wordToSearch);
        startActivityDeepLink(ITEM_LIST_DEEP_LINK, bundle);
    }

}
