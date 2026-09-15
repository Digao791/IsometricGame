package com.gameengine.game;

import com.gameengine.core.Game;
import com.gameengine.core.GameContext;
import com.gameengine.entity.EntityManager;
import com.gameengine.game.entity.Player;
import com.gameengine.graphics.Camera;
import com.gameengine.graphics.Renderer;

import java.awt.Color;

public final class IsoGame implements Game {

    private EntityManager entities;
    private Camera camera;
    private Player player;

    @Override
    public void init(GameContext context) {

        entities = new EntityManager();

        player = new Player(160, 90);

        entities.add(player);
        camera = new Camera();
        System.out.println("Game initialized.");
    }

    @Override
    public void tick(GameContext context) {
        entities.tick(context);
        double cameraX =
        player.getTransform().getX() 
        - context.getConfig().getInternalWidth() / 2.0;

        double cameraY =
                player.getTransform().getY() 
                - context.getConfig().getInternalHeight() / 2.0;

        camera.setPosition(
                cameraX,
                cameraY
        );
    }

    @Override
    public void render(Renderer renderer) {

        renderer.clear(
                new Color(25, 25, 35)
        );
        renderer.setCamera(camera);
        entities.render(renderer);
        drawSquaresTests(renderer);
    }

    private void drawSquaresTests(Renderer renderer) {
        renderer.drawWorldRect(
        50,
        50,
        16,
        16,
        Color.RED
        );

        renderer.drawWorldRect(
                250,
                100,
                16,
                16,
                Color.GREEN
        );

        renderer.drawWorldRect(
                400,
                150,
                16,
                16,
                Color.BLUE
        );
    }

    @Override
    public void shutdown() {

        System.out.println("Game shutdown.");
    }
}