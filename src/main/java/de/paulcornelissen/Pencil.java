package de.paulcornelissen;

import basis.IgelStift;

import java.awt.*;

public class Pencil extends IgelStift {

    //Konstruktor
    public Pencil() {
    }

    //Methoden
    public void zeichneBaum(int x, int y, int rotation, Color color) {

        this.setzeFarbe(color);

        this.dreheBis(rotation);
        this.bewegeBis(x, y);
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

    public void zeichneBuchstabe(int x, int y, int rotation, Color color) {
        this.setzeFarbe(color);

        this.bewegeBis(x + 50, y);
        this.dreheBis(rotation);
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

    public void zeichneHaus(int x, int y, int rotation, Color color) {
        this.setzeFarbe(color);
        this.bewegeBis(x, y);
        this.dreheBis(rotation);
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

    public void zeichneStern(int x, int y, int rotation, Color color) {
        this.setzeFarbe(color);
        this.bewegeBis(x, y);
        this.dreheBis(rotation);
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


    public void drawingCrawler(String object, int x, int y, int rotation, String color) {

        if (object.equals("Baum")) {
            this.zeichneBaum(x, y, rotation, ColorCrawler.getColor(color));
            return;
        }

        if (object.equals("Buchstabe")) {
            this.zeichneBuchstabe(x, y, rotation, ColorCrawler.getColor(color));
            return;
        }

        if (object.equals("Stern")) {
            this.zeichneStern(x, y, rotation, ColorCrawler.getColor(color));
            return;
        }

        if (object.equals("Haus")) {
            this.zeichneHaus(x, y, rotation, ColorCrawler.getColor(color));
        }

    }
}
