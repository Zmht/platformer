package com.zachary.platformer;

import java.awt.*;
import java.util.Random;

public class Platform extends GameObject{

    Random r;

    public Platform(int x, int y, ID id) {
        super(x, y, id);
        r = new Random();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect((int)x, (int) y, 300, 64);
    }
}
