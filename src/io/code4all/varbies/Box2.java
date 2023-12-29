package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Box2 extends Obstacle{
    private boolean spawned;

    private boolean justSpawned;

    private int xPos;

    private int yPos;

    private int speed = 0;


    private Picture box;


    public Box2() {
        if (Math.random() > 0.50) {
            box = new Picture(0,0,"resources/Fridge.png");
        } else {
            box = new Picture(0,0,"resources/Pizza.png");
        }
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
        return ObstacleSpawnPoints.values()[(int) (Math.random() * 4)];
    }






}
