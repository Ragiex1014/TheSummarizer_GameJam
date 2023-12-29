package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game0verControls implements KeyboardHandler {

    Field field;

    public Game0verControls(Field flied) {
        this.field = flied;
        init();
    }

    private void init() {

        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent restart = new KeyboardEvent();
        restart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        restart.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(restart);

        KeyboardEvent rerestart = new KeyboardEvent();
        rerestart.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rerestart.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(rerestart);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        switch (key){

            case KeyboardEvent.KEY_R:
                field.setRestart(true);
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key){

            case KeyboardEvent.KEY_R:
                field.setRestart(false);
            break;
        }
    }
}
