package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.openweather.API_KEY
import com.example.openweather.api.ApiService
import com.example.weatherapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrofitインスタンスの生成
        val retrofit = Retrofit.Builder().apply {
            // APIの共通部分
            baseUrl("https://api.openweathermap.org/data/2.5/")
            // レスポンスはGsonで解析
            // GsonがCurrentWeatherのインスタンスとして返される
            addConverterFactory(GsonConverterFactory.create())
        }.build()

        // ApiServiceを実装したクラスのインスタンスを生成する
        // RetrofitがApiServiceに書いてある各APIの仕様(メソッドの定義)を読み取っている
        val apiService = retrofit.create(ApiService::class.java)

        // インターネットアクセスのためCoroutineで実行
        lifecycleScope.launch{
            try {
                val currentWeather =
                    apiService.fetchCurrentWeather("Tokyo", API_KEY)
                Log.d("currentWeather", currentWeather.toString())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }







}