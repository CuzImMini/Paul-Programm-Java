package de.paulcornelissen;

import basis.Farbe;

import java.awt.*;

public class ColorCrawler {

    private static Color fetchedColor;

    public ColorCrawler() {

    }

    public static Color getColor(String color) {

        System.out.println("ColorCrawler" + color);
        if (color.equals("Blau")) {
            fetchedColor = Farbe.BLAU;
            return fetchedColor;
        }
        if (color.equals("Cyan")) {
            fetchedColor = Farbe.CYAN;
            return fetchedColor;
        }
        if (color.equals("Grau")) {
            fetchedColor = Farbe.GRAU;
            return fetchedColor;
        }
        if (color.equals("Dunkelgrau")) {
            fetchedColor = Farbe.DUNKELGRAU;
            return fetchedColor;
        }
        if (color.equals("Gelb")) {
            fetchedColor = Farbe.GELB;
            return fetchedColor;
        }
        if (color.equals("Grün")) {
            fetchedColor = Farbe.GRÜN;
            return fetchedColor;
        }
        if (color.equals("Hellgrau")) {
            fetchedColor = Farbe.HELLGRAU;
            return fetchedColor;
        }
        if (color.equals("Magenta")) {
            fetchedColor = Farbe.MAGENTA;
            return fetchedColor;
        }
        if (color.equals("Orange")) {
            fetchedColor = Farbe.ORANGE;
            return fetchedColor;
        }
        if (color.equals("Pink")) {
            fetchedColor = Farbe.PINK;
            return fetchedColor;
        }
        if (color.equals("Rot")) {
            fetchedColor = Farbe.ROT;
            return fetchedColor;
        }
        if (color.equals("Schwarz")) {
            fetchedColor = Farbe.SCHWARZ;
            return fetchedColor;
        }
        if (color.equals("Weiß")) {
            fetchedColor = Farbe.WEISS;
            return fetchedColor;
        }


        return fetchedColor;
    }

    public static Color getColor(int r, int g, int b) {

        fetchedColor = Farbe.rgb(r,g,b);
        return fetchedColor;
    }

}
