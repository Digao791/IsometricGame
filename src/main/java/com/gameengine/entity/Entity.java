package com.gameengine.entity;

import com.gameengine.core.GameContext;
import com.gameengine.graphics.Renderer;

public abstract class Entity {

    private final Transform transform;

    protected Entity(double x, double y) {
        this.transform = new Transform(x, y);
    }

    public abstract void tick(GameContext context);

    public abstract void render(Renderer renderer);

    public Transform getTransform() {
        return transform;
    }
}