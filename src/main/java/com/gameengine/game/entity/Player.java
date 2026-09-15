package com.gameengine.game.entity;

import com.gameengine.core.GameContext;
import com.gameengine.entity.Entity;
import com.gameengine.graphics.Renderer;
import com.gameengine.input.Keyboard;

import java.awt.Color;
import java.awt.event.KeyEvent;

public final class Player extends Entity {

    private static final double SPEED = 1.0;

    public Player(double x, double y) {
        super(x, y);
    }

    @Override
    public void tick(GameContext context) {

        Keyboard keyboard =
                context.getInput().getKeyboard();

        double dx = 0;
        double dy = 0;

        if (keyboard.isDown(KeyEvent.VK_W)) {
            dy--;
        }

        if (keyboard.isDown(KeyEvent.VK_S)) {
            dy++;
        }

        if (keyboard.isDown(KeyEvent.VK_A)) {
            dx--;
        }

        if (keyboard.isDown(KeyEvent.VK_D)) {
            dx++;
        }

        if (dx != 0 || dy != 0) {

            double length =
                    Math.sqrt(
                            dx * dx
                            + dy * dy
                    );

            dx /= length;
            dy /= length;

            dx *= SPEED;
            dy *= SPEED;

            getTransform().translate(dx, dy);
        }

    }

    @Override
    public void render(Renderer renderer) {

        renderer.drawWorldRect(
                getTransform().getX(),
                getTransform().getY(),
                8,
                8,
                Color.WHITE
        );
    }
}