package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Box1 extends Obstacle{
    private boolean spawned;

    private boolean justSpawned;

    private int xPos;

    private int yPos;

    private int speed = 0;


    private Picture box;


    public Box1() {
        if (Math.random() > 0.50) {
            box = new Picture(0,0,"resources/iMac.png");
        } else {
            box = new Picture(0,0,"resources/Duckie.png");
        }
        //box = new Picture(x+Field.PADDING, y+Field.PADDING, xSize, ySize);
        setxPos(-4);
        setyPos(-4);
    }

    /** Getters/Setters */
    public boolean isSpawned() {
        return spawned;
    }

    public void setSpawned(boolean spawned) {
        this.spawned = spawned;
    }

    public boolean isJustSpawned() {
        return justSpawned;
    }
    @Override
    public void setJustSpawned(boolean justSpawned) {
        this.justSpawned = justSpawned;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /** Methods */
    public void moveBox(int x, int y) {
        box.translate(x,y);
    }

    public void show() {
        box.draw();
    }

    public void hide() {
        setxPos(-1);
        setyPos(-1);
        setSpawned(false);
        this.box.delete();
    }

    public ObstacleSpawnPoints chosenSpawnPoint() {
        return ObstacleSpawnPoints.values()[(int) (Math.random() * 5)];
    }





}
