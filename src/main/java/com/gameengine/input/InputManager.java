package com.gameengine.input;

import java.awt.Canvas;

public final class InputManager {
    
    private final Keyboard keyboard;

    public InputManager(Canvas canvas){
        keyboard = new Keyboard();
        canvas.addKeyListener(keyboard);
        canvas.setFocusable(true);
        canvas.requestFocus();
    }

    public Keyboard getKeyboard(){
        return keyboard;
    }

    
}
