package de.paulcornelissen.pong;

import basis.Fenster;
import basis.Komponente;
import basis.TastenLauscher;

public class Pong {

    static Fenster window;
    static PencilManager pencilManager;
    static BouncePad bouncePadRight;
    static BouncePad bouncePadLeft;
    static Ball ball;
    static GameManager game;
    static ScoreManager scoreManager;

    public Pong() {
        window = new Fenster("Paul-Pong", 700, 500);
        pencilManager = new PencilManager();
        window.setzeTastenLauscher(this.getKeyboardListener());

        bouncePadLeft = new BouncePad(100, 175, pencilManager);
        bouncePadRight = new BouncePad(600, 175, pencilManager);

        ball = new Ball(350,250, pencilManager);

        game = new GameManager();
        scoreManager = new ScoreManager();

    }

    public TastenLauscher getKeyboardListener() {
        TastenLauscher tastenLauscher = new TastenLauscher() {

            @Override
            public void bearbeiteTaste(Komponente komponente, char c) {
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


            }
        };
        return tastenLauscher;
    }


    //TODO
    //  - Fehler beheben: Ball bugght in Bouncepad



}