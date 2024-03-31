package com.example.football7.view.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.football7.model.constant.MAIN
import com.example.football7.R
import com.example.football7.databinding.ActivityMainBinding
import com.example.football7.view.fragments.BestPlayerFragment
import com.example.football7.view.fragments.GoalkeeperSaveFragment
import com.example.football7.view.fragments.HeadbuttFragment
import com.example.football7.view.fragments.ProgressFragment
import com.example.football7.view.fragments.RunningSpeedFragment
import com.example.football7.view.fragments.TrainingFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.onesignal.OneSignal
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private val goalkeeperSaveFragment = GoalkeeperSaveFragment()
    private val headbuttFragment = HeadbuttFragment()
    private val runningSpeedFragment = RunningSpeedFragment()
    private val progressFragment = ProgressFragment()
    private val bestPlayerFragment = BestPlayerFragment()
    private val trainingFragment = TrainingFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        if(intent.getStringExtra("url") == "nopush"){
            OneSignal.disablePush(true)
        }

        MAIN = this

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        replaceFragment(runningSpeedFragment)
        binding?.bottomNavigation?.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.id_menu_running -> replaceFragment(runningSpeedFragment)
                R.id.id_menu_headbutt -> replaceFragment(headbuttFragment)
                R.id.id_menu_goalkeeper -> replaceFragment(goalkeeperSaveFragment)
            }
            true
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }

    fun replaceToProgress(str:String){
        val bundle = Bundle()
        bundle.putString("key",str)
        progressFragment.arguments = bundle
        replaceFragment(progressFragment)
    }

    fun replaceToTraining(str:String){
        val bundle = Bundle()
        bundle.putString("key",str)
        trainingFragment.arguments = bundle
        replaceFragment(trainingFragment)
    }

    fun replaceToBestPlayer(str:String){
        val bundle = Bundle()
        bundle.putString("key",str)
        bestPlayerFragment.arguments = bundle
        replaceFragment(bestPlayerFragment)
    }

    fun saveList(list: ArrayList<String?>?, key: String,context: Context) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }

    fun getList(key: String,context: Context): ArrayList<String?>? {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val gson = Gson()
        val json: String? = prefs.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return gson.fromJson(json, type)
    }

}