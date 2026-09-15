package com.gameengine.core;

import com.gameengine.graphics.Renderer;

public interface Game {
    void init(GameContext context);
    void tick(GameContext context);
    void render(Renderer renderer);
    void shutdown();
}
