package io.code4all.varbies;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    public static final int PADDING = 10;


    public static boolean isRestart() {
        return Restart;
    }

    public static void setRestart(boolean restart) {
        Restart = restart;
    }

    private static boolean Restart = false;
    /**Object where the background picture will be stored */
    private Picture backgroundPicture;


    private ObstacleSpawnPoints obstacleSpawnPoints;

    private boolean chalkSpawned;


    private int chalkCounter = 0;

    private int chalkCounterMax = 5;

    private Chalk[] chalk;

    public final static int MOVE_VALUE = -128;
    private int delay = 500;
    /** Used to increment the runBackground method. */
    private int backgroundCounter;

    private int score;

    /** Used to determine the difficulty, making the delay faster */
    private int previousScore;

    public ObstacleLoader getObstacleLoader() {
        return obstacleLoader;
    }

    private ObstacleLoader obstacleLoader;

    private Text scoreVisual;

    private Text difficultyVisual;

    private Picture gameOver;

    private Picture mcPictureGameOver;

    /**Constructor; initializes the important objects for the game. */
    public Field() {




    }


    public void scoreInit() {
        score = 0;
        scoreVisual = new Text(120, 40, String.valueOf(score));
        scoreVisual.grow(10, 10);
        scoreVisual.setColor(Color.RED);
        scoreVisual.draw();
        difficultyVisual = new Text(800,40,"Beta Cadet");
        difficultyVisual.grow(10,10);
        difficultyVisual.setColor(Color.RED);
        difficultyVisual.draw();
    }

    public void runScore() {
        score = score+10;
        scoreVisual.setText(String.valueOf(score));
    }

    public void runDifficulty() {
        if (delay == 80) {
            return;
        }
        if (score > previousScore+100) {
            previousScore = score;
            delay = delay -10;
            System.out.println("I made the game harder " + delay);
        }

        switch (delay) {
            case 400:
                difficultyVisual.setText("Cadet");
                break;
            case 300:
                difficultyVisual.setText("Padawan");
                break;
            case 200:
                difficultyVisual.setText("Jedi");
                break;
            case 150:
                difficultyVisual.setText("Rui Ferrão");
            default :
                break;
        }


    }

    public void init() {

        backgroundPicture = new Picture(PADDING,PADDING, "resources/Background.png");
        backgroundPicture.draw();
        chalkInit();
        obstacleLoader = new ObstacleLoader();
        obstacleLoader.initObstacles();
        scoreInit();


    }

    /** Main game logic; will run the game indefinitely. Should always start with the "thread delay" as to run at a slow pace. */
    public void runGame() throws InterruptedException{

        while(!obstacleLoader.gameOver()) {
            Thread.sleep(delay);
            jumpscare();
            obstacleLoader.runBoxes();


            runScore();
            runDifficulty();
        }
        /** CHANGE THIS PICTURE */
        SoundEffects.playSound("resources/mclaugh.wav");
        gameOver = new Picture(0,0, "resources/EndingNoKeys.png");
        gameOver.draw();
        if ( Menu.flag == 1) {
            mcPictureGameOver = new Picture(700,520, "resources/MC_Zuka.png");
            mcPictureGameOver.grow(150,150);
            mcPictureGameOver.draw();

        }
        /** Generates SinCity */
        else if ( Menu.flag == 2) {
            mcPictureGameOver = new Picture(700,520, "resources/MC_Mike.png");
            mcPictureGameOver.grow(150,150);
            mcPictureGameOver.draw();
        }
        /** Generates Metropolos */
        else if(Menu.flag == 3){
            mcPictureGameOver = new Picture(700,520, "resources/MC_Nosk.png");
            mcPictureGameOver.grow(150,150);
            mcPictureGameOver.draw();

        }


    }

    /** Chalk logic */

    public void chalkInit(){
        chalk = new Chalk[6];
       /** Manually put each picture in each chalk */
       chalk[0] = new Chalk("resources/50 Cent 1600x800.png");
       chalk[1] = new Chalk("resources/931 1600x800.png");
       chalk[2] = new Chalk("resources/Barbie 1600x800.png");
       chalk[3] = new Chalk("resources/Git 1600x800.png");
       chalk[4] = new Chalk("resources/KISS 1600x800.png");
       chalk[5] = new Chalk("resources/Shakira 1600x800.png");


    }

    public void jumpscare() {

       if (chalkSpawned) {
           chalkCounter++;
           if (chalkCounter == chalkCounterMax) {
               chalkSpawned = false;
               chalkCounter = 0;
               for (int i = 0; i < chalk.length; i++) {
                   chalk[i].hide();
               }
               return;
           }
       }

       if (Math.random() > 0.05) {
           return;
       }

        if(!chalkSpawned) {
            int randomNumber = (((int) (Math.random() * 6)));
            chalk[randomNumber].show();
            chalkSpawned = true;
        }

    }

}
