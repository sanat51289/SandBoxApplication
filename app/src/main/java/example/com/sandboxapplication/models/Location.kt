package example.com.sandboxapplication.models

//"location_type":"City","woeid":2459115,"latt_long":"40.71455,-74.007118"}]
data class Location(val title: String,
                    val location_type: String,
                    val woeid: Int,
                    val lat_long: String){
}