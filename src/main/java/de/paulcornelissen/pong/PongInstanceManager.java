package de.paulcornelissen.pong;

import basis.Fenster;
import basis.MausLauscherStandard;
import de.paulcornelissen.paulpaint.Pencil;

public class PongInstanceManager {

    private final Fenster fenster;
    public String name;
    public MausLauscherStandard paintListener;

    public PongInstanceManager(String n, int b, int h, boolean summonPencil) {

        name = n;
        fenster = new Fenster(name, b, h);

        if (summonPencil) {
            Pencil pencil = new Pencil();
        }
    }

    public void closeInstance() {
        this.fenster.setzeSichtbar(false);
    }

    public void setBackgroundPhoto(String path) {
        fenster.ladeBildInZeichenflaeche(path);
    }


}
