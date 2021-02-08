package my.project.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // to be able of using webview in android we should add internet permission first
        // go to manifest add permission
        //we will add google as a default web page when our activity load
        web_browser.loadUrl( url: "http://www.google.com")
        web_browser.settings.javaScriptEnabled=true // we need to enable javascript
        web_browser.canGoBack()
        web_browser.wbViewClient = WebClient(activity: this)
        //Now we need to load an url everytime we search something
        search_btn.setOnClickListener { it: View!
            val URL: String = url_txt.text.toString()
            web_browser.loadUrl(URL)
        }

        //now we will add the script to return back
        back_btn.setOnClickListener {it: View!
            web_browser.goBack()
        }



        //before we test our app we need to create a webclient class


    }


    class_WebClient intenal constructor(private val_activity: Activity): WebViewClient(){
        override fun shouldOverrideUrlLoading(
            view: WebView? ,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return  true
        }
        )
    }
}