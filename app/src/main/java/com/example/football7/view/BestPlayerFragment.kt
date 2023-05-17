package com.example.football7.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.football7.GOALKEEPER
import com.example.football7.HEADBUTT
import com.example.football7.R
import com.example.football7.RUNNING
import com.example.football7.adapter.PlayerAdapter
import com.example.football7.adapter.ProgressAdapter
import com.example.football7.viewmodel.BestPlayerViewModel
import com.example.football7.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.fragment_best_player.*
import kotlinx.android.synthetic.main.fragment_progress.*

class BestPlayerFragment : Fragment() {

    lateinit var recyclerViewPlayer: RecyclerView
    lateinit var adapterPlayer: PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_best_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val valueToKey = requireArguments().getString("key")!!

        val playerViewModel = ViewModelProvider(this)[BestPlayerViewModel::class.java]

        recyclerViewPlayer = id_rv_best_player
        adapterPlayer = PlayerAdapter(requireContext())
        recyclerViewPlayer.adapter = adapterPlayer

        when(valueToKey){
            RUNNING -> { playerViewModel.getPlayerRunning() }
            HEADBUTT -> { playerViewModel.getPlayerHeadbutt() }
            GOALKEEPER -> { playerViewModel.getPlayerGoalkeeper() }
        }

        playerViewModel.BestPlayer.observe(viewLifecycleOwner){ list->
            list.body().let { adapterPlayer.setList(it!!) }
        }

    }

}