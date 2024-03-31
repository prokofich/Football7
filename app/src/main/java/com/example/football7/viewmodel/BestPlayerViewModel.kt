package com.example.football7.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.football7.model.repository.Repository
import com.example.football7.model.modelDataFromServer.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class BestPlayerViewModel:ViewModel() {

    private val repo = Repository()
    val bestPlayer:MutableLiveData<Response<Player>> = MutableLiveData()

    fun getPlayerRunning(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getPlayerRunning()
            withContext(Dispatchers.Main){
                bestPlayer.value = responce
            }
        }
    }

    fun getPlayerHeadbutt(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getPlayerHeadbutt()
            withContext(Dispatchers.Main){
                bestPlayer.value = responce
            }
        }
    }

    fun getPlayerGoalkeeper(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getPlayerGoalkeeper()
            withContext(Dispatchers.Main){
                bestPlayer.value = responce
            }
        }
    }


}