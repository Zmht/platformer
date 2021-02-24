package com.zachary.platformer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable{


    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Background background;
    private Graphics g;
    private Random r;

    public Game() {

        new Window(WIDTH, HEIGHT,"Platformer", this);
        handler = new Handler();
        background = new Background();
        r = new Random();

        //handler.addObject(new Player(WIDTH / 32, HEIGHT / 32, ID.Player, handler));
        handler.addObject(new Platform(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.Platform));


    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    private void tick() {
        handler.tick();

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }


        Graphics g = bs.getDrawGraphics();

        background.render(g);

        handler.render(g);



        g.dispose();
        bs.show();
    }

    public static int clamp(float var, float min, float max) {
        if (var >= max) return (int) (var = max);
        else if (var <= min) return (int) (var = min);
        else return (int) var;
    }

    public static void main(String[] args) {
        new Game();
    }


}
