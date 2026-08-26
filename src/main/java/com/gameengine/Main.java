package main.java.com.gameengine;

import main.java.com.gameengine.config.EngineConfig;
import main.java.com.gameengine.core.Engine;
import main.java.com.gameengine.game.IsoGame;

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
