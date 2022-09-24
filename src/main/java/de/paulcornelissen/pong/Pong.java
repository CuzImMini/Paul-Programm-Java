package de.paulcornelissen.pong;

import basis.Fenster;
import basis.TastenLauscher;

public class Pong {

    static Fenster window;
    static PongPencilManager pongPencilManager;
    static BouncePad bouncePadRight;
    static BouncePad bouncePadLeft;
    static Ball ball;
    static GameManager game;
    static ScoreManager scoreManager;

    public Pong() {
        window = new Fenster("Paul-Pong", 700, 500);
        window.getMeinJFrame().setLocationRelativeTo(null);
        pongPencilManager = new PongPencilManager();
        window.setzeTastenLauscher(this.getKeyboardListener());

        bouncePadLeft = new BouncePad(100, 175, pongPencilManager);
        bouncePadRight = new BouncePad(600, 175, pongPencilManager);

        ball = new Ball(350,250, pongPencilManager);

        game = new GameManager();
        scoreManager = new ScoreManager();

    }

    public TastenLauscher getKeyboardListener() {
        return (komponente, c) -> {
            if (c == 'k') {
                bouncePadRight.down();
            }
            if (c == 'i') {
                bouncePadRight.up();
            }
            if (c == 'd') {
                bouncePadLeft.down();
            }
            if (c == 'e') {
                bouncePadLeft.up();
            }
            if (c == 'g') {
                game.startMatch();
            }
            if (c == 'q') {
                game.resetMatch();
            }


        };
    }


    //TODO
    //  - Fehler beheben: Ball bugght in Bouncepad



}
