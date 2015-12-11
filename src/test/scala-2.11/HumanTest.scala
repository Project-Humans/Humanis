import HumanClasses.{Male, Human, Female}
import org.scalatest.FlatSpec

class HumanTest extends FlatSpec{
    val human: Human = new Human("Bob", Male)

    "HumanClasses.Human" should "have 0 happiness" in {
        assert(human.happiness == 0)
    }

    it should "befriend with whom he speaks" in {
        val otherHuman = new Human("Marie", Female)
        human.talk(otherHuman)
        assert(human.friends contains otherHuman)
    }
}
