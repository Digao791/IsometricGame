package com.gameengine.entity;

public final class Transform {

    private double x;
    private double y;

    public Transform() {
        this(0, 0);
    }

    public Transform(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}