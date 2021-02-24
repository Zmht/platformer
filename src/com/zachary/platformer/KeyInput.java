package com.zachary.platformer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{

    private Handler handler;

    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;


    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for player1
                if(key == KeyEvent.VK_SPACE) {
                    tempObject.setVelY(-5);
                    keyDown[0] = true;
                }
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                //keyevents for player1
                if(key == KeyEvent.VK_SPACE) tempObject.setVelY(5);
            }

        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }


}
