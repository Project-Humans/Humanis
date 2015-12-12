package HumanClasses

sealed trait Gender
case object Male extends Gender
case object Female extends Gender

class Human(val name: String, val gender: Gender) {
    var skills = Map[String, Int]()
    var friends  = Map[Human, Int]()
    var needs = new Needs()

    def talk(human: Human): Unit = {
        friends += (human -> 0)
    }

    def happiness = needs.satisfaction
}
