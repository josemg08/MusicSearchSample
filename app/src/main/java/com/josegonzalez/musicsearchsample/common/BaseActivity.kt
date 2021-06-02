package com.josegonzalez.musicsearchsample.common

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected fun startActivityDeepLink(deepLink: String?, extras: Bundle?) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
        if (extras != null) {
            intent.putExtras(extras)
            startActivityForResult(intent.setPackage(packageName)
                    .putExtra(INTERNAL_KEY, true), DEFAULT_REQUEST_CODE)
        }
    }

    companion object {
        private const val DEFAULT_REQUEST_CODE = 1
        private const val INTERNAL_KEY = "internal"
    }

}