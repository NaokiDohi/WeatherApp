package com.example.openweather

data class CurrentWeather(
    val weather: List<Weather>,
    val main: Main
){
    data class Weather(
        val id: Int,
        val main: String,
        val description: String,
    )

    data class Main(
        val temp: Double,
    )
}

// 参照
//https://openweathermap.org/current

//https://api.openweathermap.org/data/2.5/weather?q=都市の名前&appid=各自のAPIKey}
//のレスポンス(Json)に合わせたクラスを作成。
