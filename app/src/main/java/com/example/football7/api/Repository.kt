package com.example.football7.api

import com.example.football7.model.Player
import com.example.football7.model.ResponceWebView
import com.example.football7.model.Training
import retrofit2.Response

class Repository {

    suspend fun getPlayerRunning(): Response<Player> {
        return RetrofitInstance.api.getPlayerRunning()
    }

    suspend fun getPlayerHeadbutt(): Response<Player> {
        return RetrofitInstance.api.getPlayerHeadbutt()
    }

    suspend fun getPlayerGoalkeeper(): Response<Player> {
        return RetrofitInstance.api.getPlayerGoalkeeper()
    }


    suspend fun getTrainingRunning(): Response<Training> {
        return RetrofitInstance.api.getTrainingRunning()
    }

    suspend fun getTrainingHeadbutt(): Response<Training> {
        return RetrofitInstance.api.getTrainingHeadbutt()
    }

    suspend fun getTrainingGoalkeeper(): Response<Training> {
        return RetrofitInstance.api.getTrainingGoalkeeper()
    }


    suspend fun setParametersPhone(phone_name:String,locale:String,unique:String):Response<ResponceWebView>{
        return RetrofitInstance.api.setPostParametersPhone(phone_name, locale, unique)
    }

}