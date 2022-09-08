package de.paulcornelissen;

import basis.Bild;
import basis.Hilfe;

import java.awt.*;

public class Bildergalerie {

    private Instance instance;
    private Bild b1, b2, b3;

    public Bildergalerie() {
        this.initialize();
    }

    public void initialize() {
        instance = new Instance("Bildergalerie", 400, 600, true);
        instance.setBackgroundColor(Crawler.getColor("Hellgrau"));
        b1 = new Bild(100, 100, 200, 400);
        b2 = new Bild(100, 100, 200, 400);
        b3 = new Bild(100, 100, 200, 400);

        b1.setzeHintergrundFarbe(Crawler.getColor("Weiß"));
        b2.setzeHintergrundFarbe(Crawler.getColor("Weiß"));
        b3.setzeHintergrundFarbe(Crawler.getColor("Weiß"));
        this.malen();

    }

    public void malen() {
        instance.drawingCrawler("Hampelmann-oben", 0, 0, 0, Color.black, b3);
        instance.drawingCrawler("Hampelmann-mitte", 0, 0, 0, Color.BLACK, b2);
        instance.drawingCrawler("Hampelmann-unten", 0, 0, 0, Color.BLACK, b1);

        instance.getPencil().setzeSichtbar(false);

        b1.setzeSichtbar(false);
        b2.setzeSichtbar(false);
        b3.setzeSichtbar(false);


        while (true) {
            Daumenkino();


        }
    }

    public void Daumenkino() {
        b3.setzeSichtbar(false);
        b1.setzeSichtbar(true);
        Hilfe.warte(300);
        b1.setzeSichtbar(false);
        b2.setzeSichtbar(true);
        Hilfe.warte(300);
        b2.setzeSichtbar(false);
        b3.setzeSichtbar(true);
        Hilfe.warte(300);
    }
}
