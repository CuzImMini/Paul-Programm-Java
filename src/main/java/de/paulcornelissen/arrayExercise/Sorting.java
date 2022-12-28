package de.paulcornelissen.arrayExercise;

import basis.Fenster;
import basis.Knopf;
import basis.Komponente;
import basis.Stift;

import java.util.Random;

public class Sorting {

    public static void main(String[] args) {
        new Sorting();
    }

    //Einstellungen
    SortAlgorithm sortAlgorithm = SortAlgorithm.SIMPLE_SORT;
    int arraySize = 200;
    int speed = 50;

    //Ende - Einstellungen

    int[] numbers = new int[arraySize];
    int calculations;
    private Fenster window;
    private Stift pencil;

    public Sorting() {
        initialize();

        //verschiedene Sortiermodi:
        switch (sortAlgorithm) {
            case BUBBLE_SORT -> bubbleSort(numbers);
            case SELECTION_SORT -> selectionSort(numbers);
            case SIMPLE_SORT -> simpleSort(numbers);
        }

    }

    public void initialize() {
        window = new Fenster("Sorting", (int) (numbers.length * 7.5), 400);
        pencil = new Stift();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Random().nextInt(1, 100);
        }

        this.drawArray(numbers);
    }

    //BubbleSort - sortiert das Array von links nach rechts
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

    //SelectionSort - sortiert das Array von links nach rechts und tauscht zwei verglichene Elemente, sodass das größere Elemente gleichzeitig nach rechts wandern
    public void selectionSort(int[] array) {
        //Array länge
        int n = array.length;

        // Schleife für alle Elemente
        for (int i = 0; i < n - 1; i++) {

            // Durchlauf für jedes Element im Array
            int activeElementIndex = i;

            for (int j = i + 1; j < n; j++) {
                // Setzt das temporäre Element auf das kleinste Element im ganzen Array, da jedes Element verglichen wird
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

    //SimpleSort - sortiert das Array in zwei Schleifen von rechts und von links
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


    //Methode zur Visualisierung des Arrays
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



