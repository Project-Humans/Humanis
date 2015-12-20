import com.jme3.app.SimpleApplication
import com.jme3.bullet.control.RigidBodyControl
import com.jme3.light.DirectionalLight
import com.jme3.material.Material
import com.jme3.math.{Vector3f, ColorRGBA}
import com.jme3.scene.{Spatial, Geometry}
import com.jme3.terrain.geomipmap.{TerrainLodControl, TerrainQuad}
import com.jme3.terrain.heightmap.{ImageBasedHeightMap, AbstractHeightMap}
import com.jme3.texture.Texture
import com.jme3.texture.Texture.WrapMode

/**
  * Created by Denis on 31-Oct-15.
  */
object Main extends SimpleApplication {

    def main(args: Array[String]) = start()

    override def simpleInitApp(): Unit = {

        flyCam.setMoveSpeed(100)
        val sun: DirectionalLight = new DirectionalLight
        sun.setDirection(new Vector3f(-0.1f, -0.7f, -1.0f))
        rootNode.addLight(sun)

        val terrain2: TerrainQuad = TerrainBuilder.invoke()

        rootNode.attachChild(terrain2)

    }

    object TerrainBuilder {
        val heightMapImage: Texture = assetManager.loadTexture("Height map.png")
        val heightmap = new ImageBasedHeightMap(heightMapImage.getImage)
        val material = new Material(assetManager, "Common/MatDefs/Terrain/Terrain.j3md")

        val grass: Texture = assetManager.loadTexture("Textures/Terrain/splat/grass.jpg")
        val dirt: Texture = assetManager.loadTexture("Textures/Terrain/splat/dirt.jpg")
        val rock: Texture = assetManager.loadTexture("Textures/Terrain/splat/road.jpg")

        val patchSize: Int = 65

        def invoke(): TerrainQuad = {
            heightmap.load
            prepareMaterial()
            prepareTerrain
        }

        def prepareMaterial(): Unit = {
            material.setTexture("Alpha", assetManager.loadTexture("Textures/Terrain/splat/alphamap.png"))
            applyTexture("Tex1", grass, 64)
            applyTexture("Tex2", dirt, 32f)
            applyTexture("Tex3", rock, 128)
        }

        private def applyTexture(name: String, texture: Texture, size: Float): Unit = {
            texture.setWrap(WrapMode.Repeat)
            material.setFloat(name + "Scale", size)
            material.setTexture(name, texture)
        }

        def prepareTerrain: TerrainQuad = {
            val terrain = new TerrainQuad("my terrain", patchSize, 257, heightmap.getHeightMap)
            terrain.setMaterial(material)
            terrain.setLocalTranslation(0, -100, 0)
            terrain.setLocalScale(2f, 0.25f, 2f)
            terrain.addControl(new TerrainLodControl(terrain, getCamera))
            terrain.addControl(new RigidBodyControl(0))
            terrain
        }
    }


}
