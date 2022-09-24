package de.paulcornelissen.pong;

import static de.paulcornelissen.pong.Pong.*;

public class GameManager {


    static int scoreRight = 0;
    static int scoreLeft = 0;

    boolean gameActive;
    Thread gameListener;

    public GameManager() {
    }


    public void startMatch() {
        gameActive = true;

        gameListener = new Thread(() -> ball.movementListener());
        gameListener.start();
    }

    public void resetMatch() {
        ball.moveTo(350, 250);
        bouncePadLeft.moveTo(bouncePadLeft.getX(), 175);
        bouncePadRight.moveTo(bouncePadRight.getX(), 175);

        gameListener.interrupt();
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

