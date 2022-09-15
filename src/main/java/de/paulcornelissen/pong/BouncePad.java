package de.paulcornelissen.pong;

import basis.Bild;

public class BouncePad extends Bild {

    private double xCord;
    private double yCord;
    PencilManager pencilManager;

    public BouncePad(int x, int y, PencilManager pm) {
        xCord = x;
        yCord = y;
        pencilManager = pm;
        this.setzePosition(xCord,yCord);
        this.setzeGroesse(25,150);

        this.setzeVereinfachteKollisionerkennung(true);

        pencilManager.setObject(this).zeichneBouncepad();
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

    public void up()  {
        if(yCord < 0) {return;}
        moveTo(getX(),getY()-20);
    }
    public void moveTo(double x, double y) {
        this.setzePosition(x,y);
        xCord = x;
        yCord = y;
        CollisionListener.checkCollision();
    }

}
