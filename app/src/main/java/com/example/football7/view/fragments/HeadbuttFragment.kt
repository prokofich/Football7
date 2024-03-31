package com.example.football7.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football7.model.constant.HEADBUTT
import com.example.football7.databinding.FragmentHeadbuttBinding
import com.example.football7.model.constant.MAIN

class HeadbuttFragment : Fragment() {

    private var binding: FragmentHeadbuttBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeadbuttBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.idHeadbuttButtonProgress?.setOnClickListener {
            MAIN.replaceToProgress(HEADBUTT)
        }

        binding?.idHeadbuttButtonTraining?.setOnClickListener {
            MAIN.replaceToTraining(HEADBUTT)
        }

        binding?.idHeadbuttButtonBest?.setOnClickListener {
            MAIN.replaceToBestPlayer(HEADBUTT)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}