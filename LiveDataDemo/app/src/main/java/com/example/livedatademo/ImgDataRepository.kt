package com.example.livedatademo

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ImgDataRepository {
    private lateinit var urls:MutableList<String>
    private var index = -1
    private var mtempLiveData = MutableLiveData<String>()

    private fun initUrls(){
        urls = mutableListOf(
                "https://i.imgur.com/JOKsNeT.jpeg",
                "http://p1.pstatp.com/large/166200019850062839d3",
                "https://i.imgur.com/VErm2de.jpeg",
                "https://tp1.tupiankucdn.com/ws/large/006uRUASly1fz3u150rn4g308c0694qp.gif",
                "https://i.imgur.com/rfr69Pl.png",
                "https://i.imgur.com/eU04MB8.jpg",
                "https://tp1.tupiankucdn.com/ws/large/006uRUASly1fz3tm94oiug308c05kx6p.gif",
                "https://img-blog.csdnimg.cn/20201029162906380.gif#pic_center",
                "https://p.pstatp.com/origin/ffa900012b4dd6f96705"
                )
    }

    private fun getIndex(isRandom: Boolean):Int{
        if(isRandom){ return (0 until urls.size).random()}
        updateIndex()
        return index
    }

    private fun updateIndex(){
        index += 1
        index %= urls.size
    }

    fun resetIndex(){ index = -1 }

    fun getImgLiveData(isFirst:Boolean=false,isRandom:Boolean=false):MutableLiveData<String>{
        if(isFirst){initUrls()}
        mtempLiveData.value = urls[getIndex(isRandom)]
        return mtempLiveData
    }
}