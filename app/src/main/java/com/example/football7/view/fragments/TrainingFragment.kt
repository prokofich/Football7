package com.example.football7.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.football7.model.constant.GOALKEEPER
import com.example.football7.model.constant.HEADBUTT
import com.example.football7.R
import com.example.football7.databinding.FragmentRunningSpeedBinding
import com.example.football7.databinding.FragmentTrainingBinding
import com.example.football7.model.constant.RUNNING
import com.example.football7.viewmodel.TrainingViewModel
import kotlinx.android.synthetic.main.fragment_training.*

class TrainingFragment : Fragment() {

    private var binding: FragmentTrainingBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainingBinding.inflate(inflater, container, false)
        return binding?.root
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

        trainingViewModel.training.observe(viewLifecycleOwner){ list->
            binding?.idTrainingNamePlayer1?.text = list.body()!![0].name
            binding?.idTrainingNamePlayer2?.text = list.body()!![1].name
            binding?.idTrainingNamePlayer3?.text = list.body()!![2].name
            binding?.idTrainingText1?.text = list.body()!![0].training
            binding?.idTrainingText2?.text = list.body()!![1].training
            binding?.idTrainingText3?.text = list.body()!![2].training
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}