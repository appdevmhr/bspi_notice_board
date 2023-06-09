package com.appdevmhr.bangladeshswedenpolytechnic

import android.app.Activity
import android.content.Intent
import com.appdevmhr.bangladeshswedenpolytechnic.ui.department.Webviewer

interface funtionOfMain {

    fun intentLink(activity: Activity,url: String){
        val intent = Intent(activity, Webviewer::class.java)
        intent.putExtra("url",url)
        activity.startActivity(intent)
    }
}