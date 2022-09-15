package de.paulcornelissen.pong;

import basis.Stift;

import java.awt.*;

public class PencilManager extends Stift {

    //Konstruktor
    public PencilManager() {
    }

    public PencilManager setObject(Object object) {
        this.maleAuf(object);
        return this;
    }

    public PencilManager setPosition(int x, int y, int rotation) {
        this.bewegeBis(x, y);
        this.dreheBis(rotation);
        return this;
    }

    public void zeichneBouncepad() {
        this.setzeLinienBreite(5);
        this.zeichneRechteck(25,150);
    }

    public void zeichneBall() {
        this.setzeLinienBreite(12);
        this.bewegeUm(12.5);
        this.dreheUm(270);
        this.bewegeUm(12.5);
        this.zeichneKreis(6);
    }

    public void zeichneSpielstand(int bplScore, int bprScore) {

        this.setzeSchriftGroesse(50);;
        this.dreheUm(270);
        this.bewegeUm(47);
        this.dreheUm(90);
        this.bewegeUm(18);
        this.schreibeText(bplScore + "   " + bprScore);


    }


}
