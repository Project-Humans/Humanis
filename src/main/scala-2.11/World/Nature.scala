package World

/**
 * Created by Dmitrij on 11.12.2015.
 */
sealed trait Season
case object Winter extends Season
case object Spring extends Season
case object Summer extends Season
case object Fall extends Season

sealed trait WeatherCondition
case object Rain extends WeatherCondition
case object Sunny extends WeatherCondition
case object Cloudy extends WeatherCondition
case object Snowy extends WeatherCondition
case object Thunder extends WeatherCondition
case object Drought extends WeatherCondition
case object Hail extends WeatherCondition
case object Blizzard extends WeatherCondition
case object Fog extends WeatherCondition



 class Weather(var temperature : Int, var weatherCondition : WeatherCondition){

}

object Nature {
  var dayTime : Int = 0
  var day : Int = 0
  var currentSeason : Season = Spring
  var currentWeather = new Weather(0, Sunny)

  def currentWeatherCondition : WeatherCondition = {currentWeather.weatherCondition};

  def currentTemperature : Int = {currentWeather.temperature}

  def dayPass : Unit = {
    day += 1
  }

  def minutePass(timeSpeed : Int) : Unit = {
    if (dayTime < 1440){
        dayPass
        dayTime = 0
    }
    else dayTime+=1
  }
}
