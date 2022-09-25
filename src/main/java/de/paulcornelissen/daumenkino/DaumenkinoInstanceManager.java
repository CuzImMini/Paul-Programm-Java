package de.paulcornelissen.daumenkino;

import basis.Fenster;
import basis.Stift;
import de.paulcornelissen.paulpaint.Pencil;

import javax.swing.*;
import java.awt.Color;

public class DaumenkinoInstanceManager {

    Fenster fenster;
    Stift pencil;

    public DaumenkinoInstanceManager(String n, int b, int h, boolean summonPencil) {

        fenster = new Fenster(n, b, h);
        fenster.getMeinJFrame().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        if (summonPencil) {
            pencil = new Stift();
        }
    }

    public DaumenkinoInstanceManager setObject(Object o) {
        pencil.maleAuf(o);
        return this;
    }

    public void setBackgroundPhoto(String p) {
        fenster.ladeBildInZeichenflaeche(p);
    }

    public void setBackgroundColor(Color color) {
        fenster.setzeHintergrundFarbe(color);
    }

    public void zeichneHampelmannUnten() {
        zeichneHampelmannHelper();

        this.pencil.dreheUm(135);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(180);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(270);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(180);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(315);
        this.pencil.bewegeUm(30);

        this.pencil.hoch();
        this.pencil.bewegeUm(30);
        this.pencil.zeichneKreis(30);
    }

    private void zeichneHampelmannHelper() {
        this.pencil.setzeLinienBreite(5);

        this.pencil.bewegeUm(100);
        this.pencil.dreheUm(270);
        this.pencil.bewegeUm(275);

        this.pencil.runter();
        this.pencil.dreheUm(45);
        this.pencil.bewegeUm(75);
        this.pencil.dreheUm(180);
        this.pencil.bewegeUm(75);
        this.pencil.dreheUm(90);
        this.pencil.bewegeUm(75);
        this.pencil.dreheUm(180);
        this.pencil.bewegeUm(75);
        this.pencil.dreheUm(45);
        this.pencil.bewegeUm(75);
    }

    public void zeichneHampelmannMitte() {
        zeichneHampelmannHelper();

        this.pencil.dreheUm(90);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(180);
        this.pencil.bewegeUm(120);
        this.pencil.dreheUm(180);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(270);
        this.pencil.bewegeUm(30);

        this.pencil.hoch();
        this.pencil.bewegeUm(30);
        this.pencil.zeichneKreis(30);
    }

    public void zeichneHampelmannOben() {
        zeichneHampelmannHelper();

        this.pencil.dreheUm(45);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(180);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(90);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(180);
        this.pencil.bewegeUm(60);
        this.pencil.dreheUm(225);
        this.pencil.bewegeUm(30);

        this.pencil.hoch();
        this.pencil.bewegeUm(30);
        this.pencil.zeichneKreis(30);
    }
}
