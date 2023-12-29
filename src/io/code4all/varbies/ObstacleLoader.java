package io.code4all.varbies;

public class ObstacleLoader {

    /**
     * Find out why this stack overflows
     */
    //private Box box = new Box(0,0);

    private int xSize;

    private int ySize;

    private Player player;

    private CollisionChecker collisionChecker;

    private Obstacle[] obstacles;

    private int runBoxCounter = -5;


  private  ObstacleSpawnPoints obstacleSpawnPoints;

    public ObstacleLoader() {

    }


    /** Fills the variable with obstacles as to avoid nulls. Default xPos is -4 so collision is impossible */
    public void initObstacles() {
        this.player = new Player();
        new Controls(player);
        this.collisionChecker = new CollisionChecker(player);
        obstacles = new Obstacle[5];
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new Box3();
        }
    }
    /** Method is working for the most part. The biggest issue is that the boxes come out at a rate that is most likely impossible to beat. Testing required */
    public void runBoxes() {

        player.runInvincibility();
        player.mcMove();
        runBoxCounter++;

        /** Logic to run the first obstacle */
        spawnBox(0);
        if(obstacles[0].isJustSpawned()) {
            runBoxCounter = 0;
        }

        /** Logic to run the second obstacle */
        if (runBoxCounter > 3) {
            spawnBox(1);
        }
        if(obstacles[1].isJustSpawned()) {
            runBoxCounter = 3;
        }

        /** Logic for the third box */
        if (runBoxCounter > 6) {
            spawnBox(2);
        }
        if(obstacles[2].isJustSpawned()) {
            runBoxCounter = 6;
        }
        /** Logic for the fourth box */
        if (runBoxCounter == 9) {
            spawnBox(3);
         if(obstacles[3].isJustSpawned()) {
            runBoxCounter = 9;
        } }
        /** Logic for the power ups */
        if (runBoxCounter == 10) {
            if (!obstacles[4].isSpawned() && Math.random() < 0.26 ) {
                 obstacles[4] = new Beer();
                obstacleSpawnPoints = chosenBeerSpawn();
                switch (obstacleSpawnPoints) {
                    case TWO:

                        obstacles[4].moveBox(1470, 199);
                        obstacles[4].setyPos(2);

                        break;
                    case THREE:

                        obstacles[4].moveBox(1470, 333);
                        obstacles[4].setyPos(3);

                        break;
                    case FOUR:

                        obstacles[4].moveBox(1470, 467);
                        obstacles[4].setyPos(4);
                        break;
                    case FIVE:

                        obstacles[4].moveBox(1470, 601);
                        obstacles[4].setyPos(5);
                        break;
                    default: /** Default is Pos ONE */
                        obstacles[4].moveBox(1470, 67);
                        obstacles[4].setyPos(1);
                        break;
                }
                obstacles[4].setxPos(12);
                obstacles[4].show();
                obstacles[4].setSpawned(true);
                obstacles[4].setJustSpawned(true);
            }}


        /** Makes all the objects move, deletes them if they move outside the field */

        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i].isJustSpawned()) {
                obstacles[i].setJustSpawned(false);
                continue;
            }
            if (obstacles[i].isSpawned()) {
                obstacles[i].moveBox(-128+obstacles[i].getSpeed(), 0);
                obstacles[i].setxPos(obstacles[i].getxPos() - 1);
                collisionChecker.CheckUpandDown(obstacles[i]);
                collisionChecker.checkCollision(obstacles[i]);
                collisionChecker.mcCheckCollision(obstacles[i]);

            }

            if (obstacles[i].getxPos() == -1) {

                obstacles[i].hide();
            }
        }
        if (runBoxCounter == 10) {
            runBoxCounter = 0;
        }
    }

    public Obstacle randomObstacle() {
        double randomNumber = Math.random();
        if (randomNumber < 0.33) {
            return new Box3();
        } else if (randomNumber < 0.66) {
            return new Box2();
        }
        return new Box1();
    }


    /** SPECIFIC to the beer's spawn. It will avoid spawning close to the obstacle that comes before it */
    public ObstacleSpawnPoints chosenBeerSpawn() {
        ObstacleSpawnPoints chosenSpawn = ObstacleSpawnPoints.values()[(int) (Math.random() * 4)];

        switch (obstacles[3].getyPos()) {
            case 1:
                chosenSpawn = ObstacleSpawnPoints.values()[(int) (Math.random() * 2+3)];
                break;
            case 2:
                if (Math.random() > 0.50) {
                    chosenSpawn = ObstacleSpawnPoints.ONE;
                } else {
                    chosenSpawn = ObstacleSpawnPoints.FIVE;
                }
                break;
            case 3:
                chosenSpawn = ObstacleSpawnPoints.values()[(int) (Math.random() * 2)];
                break;
            case 4:
                chosenSpawn = ObstacleSpawnPoints.values()[(int) (Math.random() * 3)];
        }

        return chosenSpawn;
    }

    public boolean gameOver() throws InterruptedException {

        if (player.getPosX() < 1) {
            Field.setRestart(true);
            return true;
        }


        return false;
    }

    public void spawnBox(int obstacleIndex) {
        if (!obstacles[obstacleIndex].isSpawned()) {
            obstacles[obstacleIndex] = randomObstacle();
            obstacleSpawnPoints = obstacles[obstacleIndex].chosenSpawnPoint();
            switch (obstacleSpawnPoints) {
                case ONE:

                    obstacles[obstacleIndex].moveBox(1470, 67);
                    obstacles[obstacleIndex].setyPos(1);

                    break;
                case TWO:

                    obstacles[obstacleIndex].moveBox(1470, 199);
                    obstacles[obstacleIndex].setyPos(2);

                    break;
                case THREE:

                    obstacles[obstacleIndex].moveBox(1470, 333);
                    obstacles[obstacleIndex].setyPos(3);

                    break;
                case FOUR:

                    obstacles[obstacleIndex].moveBox(1470, 467);
                    obstacles[obstacleIndex].setyPos(4);
                    break;
                case FIVE:

                    obstacles[obstacleIndex].moveBox(1470, 601);
                    obstacles[obstacleIndex].setyPos(5);
                    break;
            }
            obstacles[obstacleIndex].setxPos(12);
            obstacles[obstacleIndex].show();
            obstacles[obstacleIndex].setSpawned(true);
            obstacles[obstacleIndex].setJustSpawned(true);
        }

    }



}
