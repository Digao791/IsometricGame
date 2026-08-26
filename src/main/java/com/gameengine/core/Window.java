package main.java.com.gameengine.core;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Window {
    
    private final JFrame frame;
    private final Canvas canvas;

    public Window(String title, int width, int height){
        frame = new JFrame(title);
        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
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
