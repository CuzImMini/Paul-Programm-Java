package de.paulcornelissen.arrayExercise;

import javax.swing.*;
import java.util.Arrays;

public class ArrayTestTwo {
    public static void main(String[] args) {
        new ArrayTestTwo();
    }

    //Textfeld um klassen-weit auf das Textfeld zugreifen zu können
    JTextField animalName;
    //Array-Größe
    int arrayLength = 1;
    //Array
    String[] animals = new String[arrayLength];
    //Array für verschiedene Optionen
    String[] options = {"Weiteres Tier", "Fertig"};

    public ArrayTestTwo() {
        System.out.println("Tier-Array-Programm gestartet");

        showInputDialog();
    }

    public void showInputDialog() {
        int result = JOptionPane.showOptionDialog(null, getDialogPanel(), "Array-Eingabe", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (result) {
            case JOptionPane.YES_OPTION -> {
                adjustArray();
                showInputDialog();
            }
            case JOptionPane.NO_OPTION -> showOutput();
        }
    }

    public JPanel getDialogPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Tiername eingeben:");
        animalName = new JTextField(10);
        panel.add(label);
        panel.add(animalName);

        return panel;
    }

    public void showOutput() {
        animals[arrayLength - 1] = animalName.getText();
        JOptionPane.showMessageDialog(null, "Das Tier-Array: " + Arrays.toString(animals));
    }

    public void adjustArray() {
        String[] temp = new String[arrayLength + 1];
        System.arraycopy(animals, 0, temp, 0, animals.length);
        temp[arrayLength - 1] = animalName.getText();
        animals = temp;
        arrayLength += 1;
        animalName.setText("");
    }

}




