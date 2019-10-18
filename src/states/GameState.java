package states;

import MarchCubs.Block;
import MarchCubs.GridField;
import MarchCubs.Gridcell;
import core.Handler;
import entities.*;
import fontMeshCreator.FontType;
import fontMeshCreator.GUIText;
import fontRendering.TextMaster;
import guis.GuiRenderer;
import guis.GuiTexture;
import models.RawModel;
import models.TexturedModel;
import normalMappingObjConverter.NormalMappedObjLoader;
import objConverter.OBJFileLoader;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import render.Loader;
import render.MasterRenderer;
import render.OBJLoader;
import terrains.Terrain;
import textures.ModelTexture;
import textures.TerrainTexture;
import textures.TerrainTexturePack;
import toolbox.MousePicker;
import water.WaterFrameBuffers;
import water.WaterRenderer;
import water.WaterShader;
import water.WaterTile;


import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState extends State
{
    Loader loader;
    FlyCam cam=new FlyCam();
    MasterRenderer renderer;
    Light light;
    Terrain terrain;
    List<Entity> entities = new ArrayList<Entity>();
    List<Light> lights ;
    Light sun ;
    Vector3f pos;


    public GameState(Handler handler, Loader loader, MasterRenderer renderer)
    {
        super(handler);
        this.loader=loader;
        TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("grassy3"));
        TerrainTexture rTexture = new TerrainTexture(loader.loadTexture("dirt"));
        TerrainTexture gTexture = new TerrainTexture(loader.loadTexture("pinkFlowers"));
        TerrainTexture bTexture = new TerrainTexture(loader.loadTexture("mossPath256"));

        TerrainTexturePack texturePack = new TerrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
        TerrainTexture blendMap = new TerrainTexture(loader.loadTexture("blendMap"));
        terrain= new Terrain(0,-1,loader, texturePack, blendMap, "heightMap");



        this.renderer=renderer;
       lights = new ArrayList<Light>();
         sun = new Light(new Vector3f(10000, 10000, -10000), new Vector3f(1.3f, 1.3f, 1.3f));
        lights.add(sun);
        /*
            pos=new Vector3f(0,0,0);
        pas=handler.getGame().
        FontType font = new FontType(loader.loadTexture("verdana"), new File("res/verdana.fnt"));
        GUIText text = new GUIText("Main Menu", 1f, font, new Vector2f(0.2f, 0f), 1f, true);
        text.setColour(0, 0, 0);
        */
        //TexturedModel vox = new TexturedModel(OBJLoader.loadObjModel("test",  loader), new ModelTexture(loader.loadTexture("white")));
        TexturedModel box = new TexturedModel(OBJLoader.loadObjModel("box",  loader), new ModelTexture(loader.loadTexture("red")));
       entities.add(new Entity(box, new Vector3f(-10, -10, -10), 0,  0, 0, 1f));
       // entities.add(new Entity(vox, new Vector3f(0, 0, 0), 0,  0, 0, 1f));
            //GridField gr=new GridField(new Vector3f(0,0,0),new Vector3f(1,1,1));
       /* Block a=new Block();
        RawModel model = loader.loadToVAO(a.vertices,a.textureCoords,a.indices);
        TexturedModel staticModel = new TexturedModel(model,new ModelTexture(loader.loadTexture("image")));
        entities.add(new Entity(staticModel, new Vector3f(0, 0, 0), 0,  0, 0, 1f));*/
    }

    public void cleanup()
    {
        renderer.cleanUp();
        loader.cleanUp();

    }

    @Override
    public void tick() {
        if(Keyboard.isKeyDown(Keyboard.KEY_Q))
        {State.setState(handler.getGame().menustate);

        }
    }

    @Override
    public void render()
    {
        cam.acceptInput(1);
        // camera.move();
        //player.move(terrain);
        //renderer.processEntity(player);
       // renderer.processTerrain(terrain);

        for (Entity entity : entities){
            renderer.processEntity(entity);
        }
        //  renderer.render(light, camera);
        renderer.render(lights, cam);

    }
}