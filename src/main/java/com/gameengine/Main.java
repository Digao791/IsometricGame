package main.java.com.gameengine;

import main.java.com.gameengine.config.EngineConfig;
import main.java.com.gameengine.core.Engine;
import main.java.com.gameengine.game.IsoGame;

public class Main {
    public static void main(String[] args) {
        EngineConfig config = new EngineConfig(
            "Java Isometric Game", 
            320, 
            180, 
            4, 
        60);

        IsoGame game = new IsoGame();
        Engine engine = new Engine(game, config);
        engine.start();
    }
}
