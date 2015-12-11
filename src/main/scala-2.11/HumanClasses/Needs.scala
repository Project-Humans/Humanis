package HumanClasses

class Layer(name : String*) {
    val needs = name.map(x => x -> 0)(collection.breakOut): Map[String, Int]
    def overall : Int = needs.foldLeft(0)(_+_._2) / needs.size
}


class Needs {
    val physiological = new Layer("Housing", "Accommodation", "Hunger", "Sanitation", "Fatigue")
    val security = new Layer("Stability", "Health", "Nation Security", "Internal Security", "Job")
    val social = new Layer("Communication", "Religion", "High Entertainment", "Low Entertainment", "Family", "Status Satisfaction")
    val recognition = new Layer("Social Status", "Wealth", "Notability")
    val selfRealization = new Layer("Education", "Progress")

    def satisfaction = {
        (physiological.overall + security.overall +
        social.overall + recognition.overall +
        selfRealization.overall) / 5
    }

}
