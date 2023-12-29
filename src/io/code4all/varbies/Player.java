package io.code4all.varbies;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Picture playerPicture;

    private Picture mcPicture;


    private int mcPosY;

    private int mcPosX;
    private int posX;
    private int posY;

    private boolean invincible;

    private int invincibilityCounter;

    private boolean bound;

    public void setBoundDown(boolean boundDown) {
        this.boundDown = boundDown;
    }

    private boolean boundDown;

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getMcPosX() {
        return mcPosX;
    }

    public int getMcPosY() {
        return mcPosY;
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    public int getInvincibilityCounter() {
        return invincibilityCounter;
    }

    public void setInvincibilityCounter(int invincibilityCounter) {
        this.invincibilityCounter = invincibilityCounter;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public boolean isBound() {
        return bound;
    }

    public void setBound(boolean bound) {
        this.bound = bound;
    }

    public Player() {
        double randomNumber = Math.random();
        double randomNumber2 = Math.random();


        /**Generates Gotham*/
        if ( Menu.flag == 1) {
            mcPicture = new Picture(0,348, "resources/MC_Zuka.png");
            playerPicture = new Picture(840, 348, "resources/Cadet_Ravioli.png");

        }
        /** Generates SinCity */
        else if ( Menu.flag == 2) {
            mcPicture = new Picture(0,348, "resources/MC_Mike.png");
            if(randomNumber2 > 0.50) {

                playerPicture = new Picture(840, 348, "resources/Cadet_Cabaco.png");
            } else {
                playerPicture = new Picture(840, 348, "resources/Cadet_Francisco.png");
            }
        }
        /** Generates Metropolos */
        else if(Menu.flag == 3){
            mcPicture = new Picture(0,348, "resources/MC_Nosk.png");
            if(randomNumber2 > 0.50) {

                playerPicture = new Picture(840, 348, "resources/Cadet_Pedro.png");
            } else {

                playerPicture = new Picture(840, 348, "resources/Cadet_Duarte.png");
            }

        }


        playerPicture.grow(0, 0);
        playerPicture.draw();
        mcPicture.draw();
        posY = 3;
        posX = 7;
        mcPosY = 3;
        mcPosX = 0;
        invincible = false;
        invincibilityCounter = 0;

    }

    /** FAZER UM CHECK PARA NÃO COLIDIR CONTRA CAIXAS QUE JÁ EXISTEM NA MESMA YPOS */
    public void moveUp() {
        if(!bound) {
            if (posY > 1) {
                playerPicture.translate(0, -134);
                posY--;
            }
        }
    }

    public void moveDown() {
        if(!boundDown) {
            if (posY < 5) {
                playerPicture.translate(0, 134);
                posY++;
            }
        }
    }

    public void mcMove() {


            if (mcPosY > posY) {
                    mcPicture.translate(0, -134);
                    mcPosY--;

            }

            if (mcPosY < posY) {
                    mcPicture.translate(0, 134);
                    mcPosY++;

            }

    }

    public void playerDraw() {
        playerPicture.draw();
        mcPicture.draw();
    }

    public void runInvincibility() {
        if (invincible) {
            invincibilityCounter++;
        }

        if (invincibilityCounter == 3) {
            invincible = false;
            invincibilityCounter = 0;
        }
    }

    public void hit() {

        playerPicture.translate(-125, 0);
        SoundEffects.playSound("resources/hit.wav");
    }

    public void drink() {
        invincible = true;
        playerPicture.translate(125, 0);
        SoundEffects.playSound("resources/beer.wav");
    }
}
