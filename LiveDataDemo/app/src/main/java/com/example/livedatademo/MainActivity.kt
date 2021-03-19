package com.example.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel: ImgViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = ViewModelProviders.of(this).get(ImgViewModel()::class.java)
        btn_change.setOnClickListener { myViewModel.changeValue() }
        btn_random.setOnClickListener { myViewModel.changeValue(MODE="RANDOM") }
        btn_reset.setOnClickListener { myViewModel.reset() }
        myViewModel.getMyImgLiveData().observe(this, Observer{url->
            Glide.with(this).load(url).into(image_view);
        })
    }
}