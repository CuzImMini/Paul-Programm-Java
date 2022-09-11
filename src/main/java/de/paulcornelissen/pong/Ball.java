package de.paulcornelissen.pong;

import basis.Bild;
import basis.Hilfe;

import java.util.Random;

import static de.paulcornelissen.pong.Pong.game;

public class Ball extends Bild {

    private double xCord;
    private double yCord;
    boolean goal = false;

    int speed = 50;
    PencilManager pencilManager;

    Double direction;
    Double angle;


    public Ball(int x, int y, PencilManager pm) {
        xCord = x - 10;
        yCord = y - 10;
        pencilManager = pm;

        this.setzePosition(xCord, yCord);
        this.setzeGroesse(25, 25);


        pencilManager.setObject(this).zeichneBall();
    }

    public double getX() {
        return xCord;
    }

    public double getY() {
        return yCord;
    }

    public void movementListener(GameManager gameManager) {
        //Direction 1 = rechts
        //Direction -1 = links
        //angle 1 = 45 Grad Winkel
        //angle 0 = 0 Grad Winkel
        direction = (double) getStartDirection();
        angle = (double) 0;
        move();

    }

    public void changeDirection() {
        if (direction == 1) {
            direction = (double) -1;
            angle = getAngle();
            speed--;
            return;
        }
        if (direction == -1) {
            direction = (double) 1;
            angle = getAngle();
            speed--;
        }


    }


    public void move() {
        while (game.gameActive) {
            moveTo(getX() + 2.5 * direction - (1.25 * angle), getY() + (angle * 1.25));
            Hilfe.warte(speed);
        }

    }


    public void moveTo(double x, double y) {
        this.setzePosition(x, y);
        xCord = x;
        yCord = y;
        CollisionListener.checkCollision();

    }

    public int getStartDirection() {

        Random random = new Random();

        boolean directionBoolean = random.nextBoolean();

        if (directionBoolean) {
            return 1;
        } else return -1;
    }

    public double getAngle() {

        Random random = new Random();

        double angleInteger = random.nextDouble(0, 1);

        return angleInteger;
    }


}
