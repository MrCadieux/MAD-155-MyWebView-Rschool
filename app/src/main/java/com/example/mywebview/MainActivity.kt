package com.example.mywebview

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {

    lateinit var viewer: WebView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewer = findViewById(R.id.webViewer)
        webViewSetup()

    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(){
        viewer.webViewClient = WebViewClient()


        //Opens Rschool for CLS Athletics
        viewer.apply {
            loadUrl("https://clshs.rschoolteams.com/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if(viewer.canGoBack()){
            viewer.goBack()
        }
        else{
            super.onBackPressed()
        }
    }

}