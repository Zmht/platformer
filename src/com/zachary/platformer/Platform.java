package com.zachary.platformer;

import java.awt.*;
import java.util.Random;

public class Platform extends GameObject{

    Random r;
    int t;

    public Platform(int x, int y, ID id) {
        super(x, y, id);
        velX = 3;
    }

    @Override
    public void tick() {
        x -= velX;

        t++;


    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect((int)x, (int)y, 300, 16);
    }
}
