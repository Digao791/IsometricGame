package com.gameengine.graphics;

import java.awt.Color;
import java.awt.Graphics2D;

public class Renderer {
    
    private final FrameBuffer frameBuffer;
    private Graphics2D graphics;

    public Renderer(FrameBuffer frameBuffer){
        this.frameBuffer = frameBuffer;
    }

    public void begin(){
        graphics = frameBuffer.createGraphics();
    }

    public void end(){
        if(graphics != null){
            graphics.dispose();
            graphics = null;
        }
    }

    public void setGraphics(Graphics2D graphics){
        this.graphics = graphics;
    }

    public void clear(Color color){
        graphics.setColor(color);
        graphics.fillRect(
            0, 
            0, 
            frameBuffer.getWidth(), 
            frameBuffer.getHeight()
        );
    }

    public void drawRect(
        int x,
        int y,
        int width,
        int height,
        Color color
    ){
        graphics.setColor(color);
        graphics.fillRect(
            x,
            y,
            width, 
            height
        );
    }
}
