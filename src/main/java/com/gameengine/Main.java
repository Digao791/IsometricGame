package main.java.com.gameengine;

import main.java.com.gameengine.core.Engine;
import main.java.com.gameengine.game.IsoGame;

public class Main {
    public static void main(String[] args) {
        IsoGame game = new IsoGame();
        Engine engine = new Engine(game);
        engine.start();
    }
}
