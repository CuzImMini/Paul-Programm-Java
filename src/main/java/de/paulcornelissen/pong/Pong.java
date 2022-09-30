package de.paulcornelissen.pong;

import basis.Fenster;
import basis.TastenLauscher;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Pong {

    public BouncePad bouncePadRight;
    public final BouncePad bouncePadLeft;
    public final GameManager game;
    private final Fenster window;
    private final PongPencilManager pongPencilManager;
    private final Ball ball;
    private final CollisionListener collisionListener;
    public ScoreManager scoreManager;
    boolean gameActive = false;

    boolean cheatRight = false;

    public Pong() {
        window = new Fenster("Paul-Pong", 700, 500);
        window.getMeinJFrame().setLocationRelativeTo(null);
        window.getMeinJFrame().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pongPencilManager = new PongPencilManager();
        window.setzeTastenLauscher(this.getKeyboardListener());

        ball = new Ball(350, 250, this);
        bouncePadLeft = new BouncePad(100, 175, this);
        bouncePadRight = new BouncePad(600, 175, this);

        game = new GameManager(this);
        scoreManager = new ScoreManager(this);
        collisionListener = new CollisionListener(this);

    }

    public void win(String s) {
        this.setGameStatus(false);

        scoreManager.clear();
        bouncePadLeft.clear();
        bouncePadRight.clear();
        ball.clear();
        pongPencilManager.maleAuf(window);
        pongPencilManager.setzeFarbe(Color.orange);
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new java.io.File("./repo/de/fonts/BungeeSpice.ttf")).deriveFont(Font.PLAIN, 30);
            pongPencilManager.setzeSchriftArt(font);
        } catch (IOException | FontFormatException e) {
            System.out.println("Fehler");
        }

        pongPencilManager.setzeSchriftGroesse(30);
        pongPencilManager.setPosition(260, 200, 0);
        pongPencilManager.schreibeText("Sieg für");
        pongPencilManager.setPosition(260, 250, 0);
        pongPencilManager.schreibeText(s);

        pongPencilManager.setPosition(278, 285, 0);
        pongPencilManager.setzeSchriftGroesse(15);

        pongPencilManager.schreibeText("Drücke R zum Reset!");


    }


    public TastenLauscher getKeyboardListener() {
        return (komponente, c) -> {
            switch (c) {
                case '+':
                    if(cheatRight) {
                        break;
                    }
                    cheatRight = true;
                    bouncePadRight.cheat();
                    break;
                case 'k':
                    if (cheatRight) {return;}
                    bouncePadRight.down();
                    break;
                case 'i':
                    if (cheatRight) {return;}
                    bouncePadRight.up();
                    break;
                case 'd':
                    bouncePadLeft.down();
                    break;
                case 'e':
                    bouncePadLeft.up();
                    break;
                case 'g':
                    if (gameActive) {
                        game.continueMatch();
                        break;
                    }
                    game.startMatch();
                    break;
                case 'r':
                    game.restartMatch();
                    break;

            }


        };}

    public PongPencilManager getPongPencilManager() {
        return pongPencilManager;
    }

    public BouncePad getBouncePadRight() {
        return bouncePadRight;
    }

    public BouncePad getBouncePadLeft() {
        return bouncePadLeft;
    }

    public boolean getGameStatus() {
        return gameActive;
    }

    public void setGameStatus(boolean status) {
        gameActive = status;
    }

    public GameManager getGameManager() {
        return game;
    }

    public ScoreManager getScoreManager() {
        return scoreManager;
    }

    public Ball getBall() {
        return ball;
    }

    public Fenster getWindow() {
        return window;
    }

    public CollisionListener getCollisionListener() {
        return collisionListener;
    }

    public void resetScoreboard() {
        scoreManager = new ScoreManager(this);
    }

    public boolean getCheatMode() {
        return cheatRight;
    }
    public void setCheatMode(boolean mode) {
        cheatRight = mode;
    }

}
