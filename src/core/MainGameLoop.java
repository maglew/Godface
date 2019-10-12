package core;

import entities.*;


import models.TexturedModel;
import org.lwjgl.opengl.Display;

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

import java.util.ArrayList;
import java.util.List;


public class MainGameLoop
{
    State gamestate;
    State menuState;
    Handler handler;




    public  MainGameLoop()
    {}


    public  void init()
    {
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        MasterRenderer renderer = new MasterRenderer();

        gamestate=new GameState(loader,renderer);
         menuState=new MenuState(loader,renderer);
       // State.setState(menuState);
        State.setState(gamestate);
        loop();

    }

    private void tick()
    {
        if(State.getState() != null)
            State.getState().tick();
    }
    private void render()
    {
        if(State.getState() != null)
            State.getState().render();
    }

    private void cleanup()
    {
        gamestate.cleanup();
    }

    private void loop()
    {
        while(!Display.isCloseRequested()) {

            tick();
            render();
            DisplayManager.updateDisplay();
        }
        cleanup();
        DisplayManager.closeDisplay();
    }



    }




