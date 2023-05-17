package com.example.football7.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.football7.*
import com.example.football7.adapter.ProgressAdapter
import kotlinx.android.synthetic.main.fragment_progress.*

class ProgressFragment : Fragment() {

    lateinit var recyclerViewProgress: RecyclerView
    lateinit var adapterProgress: ProgressAdapter

    var listToResult = ArrayList<String?>()

    var valueToKey = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_progress, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        valueToKey = requireArguments().getString("key")!!

        recyclerViewProgress = id_rv_progress
        adapterProgress = ProgressAdapter(requireContext())
        recyclerViewProgress.adapter = adapterProgress

        when(valueToKey){
            RUNNING -> {
                if(MAIN.getList("keyRunning",requireContext()) != null){
                    listToResult = MAIN.getList("keyRunning",requireContext())!!
                    adapterProgress.setList(listToResult,valueToKey)
                }
            }
            GOALKEEPER -> {
                if(MAIN.getList("keyGoalkeeper",requireContext()) != null){
                    listToResult = MAIN.getList("keyGoalkeeper",requireContext())!!
                    adapterProgress.setList(listToResult,valueToKey)
                }
            }
            HEADBUTT -> {
                if(MAIN.getList("keyHeadbutt",requireContext()) != null){
                    listToResult = MAIN.getList("keyHeadbutt",requireContext())!!
                    adapterProgress.setList(listToResult,valueToKey)
                }
            }
        }




        when(valueToKey){
            RUNNING -> {
                id_progress_title.text = titleRunningToProgress
            }
            GOALKEEPER -> {
                id_progress_title.text = titleGoalkeeperToProgress
            }
            HEADBUTT -> {
                id_progress_title.text = titleHeadbuttToProgress
            }
        }

        id_progress_button_add.setOnClickListener {
            val result = id_progress_et.text.toString()
            id_progress_et.setText("")
            adapterProgress.addResultInList(result,valueToKey)
            listToResult.add(result)
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
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
    ////////////////////////////////////////////////////////////////////////////////////////////////


}