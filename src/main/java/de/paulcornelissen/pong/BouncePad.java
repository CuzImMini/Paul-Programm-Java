package de.paulcornelissen.pong;

import basis.Bild;

public class BouncePad extends Bild {

    private double xCord;
    private double yCord;
    PongPencilManager pongPencilManager;

    public BouncePad(int x, int y, Pong pong) {
        xCord = x;
        yCord = y;
        pongPencilManager = pong.getPongPencilManager();
        this.setzePosition(xCord, yCord);
        this.setzeGroesse(25, 150);

        pongPencilManager.setObject(this).zeichneBouncepad();
    }


    public double getX() {
        return xCord;
    }

    public double getY() {
        return yCord;
    }

    public void down() {
        if(yCord > 350) {return;}
        moveTo(getX(),getY()+20);

    }

    public void up() {
        if (yCord < 0) {
            return;
        }
        moveTo(getX(), getY() - 20);
    }

    public void moveTo(double x, double y) {
        this.setzePosition(x, y);
        xCord = x;
        yCord = y;
    }

    public void clear() {
        this.setzeSichtbar(false);
    }

    public void singlePlayer() {
        this.setzeGroesse(25, 500);
        yCord = 0;
        this.setzePosition(getX(), getY());
        pongPencilManager.setObject(this).zeichneSinglePlayerPad();

    }

    public void singlePlayerOff() {
        this.loescheAlles();
        this.setzeGroesse(25, 150);
        pongPencilManager.setObject(this).zeichneBouncepad();
        yCord = 175;
        this.setzePosition(xCord, yCord);

    }

}
