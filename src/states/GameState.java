package states;

import core.Handler;
import entities.Entity;
import entities.FlyCam;
import entities.Light;
import models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;
import render.Loader;
import render.MasterRenderer;
import render.OBJLoader;
import terrains.Terrain;
import textures.ModelTexture;
import textures.TerrainTexture;
import textures.TerrainTexturePack;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameState extends State
{
    Loader loader;
    FlyCam cam=new FlyCam();
    MasterRenderer renderer;
    Light light;
    Terrain terrain;
    List<Entity> entities = new ArrayList<Entity>();

    public GameState(Loader loader,MasterRenderer renderer)
    {
this.loader=loader;
        TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("grassy3"));
        TerrainTexture rTexture = new TerrainTexture(loader.loadTexture("dirt"));
        TerrainTexture gTexture = new TerrainTexture(loader.loadTexture("pinkFlowers"));
        TerrainTexture bTexture = new TerrainTexture(loader.loadTexture("mossPath256"));

        TerrainTexturePack texturePack = new TerrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
        TerrainTexture blendMap = new TerrainTexture(loader.loadTexture("blendMap"));
         terrain= new Terrain(0,-1,loader, texturePack, blendMap, "heightMap");



        this.renderer=renderer;
        light = new Light(new Vector3f(20000, 20000, 2000), new Vector3f(1,1,1));

        TexturedModel avatar = new TexturedModel(OBJLoader.loadObjModel("player",  loader), new ModelTexture(loader.loadTexture("playerTexture")));

    }

    public void cleanup()
    {
        renderer.cleanUp();
        loader.cleanUp();

    }

    @Override
    public void tick() {

    }

    @Override
    public void render()
    {
        cam.acceptInput(1);
        // camera.move();
        //player.move(terrain);
        //renderer.processEntity(player);
        renderer.processTerrain(terrain);

        for (Entity entity : entities){
            renderer.processEntity(entity);
        }
        //  renderer.render(light, camera);
        renderer.render(light, cam);

    }
}
