package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {
        private boolean spawned;

        private boolean justSpawned;

        private int xPos;

        private int yPos;

        private int speed;

        private Picture box;




        /** Getters/Setters */
        public boolean isSpawned() {
            return spawned;
        }

    public int getSpeed() {
        return speed;
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
            return ObstacleSpawnPoints.values()[(int) (Math.random() * 3)];
        }




    }

