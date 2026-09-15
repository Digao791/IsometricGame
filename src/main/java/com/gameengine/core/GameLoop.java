package com.gameengine.core;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.concurrent.locks.LockSupport;

import com.gameengine.config.EngineConfig;
import com.gameengine.graphics.FrameBuffer;
import com.gameengine.graphics.Renderer;

public class GameLoop implements Runnable {

    private static final long ONE_SECOND =
            1_000_000_000L;

    private final Game game;
    private final Canvas canvas;
    private final Renderer renderer;
    private final FrameBuffer frameBuffer;
    private final EngineConfig config;
    private final Runnable onStop;
    private final GameContext context;
    private volatile boolean running;

    private final double nsPerTick;
    private final long nsPerFrame;
    private int fps;
    private int tps;

    public GameLoop(
        Game game,
        GameContext context,
        Canvas canvas,
        Renderer renderer,
        FrameBuffer frameBuffer,
        EngineConfig config,
        Runnable onStop
    ){
        this.game = game;
        this.context = context;
        this.canvas = canvas;
        this.renderer = renderer;
        this.frameBuffer = frameBuffer;
        this.config = config;
        this.onStop = onStop;

         this.nsPerTick =
                ONE_SECOND / (double) config.getTargetTps();

        this.nsPerFrame =
                config.getTargetFps() == 0
                        ? 0
                        : ONE_SECOND / config.getTargetFps();
    }
    @Override
    public void run() {
        game.init(context);
        long previousTime =
                System.nanoTime();

        long statisticsTimer =
                previousTime;

        double accumulator = 0;
        int tickCounter = 0;
        int frameCounter = 0;

        while(running){
            long frameStart  = System.nanoTime();
            accumulator += frameStart  - previousTime;
            previousTime = frameStart ;

            while(accumulator >= nsPerTick){
                game.tick(context);
                tickCounter++;
                accumulator -= nsPerFrame;
            }
            render();
            frameCounter++;
            long now = System.nanoTime();
            if(now - statisticsTimer >= ONE_SECOND){
                fps = frameCounter;
                tps = tickCounter;

                frameCounter = 0;
                tickCounter = 0;

                statisticsTimer += ONE_SECOND;
                if(config.isDebug()){
                    System.out.println("FPS: " + fps
                        + " | TPS: " + tps
                    );
                }
            }
            limitFrameRate(frameStart);
        }
        game.shutdown();
        onStop.run();
    }

    private void limitFrameRate(long frameStart){
        if(nsPerFrame <= 0) return;

        long elapsed = System.nanoTime() - frameStart;
        long remaining = nsPerFrame - elapsed;
        if(remaining > 0) LockSupport.parkNanos(remaining);
    }
    
    private void render() {

        BufferStrategy bufferStrategy =
                canvas.getBufferStrategy();

        if (bufferStrategy == null) {

            canvas.createBufferStrategy(3);

            return;
        }

        renderer.begin();

        try {

            game.render(renderer);

        } finally {

            renderer.end();
        }

        do {

            do {

                Graphics2D graphics =
                        (Graphics2D)
                                bufferStrategy.getDrawGraphics();

                try {

                    graphics.setRenderingHint(
                            RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
                    );

                    graphics.drawImage(
                            frameBuffer.getImage(),
                            0,
                            0,
                            canvas.getWidth(),
                            canvas.getHeight(),
                            null
                    );

                } finally {

                    graphics.dispose();
                }

            } while (bufferStrategy.contentsRestored());

            bufferStrategy.show();

        } while (bufferStrategy.contentsLost());

        if (config.isSyncToolkit()) {

            Toolkit.getDefaultToolkit().sync();
        }
    }

    public void start(){
        running = true;
    }

    public void stop(){
        running = false;
    }

    public boolean isRunning() {return running;}
    public int getFps(){return fps;}
    public int getTps(){return tps;}
}
