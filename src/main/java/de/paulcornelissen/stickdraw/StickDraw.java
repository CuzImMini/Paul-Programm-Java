package de.paulcornelissen.stickdraw;

import basis.*;

public class StickDraw {
    public static void main(String[] args) {
        new StickDraw();
    }

    private final Fenster fenster;
    private final Stift stift;
    private final BeschriftungsFeld b1;
    private final BeschriftungsFeld b2;
    private final BeschriftungsFeld b3;
    private int anzahlHoelzer = Hilfe.zufall(10, 20);
    private boolean spieler1 = true;
    private boolean ki = false;

    public StickDraw() {

        fenster = new Fenster(600, 500);
        stift = new Stift();

        b1 = new BeschriftungsFeld("Spieler 1", 100, 50, 200, 50);
        b1.setzeSchriftGroesse(22);

        b2 = new BeschriftungsFeld(anzahlHoelzer + " Hölzer", 375, 310, 100, 30);

        b3 = new BeschriftungsFeld("", 250, 360, 200, 30);
        b3.setzeSchriftFarbe(Farbe.ROT);
        b3.setzeSchriftGroesse(12);


        Knopf k1 = new Knopf("-1", 100, 150, 100, 40);
        Knopf k2 = new Knopf("-2", 100, 200, 100, 40);
        Knopf k3 = new Knopf("-3", 100, 250, 100, 40);
        Knopf k4 = new Knopf("KI", 100, 300, 100, 40);
        Knopf k5 = new Knopf("Neues Spiel", 250, 420, 100, 20);

        k1.setzeKnopfLauscher(knopf -> ausfuehren(1));
        k2.setzeKnopfLauscher(knopf -> ausfuehren(2));
        k3.setzeKnopfLauscher(knopf -> ausfuehren(3));
        k4.setzeKnopfLauscher(knopf -> ki = !ki);
        k5.setzeKnopfLauscher(knopf -> newGame());

        this.stickDrawEngine();
    }

    public void ausfuehren(int minusAnzahl) {
        //Änderung Hölzerzahl
        anzahlHoelzer -= minusAnzahl;
        //Zeichnung Hölzer
        this.stickDrawEngine();
        //Spielerwechsel
        spieler1 = !spieler1;
        //Gewinnprüfung
        if (this.checkWin()) {
            return;
        }
        //UI-Änderungen
        refreshUI();
        //KI
        if (ki && !spieler1) {
            kiMove();
        }


    }

    public void refreshUI() {
        b2.setzeText(anzahlHoelzer + " Hölzer");

        if (spieler1) {
            b1.setzeText("Spieler 1");
        } else {
            b1.setzeText("Spieler 2");
        }

    }

    public void stickDrawEngine() {
        fenster.loescheAlles();

        for (int i = 0; i < anzahlHoelzer; i++) {

            stift.bewegeBis(330,280 - i * 10);
            stift.zeichneRechteck(160, 2);

        }
    }

    public boolean checkWin() {
        if (anzahlHoelzer <= 0) {
            if (spieler1) {
                b3.setzeText("Spieler 1 hat verloren.");
            } else {
                b3.setzeText("Spieler 2 hat verloren.");
            }
            return true;
        }
        return false;
    }

    public void kiMove() {
        b3.setzeText("KI ist am Zug...");
        Hilfe.pause(1000);
        switch (anzahlHoelzer) {
            case 4, 8 -> this.ausfuehren(3);
            case 3, 7 -> this.ausfuehren(2);
            case 2, 1, 6 -> this.ausfuehren(1);
            default -> this.ausfuehren(Hilfe.zufall(1, 3));

        }
        b3.setzeText("Spiele weiter...");

    }

    public void newGame() {

        anzahlHoelzer = Hilfe.zufall(10, 20);
        spieler1 = true;
        ki = false;
        b3.setzeText("");
        this.stickDrawEngine();
        this.refreshUI();

    }
}
