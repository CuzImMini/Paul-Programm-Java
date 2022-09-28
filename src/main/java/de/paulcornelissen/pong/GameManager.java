package de.paulcornelissen.pong;

public class GameManager {


    private final BouncePad bouncePadLeft;
    private final BouncePad bouncePadRight;
    private final Pong pong;
    int scoreRight = 0;
    int scoreLeft = 0;
    private Ball ball;
    Thread gameListener;

    public GameManager(Pong pong) {
        bouncePadLeft = pong.getBouncePadLeft();
        bouncePadRight = pong.getBouncePadRight();
        ball = pong.getBall();
        this.pong = pong;
    }


    public void startMatch() {
        pong.setGameStatus(true);
        gameListener = new Thread(ball::movementListener);
        gameListener.start();
    }

    public void resetMatch() {
        ball.moveTo(350, 250);
        bouncePadLeft.moveTo(bouncePadLeft.getX(), 175);
        bouncePadRight.moveTo(bouncePadRight.getX(), 175);

        pong.setGameStatus(false);
    }

    public void restartMatch() {
        pong.getWindow().loescheAlles();
        ball.setzeSichtbar(true);
        bouncePadLeft.setzeSichtbar(true);
        bouncePadRight.setzeSichtbar(true);
        pong.resetScoreboard();

        pong.getBall().speed = 35;
        scoreLeft = 0;
        scoreRight = 0;

        ball.moveTo(350, 250);
        bouncePadLeft.moveTo(bouncePadLeft.getX(), 175);
        bouncePadRight.moveTo(bouncePadRight.getX(), 175);

        pong.setGameStatus(false);
    }

    public void continueMatch() {
        if (pong.gameActive) {
            return;
        }
        gameListener.start();
        ball.speed = 35;
    }

    public void goalR() {
        scoreRight++;
        this.checkWin();
    }

    public void goalL() {
        scoreLeft++;
        this.checkWin();
    }

    public void checkWin() {
        System.out.println("PRÜFUNG | Links: " + scoreLeft + " Rechts: " + scoreRight);
        if (scoreRight == 2) {
            System.out.println("Rechts hat gewonnen!");
            pong.win("rechten Spieler");
            gameListener.interrupt();
            return;
        }
        if (scoreLeft == 2) {
            System.out.println("Links hat gewonnen!");
            pong.win("linken Spieler");
            gameListener.interrupt();
        }
    }
}

