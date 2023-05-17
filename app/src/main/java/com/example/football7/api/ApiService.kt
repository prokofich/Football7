package com.example.football7.api

import com.example.football7.model.Player
import com.example.football7.model.ResponceWebView
import com.example.football7.model.Training
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("splash.php")
    suspend fun setPostParametersPhone(
        @Field("phone_name") phone_name:String,
        @Field("locale") locale:String,
        @Field("unique") unique:String
    ): Response<ResponceWebView>

    @GET("7/running.json")
    suspend fun getPlayerRunning():Response<Player>

    @GET("7/headbutt.json")
    suspend fun getPlayerHeadbutt():Response<Player>

    @GET("7/goalkeeper.json")
    suspend fun getPlayerGoalkeeper():Response<Player>


    @GET("7/runningtraining.json")
    suspend fun getTrainingRunning():Response<Training>

    @GET("7/headbutttraining.json")
    suspend fun getTrainingHeadbutt():Response<Training>

    @GET("7/goalkeepertraining.json")
    suspend fun getTrainingGoalkeeper():Response<Training>
}