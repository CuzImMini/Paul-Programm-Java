package de.paulcornelissen.pong;

import basis.Bild;
import basis.Hilfe;

import java.util.Random;

public class Ball extends Bild {

    private double xCord;
    private double yCord;
    public boolean rightCollision;
    public int direction;
    public float angle;
    int speed = 35;
    private Pong pong;


    public Ball(int x, int y, Pong pong) {
        xCord = x - 10;
        yCord = y - 10;
        this.pong = pong;

        this.setzePosition(xCord, yCord);
        this.setzeGroesse(30, 30);

        pong.getPongPencilManager().setObject(this).zeichneBall();
    }

    public double getX() {
        return xCord;
    }

    public double getY() {
        return yCord;
    }

    public void movementListener() {
        direction = getStartDirection();
        angle = (float) 0;
        move();
    }

    public void changeDirection() {
        direction = direction * (-1);
        if (this.getChance()) {
            angle = (float) getAngle();
        }
        if (speed < 8) {
            return;
        }
        speed = (int) (speed * 0.8);
    }

    public void bounce() {
        this.angle = angle * (-1);
    }


    public void move() {
        while (pong.getGameStatus()) {
            moveTo(getX() + 2.5 * direction - (1.25 * angle), getY() + (angle * 1.25));
            Hilfe.warte(speed);
        }

    }


    public void moveTo(double x, double y) {
        this.setzePosition(x, y);
        xCord = x;
        yCord = y;
        pong.getCollisionListener().checkCollision();

    }

    public int getStartDirection() {

        Random random = new Random();

        boolean directionBoolean = random.nextBoolean();

        if (directionBoolean) {
            rightCollision = false;
            return 1;
        } else {
            rightCollision = true;
            return -1;
        }

    }

    public double getAngle() {

        Random random = new Random();

        return random.nextDouble(0, 1);
    }

    public boolean getChance() {

        Random random = new Random();

        return random.nextBoolean();
    }

    public void clear() {
        this.setzeSichtbar(false);
    }

}
