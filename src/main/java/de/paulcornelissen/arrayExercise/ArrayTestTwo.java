package de.paulcornelissen.arrayExercise;

import javax.swing.*;
import java.util.Arrays;

public class ArrayTestTwo {
    public static void main(String[] args) {
        new ArrayTestTwo();
    }

    String[] animals;

    public ArrayTestTwo() {
        int arrayLength = Integer.parseInt(JOptionPane.showInputDialog("Bitte gib ein, wie viele Tiere du haben möchtest"));

        animals = new String[arrayLength];

        for (int i = 0; i < animals.length; i++) {
            animals[i] = JOptionPane.showInputDialog("Bitte gib ein, wie Tier Nummer " + (i + 1) + " heißen soll.");
        }

        JOptionPane.showMessageDialog(null, "Das Tier-Array: " + Arrays.toString(animals));
    }
}
