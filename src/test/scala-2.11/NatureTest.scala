import World._
import org.scalatest.FlatSpec

/**
 * Created by Dmitrij on 11.12.2015.
 */
class NatureTest extends FlatSpec {
  val nature = Nature;
  "Nature.currentSeason" should "be Spring in basic state" in {
    assert(nature.currentSeason == Spring)
  }

  "Nature.currentTemperature" should "be 0 in basic state" in {
    assert(nature.currentTemperature == 0)
  }

  "Nature.currentWeatherCondition " should "be sunny" in {
    assert(nature.currentWeatherCondition == Sunny)
  }



}
