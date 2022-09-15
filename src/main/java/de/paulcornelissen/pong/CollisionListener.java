package de.paulcornelissen.pong;

import basis.Hilfe;

import static de.paulcornelissen.pong.GameManager.scoreLeft;
import static de.paulcornelissen.pong.GameManager.scoreRight;
import static de.paulcornelissen.pong.Pong.*;

public class CollisionListener {


    public CollisionListener() {
    }

    public static int checkCollision() {
        if (ball.kollisionErkanntMit(bouncePadRight)) {
            System.out.println("Collision-R");

            ball.changeDirection();
            Hilfe.warte(25);
            return 1;
        }
        if (ball.kollisionErkanntMit(bouncePadLeft)) {
            System.out.println("Collision-L");

            ball.changeDirection();
            Hilfe.warte(25);
            return 2;
        }
        if (ball.getX() > 675) {
            System.out.println("Goal-at-R");

            game.goalL();
            scoreManager.refresh(scoreLeft, scoreRight);

            game.resetMatch();
            return 3;
        }
        if (ball.getX() < 0) {
            System.out.println("Goal-at-L");

            game.goalR();
            scoreManager.refresh(scoreLeft, scoreRight);

            game.resetMatch();
            return 4;
        }
        if (ball.getY() > 475 || ball.getY() < 0) {
            System.out.println("Collision-Wall");

            ball.bounce();
            return 5;
        }
        return 0;
    }


}
