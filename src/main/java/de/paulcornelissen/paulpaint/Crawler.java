package de.paulcornelissen.paulpaint;

import basis.Farbe;

import java.awt.*;

public class Crawler {

    private static Color fetchedColor;

    public Crawler() {

    }

    public static Color getColor(String color) {

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
            fetchedColor = Color.GREEN;
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
        if (color.equals("Eigene")) {
            fetchedColor = getColor(255, 255, 255);
            return fetchedColor;
        }


        return fetchedColor;
    }

    public static Color getColor(int r, int g, int b) {

        fetchedColor = Farbe.rgb(r, g, b);
        return fetchedColor;
    }

    public static int getWidth(String width) {
        int fetchedWidth;
        if (width.equals("dünn")) {
            fetchedWidth = 2;
            return fetchedWidth;
        }
        if (width.equals("normal")) {
            fetchedWidth = 4;
            return fetchedWidth;
        }
        if (width.equals("dick")) {
            fetchedWidth = 6;
            return fetchedWidth;
        }
        return 4;
    }
}
