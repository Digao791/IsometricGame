package com.gameengine.core;

import com.gameengine.config.EngineConfig;
import com.gameengine.graphics.FrameBuffer;
import com.gameengine.graphics.Renderer;
import com.gameengine.input.InputManager;

public class Engine {
    
    private final Game game;
    private final EngineConfig config;
    private Window window;
    private Renderer renderer;
    private FrameBuffer frameBuffer;
    private GameLoop gameLoop;
    private Thread gameThread;

    private InputManager inputManager;
    private GameContext gameContext;

    public Engine(Game game, EngineConfig config){
        this.game = game;
        this.config = config;

        if(game == null) throw new IllegalArgumentException("Game cannot be null");
        if(config == null) throw new IllegalArgumentException("EngineConfig cannot be null");
    }

    public synchronized void start(){
        if(gameThread != null) return;
        window = new Window(
            config,
            this::stop
        );

        inputManager = new InputManager(window.getCanvas());
        gameContext = new GameContext(config, inputManager);

        frameBuffer = new FrameBuffer(config.getInternalWidth(),
             config.getInternalHeight());

        renderer = new Renderer(frameBuffer);

        gameLoop = new GameLoop(game,
            gameContext,
             window.getCanvas(), 
             renderer, 
             frameBuffer,
             config,
             this::shutdown);

        gameThread = new Thread(gameLoop,
            "GameThread"
        );

        gameLoop.start();
        gameThread.start();
    }

    public synchronized void stop(){
        if(gameLoop == null) return;
        gameLoop.stop();
    }

    public EngineConfig getConfig(){
        return config;
    }

    private void shutdown(){
        if(window != null) window.close();
        gameThread = null;
    }
}
