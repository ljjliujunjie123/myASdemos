package com.example.livedatademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImgViewModel: ViewModel() {
    private var ImgLiveData = MutableLiveData<String>()
    private var ImgDataRepository = ImgDataRepository()

    fun getMyImgLiveData():MutableLiveData<String>{
        if(ImgLiveData.value==null){
            initImgLiveData()
        }
        return ImgLiveData
    }

    fun initImgLiveData(){
        ImgLiveData = ImgDataRepository.getImgLiveData(isFirst = true)
    }

    fun changeValue(MODE:String="Seq") = when(MODE){
        "Seq"-> ImgLiveData = ImgDataRepository.getImgLiveData()
        "RANDOM" -> ImgLiveData = ImgDataRepository.getImgLiveData(isRandom = true)
        else -> {}
    }

    fun reset(){
        ImgDataRepository.resetIndex()
        ImgLiveData = ImgDataRepository.getImgLiveData(isFirst = true)
    }
}