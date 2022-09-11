package de.paulcornelissen.paulpaint;

import basis.Fenster;
import basis.MausLauscherStandard;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Instance {

    //Variabeln
    private final Fenster fenster;
    public String name;
    public MausLauscherStandard paintListener;
    private Pencil pencil;
    private int breite;
    private int hoehe;

    public Instance(String n, int b, int h, boolean summonPencil) {

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

    public void createPencil() {
        pencil = new Pencil();
    }

    public boolean checkPencil() {
        return pencil != null;
    }

    public void addPaintingListener(JComboBox<String> comboBox, Boolean objectPlacement) {
        paintListener = new MausLauscherStandard() {
            @Override
            public void bearbeiteMausDruck(Object o, int i, int i1) {

                if (objectPlacement) {
                    drawingCrawler(Objects.requireNonNull(comboBox.getSelectedItem()).toString(), i, i1, 0, getColour());
                    return;
                } else {
                    pencil.bewegeBis(i, i1);
                    pencil.runter();
                }
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
            }

            @Override
            public void bearbeiteMausBewegt(Object o, int i, int i1) {

            }

            @Override
            public void bearbeiteMausGezogen(Object o, int i, int i1) {
                pencil.bewegeBis(i, i1);
            }
        };
        this.fenster.setzeMausLauscherStandard(paintListener);
    }

    public void removePaintingListener() {
        fenster.entferneMausLauscherStandard(paintListener);
    }

    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return breite;
    }

    public String getName() {
        return name;
    }

    public void setBackgroundColor(Color color) {
        this.fenster.setzeHintergrundFarbe(color);
    }

    public void reset() {
        this.fenster.loescheAlles();
    }

    public void drawingCrawler(String object, int x, int y, int rotation, String color, Object objectDrawOn) {

        this.pencil.setObject(objectDrawOn);
        this.pencil.setColor(Crawler.getColor(color));
        this.drawingCrawler(object, x, y, rotation);

    }

    public void drawingCrawler(String object, int x, int y, int rotation, Color color, Object objectDrawOn) {

        this.pencil.setObject(objectDrawOn);
        this.pencil.setColor(color);
        this.drawingCrawler(object, x, y, rotation);

    }


    public Pencil getPencil() {
        return pencil;
    }

    public Color getColour() {
        return pencil.farbe();
    }

    public void setFenster(int h, int b) {
        breite = b;
        hoehe = h;
        fenster.setzeGroesse(breite, hoehe);
    }

    public void setBackgroundPhoto(String path) {
        fenster.ladeBildInZeichenflaeche(path);
    }

    public void drawingCrawler(String object, int x, int y, int rotation, Object objectDrawOn, Color color) {

        this.pencil.setColor(color);
        this.pencil.setObject(objectDrawOn);
        this.drawingCrawler(object, x, y, rotation);

    }

    public void drawingCrawler(String object, int x, int y, int rotation, String color) {

        this.pencil.setColor(Crawler.getColor(color));
        this.drawingCrawler(object, x, y, rotation);

    }

    public void drawingCrawler(String object, int x, int y, int rotation, Color color) {

        this.pencil.setColor(color);
        this.drawingCrawler(object, x, y, rotation);

    }

    public void drawingCrawler(String object, int x, int y, int rotation) {
        this.pencil.setPosition(rotation);
        this.drawingCrawler(object, x, y);


    }

    public void drawingCrawler(String object, int x, int y) {
        this.pencil.setPosition(x, y);
        this.drawingCrawler(object);


    }

    public void drawingCrawler(String object) {

        if (object.equals("Baum")) {
            this.pencil.zeichneBaum();
            return;
        }

        if (object.equals("Buchstabe")) {
            this.pencil.zeichneBuchstabe();
            return;
        }

        if (object.equals("Stern")) {
            this.pencil.zeichneStern();
            return;
        }

        if (object.equals("Haus")) {
            this.pencil.zeichneHaus();
        }
        if (object.equals("Hampelmann-unten")) {
            this.pencil.zeichneHampelmannUnten();
        }
        if (object.equals("Hampelmann-mitte")) {
            this.pencil.zeichneHampelmannMitte();
        }
        if (object.equals("Hampelmann-oben")) {
            this.pencil.zeichneHampelmannOben();
        }

    }


}
