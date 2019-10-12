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

public class MenuState extends State {

    Loader loader;

    MasterRenderer renderer;


    public MenuState(Loader loader,MasterRenderer renderer)
    {
        this.loader=loader;



        this.renderer=renderer;

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


    }

}
