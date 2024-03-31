package com.example.football7.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football7.model.constant.GOALKEEPER
import com.example.football7.model.constant.MAIN
import com.example.football7.databinding.FragmentGoalkeeperSaveBinding

class GoalkeeperSaveFragment : Fragment() {

    private var binding: FragmentGoalkeeperSaveBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGoalkeeperSaveBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.idGoalkeeperButtonProgress?.setOnClickListener {
            MAIN.replaceToProgress(GOALKEEPER)
        }

        binding?.idGoalkeeperButtonTraining?.setOnClickListener {
            MAIN.replaceToTraining(GOALKEEPER)
        }

        binding?.idGoalkeeperButtonBest?.setOnClickListener {
            MAIN.replaceToBestPlayer(GOALKEEPER)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}