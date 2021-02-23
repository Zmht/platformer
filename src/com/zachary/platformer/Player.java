package com.zachary.platformer;

import java.awt.*;

public class Player extends GameObject{

    Handler handler;

    public Player(int x, int y, ID id, Handler handler){
    super(x, y, id);
    this.handler = handler;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect((int)x, (int)y, 128, 128);

    }
}
