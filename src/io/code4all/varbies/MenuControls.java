package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MenuControls implements KeyboardHandler {
    Menu menu;

    public MenuControls(Menu menu) {
        this.menu = menu;
        init();
    }

    private void init(){

        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent Gotham = new KeyboardEvent();
        Gotham.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        Gotham.setKey(KeyboardEvent.KEY_G);
        keyboard.addEventListener(Gotham);

        KeyboardEvent SinCity = new KeyboardEvent();
        SinCity.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        SinCity.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(SinCity);

        KeyboardEvent Metropolis = new KeyboardEvent();
        Metropolis.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        Metropolis.setKey(KeyboardEvent.KEY_M);
        keyboard.addEventListener(Metropolis);



    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key){

            case KeyboardEvent.KEY_G:
                Menu.flag = 1;
                break;
            case KeyboardEvent.KEY_C:
                Menu.flag = 2;
                break;
            case KeyboardEvent.KEY_M:
                Menu.flag = 3;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}


