import org.scalatest.FlatSpec

class HumanTest extends FlatSpec{
    val human: Human = new Human("Bob", Male)

    "Human" should "befriend with whom he speaks" in {
        val otherHuman = new Human("Marie", Female)
        human.talk(otherHuman)
        assert(human.friends contains otherHuman)
    }
}
