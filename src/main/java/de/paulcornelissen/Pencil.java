package de.paulcornelissen;

import basis.IgelStift;

import java.awt.*;

public class Pencil extends IgelStift {

    //Konstruktor
    public Pencil() {
    }

    //Methoden
    public Pencil setColor(Color color) {
        this.setzeFarbe(color);
        return this;
    }

    public Pencil setObject(Object object) {
        this.maleAuf(object);
        return this;
    }

    public Pencil setPosition(int x, int y, int rotation) {
        this.bewegeBis(x, y);
        this.dreheBis(rotation);
        return this;
    }

    public Pencil setPosition(int x, int y) {

        this.bewegeBis(x, y);
        return this;
    }
    public Pencil setPosition(int rotation) {

        this.dreheBis(rotation);
        return this;
    }


    public void zeichneBaum() {
        this.runter();
        this.dreheUm(315);
        this.bewegeUm(75);
        this.dreheUm(225);
        this.bewegeUm(40);
        this.dreheUm(135);
        this.bewegeUm(75);
        this.dreheUm(225);
        this.bewegeUm(50);
        this.dreheUm(90);
        this.bewegeUm(50);
        this.dreheUm(270);
        this.bewegeUm(35);
        this.dreheUm(270);
        this.bewegeUm(50);
        this.dreheUm(90);
        this.bewegeUm(50);
        this.dreheUm(225);
        this.bewegeUm(75);
        this.dreheUm(135);
        this.bewegeUm(40);
        this.dreheUm(225);
        this.bewegeUm(75);
        this.hoch();
        this.bewegeBis(0, 0);


    }

    public void zeichneBuchstabe() {

        this.runter();
        this.bewegeUm(100);
        this.dreheUm(270);
        this.bewegeUm(50);
        this.dreheUm(270);
        this.bewegeUm(100);
        this.dreheUm(90);
        this.bewegeUm(50);
        this.dreheUm(90);
        this.bewegeUm(100);
        this.dreheUm(270);
        this.bewegeUm(50);
        this.dreheUm(270);
        this.bewegeUm(100);
        this.dreheUm(90);
        this.bewegeUm(50);
        this.dreheUm(90);
        this.bewegeUm(100);
        this.dreheUm(270);
        this.bewegeUm(50);
        this.dreheUm(270);
        this.bewegeUm(150);
        this.dreheUm(270);
        this.bewegeUm(250);
        this.dreheUm(270);
        this.bewegeUm(50);
        this.hoch();
        this.bewegeBis(0, 0);

    }

    public void zeichneHaus() {

        this.runter();
        for (int i = 0; i < 3; i++) {
            this.bewegeUm(75);
            this.dreheUm(90);
        }

        this.bewegeUm(75);
        this.dreheUm(135);
        this.bewegeUm(106);

        for (int i = 0; i < 2; i++) {
            this.dreheUm(90);
            this.bewegeUm(53);
        }

        this.dreheUm(90);
        this.bewegeUm(106);
        this.hoch();
        this.bewegeBis(0, 0);

    }

    public void zeichneStern() {

        this.runter();

        for (int i = 0; i < 4; i++) {
            this.dreheUm(315);
            this.bewegeUm(50);
            this.dreheUm(135);
            this.bewegeUm(50);
        }
        this.dreheUm(270);
        this.hoch();
        this.bewegeUm(10);
        this.runter();
        this.dreheUm(90);

        this.dreheUm(315);
        this.bewegeUm(60);
        this.dreheUm(135);
        this.bewegeUm(65);
        this.dreheUm(315);
        this.bewegeUm(60);
        this.dreheUm(135);
        this.bewegeUm(60);
        this.dreheUm(315);
        this.bewegeUm(65);
        this.dreheUm(135);
        this.bewegeUm(65);
        this.dreheUm(315);
        this.bewegeUm(60);
        this.dreheUm(135);
        this.bewegeUm(60);
        this.hoch();
        this.bewegeBis(0, 0);


    }

    public void zeichneHampelmannUnten() {
        this.setzeLinienBreite(5);

        this.bewegeUm(100);
        this.dreheUm(270);
        this.bewegeUm(275);

        this.runter();
        this.dreheUm(45);
        this.bewegeUm(75);
        this.dreheUm(180);
        this.bewegeUm(75);
        this.dreheUm(90);
        this.bewegeUm(75);
        this.dreheUm(180);
        this.bewegeUm(75);
        this.dreheUm(45);
        this.bewegeUm(75);

        this.dreheUm(135);
        this.bewegeUm(60);
        this.dreheUm(180);
        this.bewegeUm(60);
        this.dreheUm(270);
        this.bewegeUm(60);
        this.dreheUm(180);
        this.bewegeUm(60);
        this.dreheUm(315);
        this.bewegeUm(30);

        this.hoch();
        this.bewegeUm(30);
        this.zeichneKreis(30);
    }

    public void zeichneHampelmannMitte() {
        this.setzeLinienBreite(5);

        this.bewegeUm(100);
        this.dreheUm(270);
        this.bewegeUm(275);

        this.runter();
        this.dreheUm(45);
        this.bewegeUm(75);
        this.dreheUm(180);
        this.bewegeUm(75);
        this.dreheUm(90);
        this.bewegeUm(75);
        this.dreheUm(180);
        this.bewegeUm(75);
        this.dreheUm(45);
        this.bewegeUm(75);

        this.dreheUm(90);
        this.bewegeUm(60);
        this.dreheUm(180);
        this.bewegeUm(120);
        this.dreheUm(180);
        this.bewegeUm(60);
        this.dreheUm(270);
        this.bewegeUm(30);

        this.hoch();
        this.bewegeUm(30);
        this.zeichneKreis(30);
    }

    public void zeichneHampelmannOben() {
        this.setzeLinienBreite(5);

        this.bewegeUm(100);
        this.dreheUm(270);
        this.bewegeUm(275);

        this.runter();
        this.dreheUm(45);
        this.bewegeUm(75);
        this.dreheUm(180);
        this.bewegeUm(75);
        this.dreheUm(90);
        this.bewegeUm(75);
        this.dreheUm(180);
        this.bewegeUm(75);
        this.dreheUm(45);
        this.bewegeUm(75);

        this.dreheUm(45);
        this.bewegeUm(60);
        this.dreheUm(180);
        this.bewegeUm(60);
        this.dreheUm(90);
        this.bewegeUm(60);
        this.dreheUm(180);
        this.bewegeUm(60);
        this.dreheUm(225);
        this.bewegeUm(30);

        this.hoch();
        this.bewegeUm(30);
        this.zeichneKreis(30);
    }


}
