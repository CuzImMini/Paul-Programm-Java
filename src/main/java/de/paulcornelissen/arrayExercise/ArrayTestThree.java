package de.paulcornelissen.arrayExercise;

import basis.*;

import javax.swing.*;
import java.util.Arrays;

public class ArrayTestThree {

    public static void main(String[] args) {
        new ArrayTestThree();
    }

    ZahlenFeld arraySize;
    Knopf arrayAddButton;
    String[] animals;
    TextFeld animalName;
    BeschriftungsFeld animalNamesLabel;
    public ArrayTestThree() {

        new Fenster("ArrayTestThree", 250, 400);
        arraySize = new ZahlenFeld(10, 10, 100, 50);
        new BeschriftungsFeld("Wie viele Tiere?", 120, 100, 100, 10);
        arrayAddButton = new Knopf("Tiere hinzufügen", 10, 120, 150, 100);
        animalNamesLabel = new BeschriftungsFeld("Ausgabe: ", 10, 325, 400, 20);

        animalName = new TextFeld(10, 250, 100, 50);

        arrayAddButton.setzeKnopfLauscher(knopf -> addAnimalsToArray());
    }

    public void addAnimalsToArray() {

        int arrayLength = arraySize.ganzZahl();
        animals = new String[arrayLength];

        for (int i = 0; i < animals.length; i++) {

            animalName.setzeFokus();
            while (!animalName.fokusVerloren()) {
                Hilfe.warte(100);
            }
            animals[i] = animalName.text();
            animalName.setzeText("");
        }

        animalNamesLabel.setzeText(Arrays.toString(animals));
        System.out.println("Das Tier-Array: " + java.util.Arrays.toString(animals));
    }
}
