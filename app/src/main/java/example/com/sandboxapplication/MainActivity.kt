package example.com.sandboxapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import example.com.sandboxapplication.services.WeatherFetchManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    lateinit var forecastAdapter : ForecastAdapter

    private val weatherFetchManager = WeatherFetchManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lifecycleScope.launch {
            val response = weatherFetchManager.fetchForecastFor("new york")
            Log.d(TAG, response.consolidated_weather[0].applicable_date)

            val forecastAdapter = ForecastAdapter(this@MainActivity, response.consolidated_weather)

            forecast_list.layoutManager = LinearLayoutManager(this@MainActivity).apply {
                orientation = RecyclerView.VERTICAL
            }
            forecast_list.adapter = forecastAdapter

        }
    }
}
