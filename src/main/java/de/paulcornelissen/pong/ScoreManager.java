package de.paulcornelissen.pong;

import basis.Bild;
import de.paulcornelissen.paulpaint.Crawler;

public class ScoreManager extends Bild {

    private PongPencilManager pongPencilManager;

    public ScoreManager(Pong pong) {
        this.setzePosition(280, 75);
        this.setzeHintergrundFarbe(Crawler.getColor("Hellgrau"));
        this.setzeGroesse(150, 60);
        pongPencilManager = pong.getPongPencilManager();
        pongPencilManager.setObject(this).zeichneSpielstand(0, 0);
    }

    public void refresh(int left, int right) {
        this.reset();
        System.out.println("Refresh");
        pongPencilManager.setObject(this).zeichneSpielstand(left, right);
    }

    public void reset() {
        this.loescheAlles();
        this.setzeHintergrundFarbe(Crawler.getColor("Hellgrau"));
    }

    public void clear() {
        this.setzeSichtbar(false);
    }

}
