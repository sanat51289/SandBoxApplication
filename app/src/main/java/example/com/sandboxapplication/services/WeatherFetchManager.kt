package example.com.sandboxapplication.services

import example.com.sandboxapplication.models.Location
import example.com.sandboxapplication.models.LocationForecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherFetchManager {


    private val weatherEndpoint : WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(WeatherApi::class.java)
    }


    suspend fun fetchForecastFor(location: String) : LocationForecast {
        return withContext(Dispatchers.IO) {
            val locationInfo = weatherEndpoint.getWeatherFor(location)
            weatherEndpoint.getForecastForId(locationInfo[0].woeid)
        }
    }

    companion object {
        const val BASE_URL = "https://www.metaweather.com/"
    }
}