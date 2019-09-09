package states;

import core.Handler;

import java.awt.*;

public class GameState extends State
{



    public GameState(Handler handler){
       // super(handler);
       // world = new World(handler, "res/worlds/world1.txt");
       // handler.setWorld(world);
       // player = new Player(handler, 100, 100);
    }

    @Override
    public void tick() {
       //world.tick();
       // player.tick();
    }

    @Override
    public void render(Graphics g) {

       // world.render(g);
       // player.render(g);
    }
}
