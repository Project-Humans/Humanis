package World

/**
 * Created by Dmitrij on 11.12.2015.
 */
sealed trait Season
case object Winter extends Season
case object Spring extends Season
case object Summer extends Season
case object Fall extends Season

sealed trait WeatherConditions
case object Rain extends WeatherConditions
case object Sunny extends WeatherConditions
case object Cloudy extends WeatherConditions
case object Snowy extends WeatherConditions
case object Thunder extends WeatherConditions
case object Drought extends WeatherConditions
case object Hail extends WeatherConditions
case object Blizzard extends WeatherConditions
case object Fog extends WeatherConditions



 class Weather(var temperature : Int, var currentWeatherConditions : WeatherConditions){

}

object Nature {
  var dayTime : Int = 0;
  var day : Int = 0;
  var currentSeason : Season = Spring;
  var currentWeather = new Weather(0, Sunny);

  def currentWeatherCondition : WeatherConditions = {currentWeather.currentWeatherConditions};

  def currentTemperature : Int = {currentWeather.temperature}

  def dayPass : Unit = {
    day += 1;
  }

  def minutePass(timeSpeed : Int) : Unit = {
    if (dayTime < 1440){
        dayPass;
        dayTime = 0;
    }
    else dayTime+=1;
  }
}
