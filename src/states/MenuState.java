package states;


import core.Handler;
import fontMeshCreator.FontType;
import fontMeshCreator.GUIText;
import fontRendering.TextMaster;
import guis.GuiRenderer;
import guis.GuiTexture;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import render.Loader;
import render.MasterRenderer;

import java.io.File;

import java.util.List;

public class MenuState extends State {

    Loader loader;

    MasterRenderer renderer;
   // GuiRenderer guiRenderer;
    List<GuiTexture> guis;

    public MenuState(Handler handler, Loader loader, MasterRenderer renderer)
    {
        super(handler);
        this.loader=loader;
        this.renderer=renderer;

        TextMaster.init(loader);

        FontType font = new FontType(loader.loadTexture("verdana"), new File("res/verdana.fnt"));
        GUIText text = new GUIText("Main Menu", 4f, font, new Vector2f(0f, 0f), 1f, true);
        GUIText text2 = new GUIText("Click Space", 3f, font, new Vector2f(0f, 0.2f), 1f, true);
        text.setColour(1, 0, 0);
        text2.setColour(1, 0, 1);
/*
        guis = new ArrayList<GuiTexture>();
        GuiTexture gui = new GuiTexture(loader.loadTexture("socuwan"), new Vector2f(0.5f, 0.5f), new Vector2f(0.25f, 0.25f));
        GuiTexture gui2 = new GuiTexture(loader.loadTexture("thinmatrix"), new Vector2f(0.30f, 0.58f), new Vector2f(0.4f, 0.4f));
        GuiTexture gui3 = new GuiTexture(loader.loadTexture("health"), new Vector2f(-0.74f, 0.925f), new Vector2f(0.25f, 0.25f));
        guis.add(gui);
        guis.add(gui2);
        guis.add(gui3);
         guiRenderer = new GuiRenderer(loader);*/
    }

    public void cleanup()
    {
        renderer.cleanUp();
        loader.cleanUp();
      //  guiRenderer.cleanUp();
        TextMaster.cleanUp();
    }

    @Override
    public void tick()
    {
if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
{State.setState(handler.getGame().gamestate);

}
    }

    @Override
    public void render()
    {
       // guiRenderer.render(guis);
        TextMaster.render();
    }

}
