package de.paulcornelissen.tictactoe;

import basis.Stift;

import java.awt.*;
import java.io.IOException;

public class TicTacToePencilManager extends Stift {

    //Konstruktor
    public TicTacToePencilManager() {
    }

    public TicTacToePencilManager setObject(Object object) {
        this.maleAuf(object);
        return this;
    }

    public void zeichneRaster() {
        this.setzeLinienBreite(3);

        this.bewegeBis(210, 10);
        this.runter();
        this.bewegeBis(210, 610);
        this.hoch();

        this.bewegeBis(410, 10);
        this.runter();
        this.bewegeBis(410, 610);
        this.hoch();

        this.bewegeBis(10, 210);
        this.runter();
        this.bewegeBis(610, 210);
        this.hoch();

        this.bewegeBis(10, 410);
        this.runter();
        this.bewegeBis(610, 410);
        this.hoch();
    }

    public void zeichneX() {
        this.setzeLinienBreite(5);
        this.hoch();

        this.dreheUm(315);
        this.bewegeUm(15);

        this.runter();

        this.bewegeUm(233);
        this.dreheUm(135);
        this.hoch();
        this.bewegeUm(162);
        this.runter();
        this.dreheUm(135);
        this.bewegeUm(233);
        this.hoch();
    }

    public void zeichneO() {
        this.setzeLinienBreite(5);
        this.hoch();

        this.bewegeUm(90);
        this.dreheUm(270);
        this.bewegeUm(90);

        this.runter();
        this.zeichneKreis(80);
        this.hoch();
    }

    public void zeichneWinHorizont(Feld object1, Feld object2) {
        this.setzeLinienBreite(15);
        this.setzeFarbe(Color.RED);

        this.bewegeBis(object1.getX() - 25, object1.getY() + 90);
        this.runter();
        this.bewegeBis(object2.getX() + 200, object2.getY() + 90);

        this.hoch();
        this.setzeFarbe(Color.black);

    }

    public void zeichneWinVertikal(Feld object1, Feld object2) {
        this.setzeLinienBreite(15);
        this.setzeFarbe(Color.RED);

        this.bewegeBis(object1.getX() + 90, object1.getY() - 25);
        this.runter();
        this.bewegeBis(object2.getX() + 90, object2.getY() + 200);

        this.hoch();
        this.setzeFarbe(Color.black);

    }

    public void zeichneWinQuerL(Feld object1, Feld object2) {
        this.setzeLinienBreite(15);
        this.setzeFarbe(Color.RED);

        this.bewegeBis(object1.getX() - 180, object1.getY() - 180);
        this.runter();
        this.bewegeBis(object2.getX() + 280, object2.getY() + 280);

        this.hoch();
        this.setzeFarbe(Color.black);
    }

    public void zeichneWinQuerR(Feld object1, Feld object2) {
        this.setzeLinienBreite(15);
        this.setzeFarbe(Color.RED);

        this.bewegeBis(object1.getX() + 360, object1.getY() - 180);
        this.runter();
        this.bewegeBis(object2.getX() - 180, object2.getY() + 360);

        this.hoch();
        this.setzeFarbe(Color.black);
    }

    public void zeichneWinPlayer(int player) {
        this.dreheBis(0);
        this.bewegeUm(30);
        zeichneHelper();

        this.schreibeText("Sieg für");
        this.bewegeUm(-120);
        this.dreheUm(270);
        this.bewegeUm(45);
        if (player == 1) {
            this.schreibeText("Spieler O");
        } else if (player == 2) {
            this.schreibeText("Spieler X");
        }

    }

    public void zeichneUnentschieden() {
        this.dreheBis(0);
        this.bewegeUm(50);
        zeichneHelper();

        this.schreibeText("Kein");
        this.bewegeUm(-100);
        this.dreheUm(270);
        this.bewegeUm(45);
        this.schreibeText("Gewinner");
    }

    private void zeichneHelper() {
        this.dreheUm(270);
        this.bewegeUm(40);
        this.setzeFarbe(Color.orange);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new java.io.File("./repo/de/fonts/BungeeSpice.ttf")).deriveFont(Font.PLAIN, 30);
            this.setzeSchriftArt(font);
        } catch (IOException | FontFormatException e) {
            System.out.println("Fehler");
        }
        this.setzeSchriftGroesse(30);
    }

    public void rForReset() {
        this.bewegeUm(15);
        this.dreheUm(270);
        this.bewegeUm(50);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new java.io.File("./repo/de/fonts/BungeeSpice.ttf")).deriveFont(Font.PLAIN, 15);
            this.setzeSchriftArt(font);
        } catch (IOException | FontFormatException e) {
            System.out.println("Fehler");
        }

        this.setzeSchriftGroesse(15);

        this.schreibeText("Drücke R zum Reset!");
    }
}
