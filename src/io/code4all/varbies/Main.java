package io.code4all.varbies;

public class Main {

    public static void runGameSafely(Field field) {
        try{
            field.runGame();
        }
        catch (InterruptedException e) {
            System.out.println("Oops");
        }

    }

    public static void main(String[] args) throws InterruptedException {

       runGame();

    }
    public static void runGame() throws InterruptedException {
        Field field = new Field();
        Menu menu = new Menu();
        new MenuControls(menu);
        new Game0verControls(field);
        menu.run();
        field.init();
        SoundEffects.playSound("resources/MusicaTeste.wav");
        runGameSafely(field);
        while(field.isRestart()){
            Thread.sleep(100);
        }
        runGame();
    }



}
