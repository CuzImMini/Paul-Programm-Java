package de.paulcornelissen.pong;

import static de.paulcornelissen.pong.Pong.*;

public class GameManager {


    private int scoreRight = 0;
    private int scoreLeft = 0;

    boolean gameActive;
    GameManager gameManager = this;

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
        gameActive = false;

    }

}
