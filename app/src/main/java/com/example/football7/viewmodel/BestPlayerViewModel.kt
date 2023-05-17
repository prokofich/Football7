package com.example.football7.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.football7.api.Repository
import com.example.football7.model.Player
import com.google.android.gms.common.config.GservicesValue.value
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class BestPlayerViewModel:ViewModel() {

    val repo = Repository()
    val BestPlayer:MutableLiveData<Response<Player>> = MutableLiveData()

    fun getPlayerRunning(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getPlayerRunning()
            withContext(Dispatchers.Main){
                BestPlayer.value = responce
            }
        }
    }

    fun getPlayerHeadbutt(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getPlayerHeadbutt()
            withContext(Dispatchers.Main){
                BestPlayer.value = responce
            }
        }
    }

    fun getPlayerGoalkeeper(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getPlayerGoalkeeper()
            withContext(Dispatchers.Main){
                BestPlayer.value = responce
            }
        }
    }


}