package main.java.com.gameengine.graphics;

import java.awt.Color;
import java.awt.Graphics2D;

public class Renderer {
    
    private Graphics2D graphics;

    public void setGraphics(Graphics2D graphics){
        this.graphics = graphics;
    }

    public void clear(Color color){
        graphics.setColor(color);
        graphics.fillRect(
            0, 
            0, 
            320, 
            180
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
