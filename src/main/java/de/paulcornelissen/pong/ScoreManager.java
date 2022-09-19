package de.paulcornelissen.pong;

import basis.Bild;
import de.paulcornelissen.paulpaint.Crawler;

import static de.paulcornelissen.pong.Pong.pongPencilManager;

public class ScoreManager extends Bild {

    public ScoreManager() {
        this.setzePosition(280, 75);
        this.setzeHintergrundFarbe(Crawler.getColor("Hellgrau"));
        this.setzeGroesse(150, 60);
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

}
