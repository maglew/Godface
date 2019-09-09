package states;

import core.Handler;

import java.awt.*;

public class MenuState extends State {
    public Rectangle playbutton=new Rectangle(250,120,155,40);
    public  Rectangle optionsbutton=new Rectangle(250,180,155,40);
    public  Rectangle quitbutton=new Rectangle(250,240,155,40);
    public MenuState(Handler handler)
    {
      //  super(handler);
    }


    @Override
    public void tick()
    {
//System.out.println(handler.getMouseManager().mouseX+" "+handler.getMouseManager().mouseY);
      //  if(handler.getMouseManager().left&&handler.getMouseManager().getMouseX()>=250&&handler.getMouseManager().getMouseX()<=405
      //          &&handler.getMouseManager().getMouseY()>=120&&handler.getMouseManager().getMouseY()<=160)
      //  {State.setState(handler.getGame().gameState);}
//
      //  else if(handler.getMouseManager().left&&handler.getMouseManager().getMouseX()>=250&&handler.getMouseManager().getMouseX()<=405
      //          &&handler.getMouseManager().getMouseY()>=240&&handler.getMouseManager().getMouseY()<=280)
      //  {handler.getGame().stop();}
    }

    @Override
    public void render(Graphics g)
    {
        Graphics2D g2d=(Graphics2D)g;
        Font menufnt=new Font("arial",Font.BOLD,30);
        Font buttonfnt=new Font("arial",Font.BOLD,15);
        g.setFont(menufnt);
        g.setColor(Color.black);
        g.fillRect(0,0,640,360);
        g.setColor(Color.white);
        g.drawString("Main menu",250,50);
        g2d.draw(playbutton);
        g2d.draw(optionsbutton);
        g2d.draw(quitbutton);
        g.setColor(Color.yellow);

        g.drawString("play",playbutton.x+50,playbutton.y+30);
        g.drawString("options",optionsbutton.x+25,optionsbutton.y+30);
        g.drawString("quit",quitbutton.x+50,quitbutton.y+30);
    }

}
