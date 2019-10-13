package core;

public class Handler {
    private GameLoop mainGameLoop;


    public Handler(GameLoop mainGameLoop)
    {this.mainGameLoop=mainGameLoop;}

    public GameLoop getGame() {
        return mainGameLoop;
    }


}
