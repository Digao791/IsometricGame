package com.gameengine.core;

import com.gameengine.graphics.Renderer;

public interface Game {
    void init();
    void tick();
    void render(Renderer renderer);
    void shutdown();
}
