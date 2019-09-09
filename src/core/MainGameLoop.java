package core;

import entities.Camera;
import entities.Entity;

import entities.Light;
import entities.Player;
import models.TexturedModel;
import org.lwjgl.opengl.Display;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
import render.DisplayManager;
import render.Loader;
import render.MasterRenderer;
import render.OBJLoader;
import states.GameState;
import states.MenuState;
import states.State;
import terrains.Terrain;
import textures.ModelTexture;
import textures.TerrainTexture;
import textures.TerrainTexturePack;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;


public class MainGameLoop
{
    State gameState;
    State menuState;
    Handler handler;




    public  MainGameLoop()
    {}


    public    void init()
    {
        DisplayManager.createDisplay();
        Loader loader = new Loader();

        // *********TERRAIN TEXTURE STUFF***********
        TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("grassy3"));
        TerrainTexture rTexture = new TerrainTexture(loader.loadTexture("dirt"));
        TerrainTexture gTexture = new TerrainTexture(loader.loadTexture("pinkFlowers"));
        TerrainTexture bTexture = new TerrainTexture(loader.loadTexture("mossPath256"));

        TerrainTexturePack texturePack = new TerrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
        TerrainTexture blendMap = new TerrainTexture(loader.loadTexture("blendMap"));
        Terrain terrain = new Terrain(0,-1,loader, texturePack, blendMap, "heightMap");
        // *****************************************


        List<Entity> entities = new ArrayList<Entity>();

        MasterRenderer renderer = new MasterRenderer();

        Light light = new Light(new Vector3f(20000, 20000, 2000), new Vector3f(1,1,1));

        TexturedModel avatar = new TexturedModel(OBJLoader.loadObjModel("player",  loader), new ModelTexture(loader.loadTexture("playerTexture")));



        Player player = new Player(avatar, new Vector3f(400,0,-400), 0,180,0,1);
        Camera camera = new Camera(player);






        while(!Display.isCloseRequested()) {
            camera.move();
            player.move(terrain);
            renderer.processEntity(player);
            renderer.processTerrain(terrain);

            for (Entity entity : entities){
                renderer.processEntity(entity);
            }
            renderer.render(light, camera);

            DisplayManager.updateDisplay();
        }


        renderer.cleanUp();
        loader.cleanUp();

        DisplayManager.closeDisplay();
    }



}
