package example.com.sandboxapplication.services

import example.com.sandboxapplication.models.Location
import example.com.sandboxapplication.models.LocationForecast
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WeatherApi {
//https://www.metaweather.com
    @GET("/api/location/search/")
    suspend fun getWeatherFor(@Query("query") location : String) : List<Location>

    @GET("/api/location/{woeid}")
    suspend fun getForecastForId(@Path("woeid") woeid: Int) : LocationForecast
}