package com.gameengine.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class FrameBuffer {
    
    private final BufferedImage image;

    public FrameBuffer(int width, int height){
        image = new BufferedImage(
            width,
            height,
            BufferedImage.TYPE_INT_ARGB);
    }

     public Graphics2D createGraphics(){
        return image.createGraphics();
     }

     public BufferedImage getImage(){
        return image;
     }

     public int getWidth(){
        return image.getWidth();
     }

     public int getHeight(){
        return image.getHeight();
     }
}
