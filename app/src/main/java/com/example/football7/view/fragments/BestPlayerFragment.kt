package com.example.football7.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.football7.model.constant.GOALKEEPER
import com.example.football7.model.constant.HEADBUTT
import com.example.football7.R
import com.example.football7.databinding.FragmentBestPlayerBinding
import com.example.football7.model.constant.RUNNING
import com.example.football7.model.adapter.PlayerAdapter
import com.example.football7.viewmodel.BestPlayerViewModel
import kotlinx.android.synthetic.main.fragment_best_player.*

class BestPlayerFragment : Fragment() {

    private var binding:FragmentBestPlayerBinding? = null
    private var recyclerViewPlayer: RecyclerView? = null
    private var adapterPlayer: PlayerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBestPlayerBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val valueToKey = requireArguments().getString("key")!!

        val playerViewModel = ViewModelProvider(this)[BestPlayerViewModel::class.java]

        recyclerViewPlayer = binding?.idRvBestPlayer
        adapterPlayer = PlayerAdapter(requireContext())
        recyclerViewPlayer?.adapter = adapterPlayer

        when(valueToKey){
            RUNNING -> { playerViewModel.getPlayerRunning() }
            HEADBUTT -> { playerViewModel.getPlayerHeadbutt() }
            GOALKEEPER -> { playerViewModel.getPlayerGoalkeeper() }
        }

        playerViewModel.bestPlayer.observe(viewLifecycleOwner){ list->
            list.body().let { adapterPlayer?.setList(it) }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}