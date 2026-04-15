package com.example.anime_list

import android.app.Application
import com.example.anime_list.data.AppContainer
import com.example.anime_list.data.DefaultAppContainer

class MainContainer: Application(){

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}