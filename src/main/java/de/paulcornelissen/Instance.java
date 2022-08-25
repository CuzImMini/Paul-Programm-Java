package de.paulcornelissen;

import basis.Fenster;
import basis.MausLauscherStandard;

public class Instance {

    //Variabeln
    public Fenster fenster;
    public Pencil pencil;

    public MausLauscherStandard paintListener;

    public Instance(String name, int breite, int hoehe, boolean summonPencil) {

        fenster = new Fenster(name, breite, hoehe);

        if (summonPencil) {
            pencil = new Pencil();

        }

    }

    public void closeInstance(Instance instance) {
        instance.fenster.setzeSichtbar(false);

    }

    public void createPencil() {
        pencil = new Pencil();
    }

    public boolean checkPencil() {
        if (pencil == null) {
            return false;
        }
        ;
        return true;
    }

    public void addPaintingListener() {
        MausLauscherStandard paintListener = new MausLauscherStandard() {
            @Override
            public void bearbeiteMausDruck(Object o, int i, int i1) {
                pencil.bewegeBis(i,i1);
                pencil.runter();
            }

            @Override
            public void bearbeiteMausDruckRechts(Object o, int i, int i1) {
            }

            @Override
            public void bearbeiteMausLos(Object o, int i, int i1) {
pencil.hoch();
            }

            @Override
            public void bearbeiteMausLosRechts(Object o, int i, int i1) {
                pencil.normal();
            }

            @Override
            public void bearbeiteMausBewegt(Object o, int i, int i1) {

            }

            @Override
            public void bearbeiteMausGezogen(Object o, int i, int i1) {
                pencil.bewegeBis(i,i1);
            }
        };
        this.fenster.setzeMausLauscherStandard(paintListener);
    }

    public void removePaintingListener() {
        this.fenster.entferneMausLauscherStandard(paintListener);
    }


}
