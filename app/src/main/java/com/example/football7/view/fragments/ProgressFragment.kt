package com.example.football7.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.football7.databinding.FragmentProgressBinding
import com.example.football7.model.adapter.ProgressAdapter
import com.example.football7.model.constant.GOALKEEPER
import com.example.football7.model.constant.HEADBUTT
import com.example.football7.model.constant.MAIN
import com.example.football7.model.constant.RUNNING
import com.example.football7.model.constant.titleGoalkeeperToProgress
import com.example.football7.model.constant.titleHeadbuttToProgress
import com.example.football7.model.constant.titleRunningToProgress

class ProgressFragment : Fragment() {

    private var binding: FragmentProgressBinding? = null

    private var recyclerViewProgress: RecyclerView? = null
    private var adapterProgress: ProgressAdapter? = null

    private var listToResult = ArrayList<String?>()
    private var valueToKey = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        valueToKey = requireArguments().getString("key")!!

        recyclerViewProgress = binding?.idRvProgress
        adapterProgress = ProgressAdapter(requireContext())
        recyclerViewProgress?.adapter = adapterProgress

        when(valueToKey){
            RUNNING -> {
                if(MAIN.getList("keyRunning",requireContext()) != null){
                    listToResult = MAIN.getList("keyRunning",requireContext())!!
                    adapterProgress?.setList(listToResult,valueToKey)
                }
            }
            GOALKEEPER -> {
                if(MAIN.getList("keyGoalkeeper",requireContext()) != null){
                    listToResult = MAIN.getList("keyGoalkeeper",requireContext())!!
                    adapterProgress?.setList(listToResult,valueToKey)
                }
            }
            HEADBUTT -> {
                if(MAIN.getList("keyHeadbutt",requireContext()) != null){
                    listToResult = MAIN.getList("keyHeadbutt",requireContext())!!
                    adapterProgress?.setList(listToResult,valueToKey)
                }
            }
        }

        when(valueToKey){
            RUNNING -> {
                binding?.idProgressTitle?.text = titleRunningToProgress
            }
            GOALKEEPER -> {
                binding?.idProgressTitle?.text = titleGoalkeeperToProgress
            }
            HEADBUTT -> {
                binding?.idProgressTitle?.text = titleHeadbuttToProgress
            }
        }

        binding?.idProgressButtonAdd?.setOnClickListener {
            val result = binding?.idProgressEt?.text.toString()
            binding?.idProgressEt?.setText("")
            adapterProgress?.addResultInList(result,valueToKey)
            listToResult.add(result)
        }

    }

    override fun onStop() {
        super.onStop()

        when(valueToKey){
            RUNNING -> {
                MAIN.saveList(listToResult,"keyRunning",requireContext())
            }
            GOALKEEPER -> {
                MAIN.saveList(listToResult,"keyGoalkeeper",requireContext())
            }
            HEADBUTT -> {
                MAIN.saveList(listToResult,"keyHeadbutt",requireContext())
            }
        }
        listToResult.clear()
        valueToKey = ""

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}