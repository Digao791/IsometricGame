package com.gameengine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Keyboard implements KeyListener {

    private static final int KEY_COUNT = 256;
    private final boolean[] keys = new boolean[KEY_COUNT];

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(isValidKey(keyCode)) keys[keyCode] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(isValidKey(keyCode)) keys[keyCode] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       return;
    }


    public boolean isDown(int keyCode){
        return isValidKey(keyCode) && keys[keyCode];
    }
    private boolean isValidKey(int keyCode){
        return keyCode >=0 && keyCode < KEY_COUNT;
    }
    
}
