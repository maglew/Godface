package core;

import org.lwjgl.opengl.Display;

import render.DisplayManager;
import render.Loader;
import render.MasterRenderer;


import states.GameState;
import states.MenuState;
import states.State;




public class GameLoop
{
  public   State gamestate;
   public State menustate;
    Handler handler;




    public GameLoop()
    {}


    public  void init()
    {
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        MasterRenderer renderer = new MasterRenderer(loader);
        handler = new Handler(this);
        gamestate=new GameState(handler,loader,renderer);
         menustate=new MenuState(handler,loader,renderer);
        State.setState(menustate);
      //  State.setState(gamestate);
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




