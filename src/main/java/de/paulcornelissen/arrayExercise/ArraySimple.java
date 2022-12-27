package de.paulcornelissen.arrayExercise;

import javax.swing.*;
import java.util.Arrays;

public class ArraySimple {

    public static void main(String[] args) {
        new ArraySimple();
    }

    public ArraySimple() {
        String[] animals = new String[8];
        animals[0] = "Hund";
        animals[1] = "Katze";
        animals[2] = "Maus";
        animals[3] = "Fisch";
        animals[4] = "Hase";
        animals[5] = "Pferd";
        animals[6] = "Schaf";
        animals[7] = "Kuh";

        JOptionPane.showInputDialog(null, "Welcher Name?");

        System.out.println(Arrays.toString(animals));

    }

}
