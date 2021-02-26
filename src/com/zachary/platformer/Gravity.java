package com.zachary.platformer;

public class Gravity {

    private Handler handler;
    private Player player;
    boolean gravityOn;

    public Gravity(Player player, Handler handler){
        gravityOn = false;
        this.handler = handler;
        this.player = player;
    }

    public void jump(int jumpForce, int gravityForce){
        player.setVelY(jumpForce);
    }
}
