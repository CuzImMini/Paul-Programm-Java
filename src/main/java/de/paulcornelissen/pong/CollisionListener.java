package de.paulcornelissen.pong;

import basis.Hilfe;

import static de.paulcornelissen.pong.Pong.*;

public class CollisionListener {


    public CollisionListener() {
    }

    public static int checkCollision() {
        if (ball.kollisionErkanntMit(bouncePadRight)) {
            System.out.println("Collision-R");
            Hilfe.warte(10);

            ball.changeDirection();
            return 1;
        }
        if (ball.kollisionErkanntMit(bouncePadLeft)) {
            System.out.println("Collision-L");
            Hilfe.warte(10);

            ball.changeDirection();
            return 2;
        }
        if (ball.getX() > 610) {
            System.out.println("Goal-at-R");
            game.resetMatch();
            return 3;
        }
        if (ball.getX() < 90 ) {
            System.out.println("Goal-at-L");
            game.resetMatch();
            return 4;
        }
        //TODO: Kollision mit oberem und unterem Rand einfügen
        //              - Methode bounceUP/bounceDown
        return 0;
    }


}
