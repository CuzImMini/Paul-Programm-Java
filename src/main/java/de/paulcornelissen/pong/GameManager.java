package de.paulcornelissen.pong;

import static de.paulcornelissen.pong.Pong.*;

public class GameManager {


    static int scoreRight = 0;
    static int scoreLeft = 0;

    boolean gameActive;
    GameManager gameManager = this;
    Pong pong;

    Thread gameListener;

    public GameManager() {
    }


    public void startMatch() {
        gameActive = true;

        gameListener = new Thread(new Runnable() {
            @Override
            public void run() {
                ball.movementListener(gameManager);
            }
        });
        gameListener.start();
    }

    public void resetMatch() {
        ball.moveTo(350, 250);
        bouncePadLeft.moveTo(bouncePadLeft.getX(), 175);
        bouncePadRight.moveTo(bouncePadRight.getX(), 175);

        gameListener.stop();
        System.out.println(scoreLeft + scoreRight);
        gameActive = false;
        ball.speed = 1;

    }

    public void goalR() {
        scoreRight++;
    }
    public void goalL() {
        scoreLeft++;
    }


}

