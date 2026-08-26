package main.java.com.gameengine.core;

import main.java.com.gameengine.graphics.FrameBuffer;
import main.java.com.gameengine.graphics.Renderer;

public class Engine {
    
    private static final int INTERNAL_WIDTH = 320;
    private static final int INTERNAL_HEIGHT = 180;
    
    private static final int SCALE = 4;
    private final Game game;
    private Window window;
    private Renderer renderer;
    private FrameBuffer frameBuffer;
    private GameLoop gameLoop;
    private Thread gameThread;

    public Engine(Game game){
        this.game = game;
    }

    public void start(){
        window = new Window(
            "Java Isometric Engine",
            INTERNAL_WIDTH * SCALE,
            INTERNAL_HEIGHT * SCALE
        );

        renderer = new Renderer();
        frameBuffer = new FrameBuffer(INTERNAL_WIDTH,
             INTERNAL_HEIGHT);

        gameLoop = new GameLoop(game,
             window.getCanvas(), 
             renderer, 
             frameBuffer);

        gameLoop.start();
        gameThread = new Thread(gameLoop,
            "GameThread"
        );
        gameThread.start();
    }
}
