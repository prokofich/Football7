package com.example.football7.view.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.football7.model.constant.APP_PREFERENCES
import com.example.football7.model.constant.ID
import com.example.football7.databinding.ActivitySplashBinding
import com.example.football7.viewmodel.SplashViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private var binding: ActivitySplashBinding? = null
    private var job:Job? = null

    private var namePhone = ""
    private var locale = ""
    private var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        Glide.with(this)
            .load("http://37.27.9.28/7/backgroundsplash.jpeg")
            .into(binding?.idSplashImageview!!)

        val splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        namePhone = Build.MODEL.toString()
        locale = Locale.getDefault().displayLanguage.toString()

        if (getMyId().isNotEmpty()){
            id = getMyId()
        }else{
            id = UUID.randomUUID().toString()
            setMyId(id)
        }

        splashViewModel.setPostParametersPhone(namePhone,locale,id)

        splashViewModel.webViewUrl.observe(this){ responce ->
            when(responce.body()!!.url){
                "no" -> { goToMainPush() }
                "nopush" -> { goToMainNoPush() }
                else -> { goToWeb(responce.body()!!.url) }
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(job?.isActive == true){
            job?.cancel()
        }
    }

    private fun getMyId():String{
        return getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getString(ID,"").toString()
    }

    private fun setMyId(id:String){
        val preferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        preferences.edit()
            .putString(ID,id)
            .apply()
    }

    private fun goToMainPush() {
        job = CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goToMainNoPush() {
        job = CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            intent.putExtra("url","nopush")
            startActivity(intent)
        }
    }

    private fun goToWeb(url:String) {
        job = CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            val intent = Intent(this@SplashActivity, WebViewActivity::class.java)
            intent.putExtra("url",url)
            startActivity(intent)
        }
    }

}