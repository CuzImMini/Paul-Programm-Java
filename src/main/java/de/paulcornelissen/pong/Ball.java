package de.paulcornelissen.pong;

import basis.Bild;
import basis.Hilfe;

import java.util.Random;

import static de.paulcornelissen.pong.Pong.*;

public class Ball extends Bild {

    private double xCord;
    private double yCord;
    boolean goal = false;

    int speed = 40;
    PongPencilManager pongPencilManager;

    Double direction;
    Double angle;


    public Ball(int x, int y, PongPencilManager pm) {
        xCord = x - 10;
        yCord = y - 10;
        pongPencilManager = pm;

        this.setzePosition(xCord, yCord);
        this.setzeGroesse(30, 30);


        pongPencilManager.setObject(this).zeichneBall();
    }

    public double getX() {
        return xCord;
    }

    public double getY() {
        return yCord;
    }

    public void movementListener() {
        //Direction 1 = rechts
        //Direction -1 = links
        //angle 1 = 45 Grad Winkel
        //angle 0 = 0 Grad Winkel
        direction = (double) getStartDirection();
        angle = (double) 0;
        move();

    }

    public void changeDirection() {
        direction = direction * (-1);
        if(this.getChance()) {angle = getAngle();}
        if (speed < 30) {return;}
        speed = (int) (speed * 0.9);

    }

    public void bounce() {
        this.angle = angle * (-1);
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

        return random.nextDouble(0, 1);
    }

    public boolean getChance() {

        Random random = new Random();

        return random.nextBoolean();
    }


}
