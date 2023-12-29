package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Chalk {

    private Picture image;

    private boolean spawned;

    private boolean justSpawned;

    private int xPos;

    private int yPos;

    public Chalk(String string) {

        image = new Picture(0,0,string);
        xPos = -4;
        yPos = -4;
    }

    public boolean isSpawned() {
        return spawned;
    }

    public void setSpawned(boolean spawned) {
        this.spawned = spawned;
    }

    public boolean isJustSpawned() {
        return justSpawned;
    }

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
    public void moveChalk(int x, int y) {
        image.translate(x,y);
    }

    public void show() {
        image.draw();
    }

    public void hide() {
        setxPos(-1);
        setyPos(-1);
        setSpawned(false);
        this.image.delete();
    }

    public ObstacleSpawnPoints chosenSpawnPoint() {
        return ObstacleSpawnPoints.values()[(int) (Math.random() * 2)];
    }


}
