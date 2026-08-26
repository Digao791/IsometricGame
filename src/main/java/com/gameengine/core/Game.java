package main.java.com.gameengine.core;

import main.java.com.gameengine.graphics.Renderer;

public interface Game {
    void init();
    void tick();
    void render(Renderer renderer);
    void shutdown();
}
