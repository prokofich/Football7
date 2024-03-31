package com.example.football7.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football7.model.constant.MAIN
import com.example.football7.R
import com.example.football7.databinding.FragmentProgressBinding
import com.example.football7.databinding.FragmentRunningSpeedBinding
import com.example.football7.model.constant.RUNNING
import kotlinx.android.synthetic.main.fragment_running_speed.*

class RunningSpeedFragment : Fragment() {

    private var binding: FragmentRunningSpeedBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRunningSpeedBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.idRunningButtonProgress?.setOnClickListener {
            MAIN.replaceToProgress(RUNNING)
        }

        binding?.idRunningButtonTraining?.setOnClickListener {
            MAIN.replaceToTraining(RUNNING)
        }

        binding?.idRunningButtonBest?.setOnClickListener {
            MAIN.replaceToBestPlayer(RUNNING)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}