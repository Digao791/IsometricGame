package main.java.com.gameengine.core;

import javax.swing.JFrame;

import main.java.com.gameengine.config.EngineConfig;

import java.awt.Canvas;
import java.awt.Dimension;

public class Window {
    
    private final JFrame frame;
    private final Canvas canvas;

    public Window(EngineConfig config){
        frame = new JFrame(config.getTitle());
        canvas = new Canvas();
        Dimension size = new Dimension(new Dimension(config.getWindowWidth(), 
                                              config.getWindowHeight()));

        canvas.setPreferredSize(size);
        canvas.setMinimumSize(size);
        canvas.setMaximumSize(size);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(config.isResizable());
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}
