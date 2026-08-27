package com.gameengine;

import com.gameengine.config.EngineConfig;
import com.gameengine.core.Engine;
import com.gameengine.game.IsoGame;

public class Main {
    public static void main(String[] args) {
        EngineConfig config = EngineConfig.builder()
        .resolution(320, 180)
        .scale(4)
        .targetTps(60)
        .targetFps(120)
        .resizable(false)
        .debug(true)
        .build();

        IsoGame game = new IsoGame();
        Engine engine = new Engine(game, config);
        engine.start();
    }
}
