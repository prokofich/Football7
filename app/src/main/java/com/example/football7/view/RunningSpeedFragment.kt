package com.example.football7.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football7.MAIN
import com.example.football7.R
import com.example.football7.RUNNING
import kotlinx.android.synthetic.main.fragment_running_speed.*

class RunningSpeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_running_speed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id_running_button_progress.setOnClickListener {
            MAIN.replaceToProgress(RUNNING)
        }

        id_running_button_training.setOnClickListener {
            MAIN.replaceToTraining(RUNNING)
        }

        id_running_button_best.setOnClickListener {
            MAIN.replaceToBestPlayer(RUNNING)
        }

    }

}