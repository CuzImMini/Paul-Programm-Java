package de.paulcornelissen.pong;

import basis.Fenster;
import basis.MausLauscherStandard;
import de.paulcornelissen.paulpaint.Pencil;

public class InstanceManager {

    private final Fenster fenster;
    public String name;
    public MausLauscherStandard paintListener;
    private Pencil pencil;
    private int breite;
    private int hoehe;

    public InstanceManager(String n, int b, int h, boolean summonPencil) {

        breite = b;
        hoehe = h;
        name = n;
        fenster = new Fenster(name, breite, hoehe);

        if (summonPencil) {
            pencil = new Pencil();
        }
    }

    public void closeInstance() {
        this.fenster.setzeSichtbar(false);
    }

    public void setBackgroundPhoto(String path) {
        fenster.ladeBildInZeichenflaeche(path);
    }


}
