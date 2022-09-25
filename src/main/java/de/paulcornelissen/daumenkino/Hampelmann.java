package de.paulcornelissen.daumenkino;

import basis.Bild;
import basis.Hilfe;
import de.paulcornelissen.paulpaint.Crawler;

public class Hampelmann {

    private DaumenkinoInstanceManager instance;
    private final Bild b1, b2, b3;

    public Hampelmann() {

        this.instance = new DaumenkinoInstanceManager("Pauls-Daumenkino", 400, 600, true);
        instance.setBackgroundColor(Crawler.getColor("Hellgrau"));
        b1 = new Bild(100, 100, 200, 400);
        b2 = new Bild(100, 100, 200, 400);
        b3 = new Bild(100, 100, 200, 400);

        b1.setzeHintergrundFarbe(Crawler.getColor("Weiß"));
        b2.setzeHintergrundFarbe(Crawler.getColor("Weiß"));
        b3.setzeHintergrundFarbe(Crawler.getColor("Weiß"));
        this.animation();
    }


    public void animation() {
        instance.setObject(b3).zeichneHampelmannOben();
        instance.setObject(b2).zeichneHampelmannMitte();
        instance.setObject(b1).zeichneHampelmannUnten();

        b1.setzeSichtbar(false);
        b2.setzeSichtbar(false);
        b3.setzeSichtbar(false);

        Thread t = new Thread(() -> {
            while (true) {
                while (true) {
                    Daumenkino();
                }
            }
        });
        t.start();
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
