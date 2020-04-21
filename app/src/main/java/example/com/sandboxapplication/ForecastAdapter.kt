package example.com.sandboxapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import example.com.sandboxapplication.models.Forecast


class ForecastAdapter(
    private val context: Context,
    private val forecastList: List<Forecast>) : RecyclerView.Adapter<ForecastViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {

        return ForecastViewHolder(layoutInflater.inflate(R.layout.forecast_list_item, parent, false))

    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {

        holder.setForecast(forecastList[position])
    }
}

class ForecastViewHolder(private val listItemView: View) : RecyclerView.ViewHolder(listItemView) {
    private val header = listItemView.findViewById<TextView>(R.id.header)
    private val minTemp =listItemView.findViewById<TextView>(R.id.min_temp)
    private val maxTemp =listItemView.findViewById<TextView>(R.id.max_temp)

    fun setForecast(forecast: Forecast) {

        header.text = forecast.applicable_date
        minTemp.text = forecast.min_temp.toString()
        maxTemp.text = forecast.max_temp.toString()
    }

}
