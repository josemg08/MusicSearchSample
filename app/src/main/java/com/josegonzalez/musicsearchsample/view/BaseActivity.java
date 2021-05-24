package com.josegonzalez.musicsearchsample.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private static int DEFAULT_REQUEST_CODE = 1;

    private static final String INTERNAL_KEY = "internal";

    protected static final String SCHEME = "musicsearch://";
    protected static final String HOST = SCHEME + "jose/";

    protected void startActivityDeepLink(final String deepLink, @Nullable final Bundle extras) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(deepLink));
        if (extras != null) {
            intent.putExtras(extras);
            startActivityForResult(intent.setPackage(getPackageName()).putExtra(INTERNAL_KEY, true), DEFAULT_REQUEST_CODE);
        }
    }

}
