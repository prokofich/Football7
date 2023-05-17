package com.example.football7.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.football7.GOALKEEPER
import com.example.football7.HEADBUTT
import com.example.football7.R
import com.example.football7.RUNNING
import com.example.football7.viewmodel.TrainingViewModel
import kotlinx.android.synthetic.main.fragment_training.*

class TrainingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_training, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val valueToKey = requireArguments().getString("key")!!

        val trainingViewModel = ViewModelProvider(this)[TrainingViewModel::class.java]

        when(valueToKey){
            RUNNING -> { trainingViewModel.getTrainingRunning() }
            HEADBUTT -> { trainingViewModel.getTrainingHeadbutt() }
            GOALKEEPER -> { trainingViewModel.getTrainingGoalkeeper() }
        }

        trainingViewModel.Training.observe(viewLifecycleOwner){ list->
            id_training_name_player1.text = list.body()!![0].name
            id_training_name_player2.text = list.body()!![1].name
            id_training_name_player3.text = list.body()!![2].name
            id_training_text1.text = list.body()!![0].training
            id_training_text2.text = list.body()!![1].training
            id_training_text3.text = list.body()!![2].training
        }


    }


}