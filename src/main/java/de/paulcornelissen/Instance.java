package de.paulcornelissen;

import basis.Fenster;

public class Instance {

    //Variabeln
    public Fenster fenster;
    public Pencil pencil;

    public Instance(String name, int breite, int hoehe, boolean summonPencil) {

        fenster = new Fenster(name, breite, hoehe);

        if (summonPencil) {
            pencil = new Pencil();

        }

    }

    public void closeInstance(Instance instance) {
        instance.fenster.setzeSichtbar(false);

    }


}
