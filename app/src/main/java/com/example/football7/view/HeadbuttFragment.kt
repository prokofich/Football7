package com.example.football7.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football7.HEADBUTT
import com.example.football7.MAIN
import com.example.football7.R
import kotlinx.android.synthetic.main.fragment_headbutt.*
import kotlinx.android.synthetic.main.fragment_running_speed.*
import retrofit2.http.HEAD


class HeadbuttFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_headbutt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id_headbutt_button_progress.setOnClickListener {
            MAIN.replaceToProgress(HEADBUTT)
        }

        id_headbutt_button_training.setOnClickListener {
            MAIN.replaceToTraining(HEADBUTT)
        }

        id_headbutt_button_best.setOnClickListener {
            MAIN.replaceToBestPlayer(HEADBUTT)
        }

    }


}