package com.gameengine.core;

import com.gameengine.config.EngineConfig;
import com.gameengine.graphics.FrameBuffer;
import com.gameengine.graphics.Renderer;

public class Engine {
    
    private final Game game;
    private final EngineConfig config;
    private Window window;
    private Renderer renderer;
    private FrameBuffer frameBuffer;
    private GameLoop gameLoop;
    private Thread gameThread;

    public Engine(Game game, EngineConfig config){
        this.game = game;
        this.config = config;
    }

    public void start(){
        window = new Window(
            config
        );

        frameBuffer = new FrameBuffer(config.getInternalWidth(),
             config.getInternalHeight());

        renderer = new Renderer(frameBuffer);

        gameLoop = new GameLoop(game,
             window.getCanvas(), 
             renderer, 
             frameBuffer,
            config);

        gameLoop.start();
        gameThread = new Thread(gameLoop,
            "GameThread"
        );
        gameThread.start();
    }
}
