package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {
    public static int flag = -1;

    Picture startMenu;
    public Menu(){

    }
    public void run(){
        SoundEffects soundEffects = new SoundEffects();
        startMenu = new Picture(0,0,"resources/StartMenuT.png");
        startMenu.draw();

        while(flag == -1){
            System.out.println();
        }
        startMenu.delete();
        SoundEffects.playSound("resources/game-start.wav");
        }
        //SoundEffects.playSound("resources/game-start.wav");
    }

