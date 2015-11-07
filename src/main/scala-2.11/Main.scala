import com.jme3.app.SimpleApplication
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box

/**
 * Created by Denis on 31-Oct-15.
 */
object Main extends SimpleApplication{

    def main(args: Array[String]) = start

    override def simpleInitApp(): Unit = {

        val b: Box = new Box(1, 1, 1); // create cube shape
        val geom: Geometry = new Geometry("Box", b)
        val mat: Material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md")
        mat.setColor("Color", ColorRGBA.Blue)
        geom.setMaterial(mat)
        rootNode.attachChild(geom)
    }
}
