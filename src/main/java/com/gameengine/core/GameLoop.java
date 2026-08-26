package main.java.com.gameengine.core;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import main.java.com.gameengine.graphics.FrameBuffer;
import main.java.com.gameengine.graphics.Renderer;

public class GameLoop implements Runnable {

    private static final double TARGET_TPS = 60.0;
    private static final double NS_PER_TICK = 
            1_000_000_000.0 / TARGET_TPS;

    private final Game game;
    private final Canvas canvas;
    private final Renderer renderer;
    private final FrameBuffer frameBuffer;
    private volatile boolean running;

    public GameLoop(
        Game game,
        Canvas canvas,
        Renderer renderer,
        FrameBuffer frameBuffer
    ){
        this.game = game;
        this.canvas = canvas;
        this.renderer = renderer;
        this.frameBuffer = frameBuffer;
        
    }
    @Override
    public void run() {
        game.init();
        long previousTime = System.nanoTime();
        double accumulator = 0;
        while(running){
            long currentTime = System.nanoTime();
            accumulator += currentTime - previousTime;
            previousTime = currentTime;

            while(accumulator >= NS_PER_TICK){
                game.tick();
                accumulator -= NS_PER_TICK;
            }
            render();
        }
        game.shutdown();
    }
    
    private void render(){
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        if(bufferStrategy == null){
            canvas.createBufferStrategy(3);
            return;
        }

        renderer.begin();
        game.render(renderer);
        renderer.end();

        Graphics2D screenGraphics = 
        (Graphics2D) bufferStrategy.getDrawGraphics();

        try{
            screenGraphics.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION, 
                RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

            screenGraphics.drawImage(
                frameBuffer.getImage(), 
                0,
                0,
                canvas.getWidth(),
                canvas.getHeight(),
                null 
            );
        }finally{
            screenGraphics.dispose();
        }
    
        bufferStrategy.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public void start(){
        running = true;
    }

    public void stop(){
        running = false;
    }
}
