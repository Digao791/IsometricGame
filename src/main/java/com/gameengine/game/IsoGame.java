package main.java.com.gameengine.game;

import java.awt.Color;

import main.java.com.gameengine.core.Game;
import main.java.com.gameengine.graphics.Renderer;

public class IsoGame implements Game{
    
    private int x = 0;

    @Override
    public void init() {
        System.out.println("Game initialized");
    }

    @Override
    public void tick() {
        x++;
        if(x > 320){
            x = -16;
        }
    }

    @Override
    public void render(Renderer renderer) {
        renderer.clear(new Color(20, 20, 50));
        renderer.drawRect(
            x,
            80,
            16,
            16,
            Color.WHITE);
    }

    @Override
    public void shutdown() {
        System.out.println("Game Stopped");
    }
}
