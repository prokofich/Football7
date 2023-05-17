package com.example.football7.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football7.GOALKEEPER
import com.example.football7.MAIN
import com.example.football7.R
import kotlinx.android.synthetic.main.fragment_goalkeeper_save.*
import kotlinx.android.synthetic.main.fragment_running_speed.*

class GoalkeeperSaveFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_goalkeeper_save, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id_goalkeeper_button_progress.setOnClickListener {
            MAIN.replaceToProgress(GOALKEEPER)
        }

        id_goalkeeper_button_training.setOnClickListener {
            MAIN.replaceToTraining(GOALKEEPER)
        }

        id_goalkeeper_button_best.setOnClickListener {
            MAIN.replaceToBestPlayer(GOALKEEPER)
        }

    }

}