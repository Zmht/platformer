package com.zachary.platformer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Gravity extends KeyAdapter{

    private Handler handler;

    public Gravity(Handler handler){
        this.handler = handler;
    }






    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                jump(tempObject, 5, 5, 500);
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {

            }

        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    public void jump(GameObject gameObject, int jumpForce, int gravityForce, int jumpTime){
        long time = System.currentTimeMillis();
        long target = time + jumpTime;
        for( ; time < target; time = System.currentTimeMillis()) {
            gameObject.setVelY(-jumpForce);

        }
        gameObject.setVelY(gravityForce);
    }
}
