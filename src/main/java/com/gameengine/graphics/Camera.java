package com.gameengine.graphics;

public final class Camera {

    private double x;
    private double y;

    public Camera() {
        this(0, 0);
    }

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}