package com.appdevmhr.bangladeshswedenpolytechnic.ui.department

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.ActivityWebviewerBinding

open class Webviewer : AppCompatActivity() {
    private lateinit var binding: ActivityWebviewerBinding
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var url = intent.getStringExtra("url")
        binding.webView2.setOnClickListener {
            if (url != null) {
                binding.webView2.loadUrl(url)
                Toast.makeText(this,url, Toast.LENGTH_SHORT).show()
                binding.webView2.webViewClient = WebViewClient()
                binding.webView2.settings.loadsImagesAutomatically = true
                binding.webView2.settings.javaScriptEnabled = true
            }else{
                Toast.makeText(this,"url", Toast.LENGTH_SHORT).show()

            }



        }

    }
}