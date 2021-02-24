package com.zachary.platformer;


import java.awt.*;

public class Background{



    public Background(){

    }

    public void tick() {

    }

    public void render(Graphics g) {
    g.setColor(Color.GRAY);
    g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
    }
}
