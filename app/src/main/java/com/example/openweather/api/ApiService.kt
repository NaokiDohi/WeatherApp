package com.example.openweather.api

import com.example.openweather.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Query


// 呼び出したいエンドポイントにつき1つメソッドを定義
// このインタフェースは RetrofitにAPIの仕様を伝えるために作る
// そのためこのインタフェースを実装するクラスを別途作る必要はない

interface ApiService {
    @GET("weather")
    suspend fun fetchCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String
    ): CurrentWeather
}