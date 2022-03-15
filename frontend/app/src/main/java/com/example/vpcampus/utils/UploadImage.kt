package com.example.vpcampus.utils

import android.content.Context
import android.net.Uri
import android.util.Log
import com.cloudinary.android.MediaManager
import com.cloudinary.android.callback.ErrorInfo
import com.cloudinary.android.callback.UploadCallback
import com.example.vpcampus.models.Avatar

class UploadImage(
    private val context:Context
) {

   private fun initConfig(){
            val config: MutableMap<String,Any> = HashMap()
            config["cloud_name"] = "dmewli5b4"
            config["api_key"] = "826232252792938"
            config["api_secret"] = "GUuGtd2mRKNgOvAgi7ADaq23ZGE"
            MediaManager.init(context, config)
    }

    fun upload(url:Uri,callback: UploadCallback){
        initConfig()
        MediaManager.get().upload(url).callback(callback).dispatch()
    }

}