package com.gameengine.entity;

import com.gameengine.core.GameContext;
import com.gameengine.graphics.Renderer;

import java.util.ArrayList;
import java.util.List;

public final class EntityManager {

    private final List<Entity> entities =
            new ArrayList<>();

    public void add(Entity entity) {

        if (entity == null) {
            throw new IllegalArgumentException(
                    "Entity cannot be null."
            );
        }

        entities.add(entity);
    }

    public void remove(Entity entity) {
        entities.remove(entity);
    }

    public void tick(GameContext context) {

        for (Entity entity : entities) {
            entity.tick(context);
        }
    }

    public void render(Renderer renderer) {

        for (Entity entity : entities) {
            entity.render(renderer);
        }
    }

    public int size() {
        return entities.size();
    }
}