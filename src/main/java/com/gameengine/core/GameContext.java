package com.gameengine.core;

import com.gameengine.config.EngineConfig;
import com.gameengine.input.InputManager;

public final class GameContext {
    private final EngineConfig config;
    private final InputManager input;

    public GameContext(EngineConfig config,
                       InputManager input 
    ){
        this.config = config;
        this.input = input;
    }

    public EngineConfig getConfig(){
        return config;
    }

    public InputManager getInput(){
        return input;
    }
}
