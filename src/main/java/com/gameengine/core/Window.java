package com.gameengine.core;

import javax.swing.JFrame;

import com.gameengine.config.EngineConfig;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window {
    
    private final JFrame frame;
    private final Canvas canvas;

    public Window(EngineConfig config, Runnable onClose){
        frame = new JFrame(config.getTitle());
        canvas = new Canvas();
        Dimension size = new Dimension(new Dimension(config.getWindowWidth(), 
                                              config.getWindowHeight()));

        canvas.setPreferredSize(size);
        canvas.setMinimumSize(size);
        canvas.setMaximumSize(size);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(config.isResizable());
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent event){
                onClose.run();
            }
        });

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

    public void close(){
        frame.dispose();
    }
}
