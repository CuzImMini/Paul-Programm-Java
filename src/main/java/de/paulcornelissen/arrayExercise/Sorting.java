package de.paulcornelissen.arrayExercise;

import basis.Fenster;
import basis.Stift;

import java.util.Random;

public class Sorting {

    public static void main(String[] args) {
        new Sorting();
    }

    int[] numbers = new int[200];
int calculations;
    int speed = 50;
    private Fenster window;
    private Stift pencil;

    public Sorting() {
        initialize();

        //verschiedene Sortiermodi:
        //bubbleSort(numbers);
        //selectionSort(numbers);
        //simpleSort(numbers);

    }

    public void initialize() {
        window = new Fenster("Sorting", (int) (numbers.length * 7.5), 400);
        pencil = new Stift();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(1, 100);
        }

        this.drawArray(numbers);
    }

    public void bubbleSort(int[] array) {
        int compare;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    calculations++;
                    compare = array[i];
                    array[i] = array[j];
                    array[j] = compare;

                }
            }

            //Code für Visualisierung
            pause(speed);
            drawArray(numbers);

        }

    }


    public void selectionSort(int[] array) {
        //Arraylänge
        int n = array.length;

        // Schleife für alle Elemente
        for (int i = 0; i < n - 1; i++) {

            // Durchlauf für jedes Element im Array
            int activeElementIndex = i;

            for (int j = i + 1; j < n; j++) {
                // Setzt das temporärere Element auf das kleinste Element im ganzen Array, da jedes Element verglichen wird
                if (array[j] < array[activeElementIndex]) {
                    //Sollte Element kleiner sein, wird temporäreres Element gewechselt
                    calculations++;
                    activeElementIndex = j;
                }
            }
            // Tausche kleinstes Element mit dem analysierten Element
            int temp = array[activeElementIndex];
            array[activeElementIndex] = array[i];
            array[i] = temp;


            //Code für Visualisierung
            pause(speed);
            calculations++;
            drawArray(numbers);
        }
    }

    public void simpleSort(int[] array) {
       int compareNumber;

        for (int i = array.length - 1; i > 0 ; i--) {
            for (int j = 0; j <= i-1; j++) {
                if (array[j] >= array[i]) {
                    compareNumber = array[i];
                    array[i] = array[j];
                    array[j] = compareNumber;
                    calculations++;
                }
            }


        //Code für Visualisierung
        pause(speed);
        drawArray(numbers);
        }
    }


    public void drawArray(int[] numbers) {
        window.loescheAlles();
        for (int i = 0; i < numbers.length; i++) {
            pencil.bewegeBis(25 + i * 7, 375 - numbers[i] * 3);
            pencil.zeichneRechteck(5, numbers[i] * 3);
        }

        pencil.bewegeBis(50,50);
        pencil.schreibeText("Tauschoperationen: " + calculations);

    }

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }

}



