package com.example.football7.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.football7.api.Repository
import com.example.football7.model.Player
import com.example.football7.model.Training
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class TrainingViewModel:ViewModel() {

    val repo = Repository()
    val Training: MutableLiveData<Response<Training>> = MutableLiveData()

    fun getTrainingRunning(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getTrainingRunning()
            withContext(Dispatchers.Main){
                Training.value = responce
            }
        }
    }

    fun getTrainingHeadbutt(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getTrainingHeadbutt()
            withContext(Dispatchers.Main){
                Training.value = responce
            }
        }
    }

    fun getTrainingGoalkeeper(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getTrainingGoalkeeper()
            withContext(Dispatchers.Main){
                Training.value = responce
            }
        }
    }

}