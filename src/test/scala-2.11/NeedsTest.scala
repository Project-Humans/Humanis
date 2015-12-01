import org.scalatest.FlatSpec

class NeedsTest extends FlatSpec{
    val layer: Layer = new Layer("Hunger", "Fatigue", "Housing")
    "Layer" should "have 0 overall on create" in {
        assert(layer.overall == 0)
    }

    val needs = new Needs()
    "Needs" should "have 0 satisfaction on create" in {
        assert(needs.satisfaction == 0)
    }
}
