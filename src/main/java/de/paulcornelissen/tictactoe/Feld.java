package de.paulcornelissen.tictactoe;

import basis.Bild;

public class Feld extends Bild {

    int belegt = 90;

    public Feld(int x,int y, int breite, int hoehe) {
        this.setzeGroesse(breite, hoehe);
        this.setzePosition(x,y);
    }

    public int getX() {return (int) this.hPosition();
    }
    public int getY() {return (int) this.vPosition();}

}
