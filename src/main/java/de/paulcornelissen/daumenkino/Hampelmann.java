package de.paulcornelissen.daumenkino;

import basis.Bild;
import basis.Hilfe;
import de.paulcornelissen.paulpaint.Crawler;
import de.paulcornelissen.paulpaint.Instance;

import java.awt.*;

public class Hampelmann {

    private Instance instance;
    private Bild b1, b2, b3;

    public Hampelmann() {

        this.instance = new Instance("Pauls-Daumenkino", 400, 600, true);
        instance.setBackgroundColor(Crawler.getColor("Hellgrau"));
        b1 = new Bild(100, 100, 200, 400);
        b2 = new Bild(100, 100, 200, 400);
        b3 = new Bild(100, 100, 200, 400);

        b1.setzeHintergrundFarbe(Crawler.getColor("Weiß"));
        b2.setzeHintergrundFarbe(Crawler.getColor("Weiß"));
        b3.setzeHintergrundFarbe(Crawler.getColor("Weiß"));
    }


    public void animation() {
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
