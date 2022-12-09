package de.paulcornelissen.arrayExercise;

import java.util.Arrays;
import java.util.Random;

public class ArrayTestOne {

    public static void main(String[] args) {
        new ArrayTestOne();
    }

    String[] animals = new String[100];
    public ArrayTestOne() {
        this.addAnimalsToArray();
        System.out.println(Arrays.toString(animals));
    }

    public void addAnimalsToArray() {
        for (int i = 0; i < animals.length; i++) {
            int random = new Random().nextInt(5);
            switch (random) {
                case 0 -> animals[i] = "Hund";
                case 1 -> animals[i] = "Katze";
                case 2 -> animals[i] = "Maus";
                case 3 -> animals[i] = "Fisch";
                case 4 -> animals[i] = "Hase";
            }
        }
    }

}
