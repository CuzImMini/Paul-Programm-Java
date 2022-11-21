package de.paulcornelissen.Test;

import basis.BeschriftungsFeld;
import basis.Fenster;
import basis.Hilfe;
import basis.Knopf;

import javax.swing.*;

public class Test {

    //Variablen
    private final BeschriftungsFeld welcomeMessage;
    private final BeschriftungsFeld diceNumber;
    private final BeschriftungsFeld lastNumber;
    private final BeschriftungsFeld scoreIndicator;
    int lastRoll;
    int activeRoll;
    int rollNumber = 0;
    int[] rolls = new int[100];
    int scoreOne = 0;
    int scoreTwo = 0;
    int whichPlayer = 1;
    StringBuilder stringBuilder;

    //Konstruktor
    public Test() {

        //Sonstige Komponenten
        stringBuilder = new StringBuilder();

        //Initialisierung Fenster
        new Fenster("Würfelspiel", 600, 600);

        //Initialisierung Komponenten
        welcomeMessage = new BeschriftungsFeld("Pauls-Würfelspiel. Spieler " + whichPlayer + ", beginne zu würfeln!", 100, 80, 400, 25);

        new BeschriftungsFeld("Gewürfelte Zahl:", 100, 200, 100, 25);
        diceNumber = new BeschriftungsFeld("0", 250, 200, 25, 25);

        new BeschriftungsFeld("Letzte Zahl:", 100, 300, 100, 25);
        lastNumber = new BeschriftungsFeld("keine Würfe!", 250, 300, 250, 25);

        scoreIndicator = new BeschriftungsFeld("Spieler 1: 0 Punkte / Spieler 2: 0 Punkte", 100, 120, 400, 25);

        //Init Knöpfe
        Knopf rollDiceButton = new Knopf("Würfeln!", 100, 400, 200, 50);
        Knopf resetKnopf = new Knopf("Neues Spiel", 400, 400, 100, 50);

        rollDiceButton.setzeKnopfLauscher(knopf -> rollDice());
        resetKnopf.setzeKnopfLauscher(knopf -> fullReset());

    }

    //Main zum Starten der Klasse
    public static void main(String[] args) {
        System.out.println("Programm gestartet!");
        new Test();
    }

    //Generator für Zufallszahl
    public static Integer generateRollNumber() {
        return Hilfe.zufall(1, 6);
    }

    //Methode, die Ansicht aktualisiert
    public void refresh() {
        diceNumber.setzeText(String.valueOf(activeRoll));
        scoreIndicator.setzeText("Spieler 1:  " + scoreOne + "  Punkte / Spieler 2:  " + scoreTwo + "  Punkte");
        welcomeMessage.setzeText("Pauls-Würfelspiel. Spieler " + whichPlayer + ", beginne zu würfeln!");

    }

    //Methode zum Würfeln
    public void rollDice() {
        //Zuweisung zufällige Nummer
        activeRoll = generateRollNumber();

        //Setzen des letzten Wurfes Feld
        if (rollNumber != 0) {
            stringBuilder.append(" ").append(rolls[rollNumber]).append(" - ");
        }
        lastNumber.setzeText(stringBuilder.toString());

        //Erhöhen der Variable für Wurfanzahl
        rollNumber += 1;
        //Prüfe Verlust
        checkLoose();
        //Aktualisieren des GUI
        refresh();
        rolls[rollNumber] = activeRoll;

    }

    public void checkLoose() {

        for (int i = 1; i < rollNumber + 1; i++) {
            if (activeRoll == rolls[i]) {
                switch (whichPlayer) {
                    case 1 -> whichPlayer = 2;
                    case 2 -> whichPlayer = 1;
                }
                JOptionPane.showMessageDialog(null, "Dein Zug ist zu ende!");
                lastRoll = 0;
                activeRoll = 0;
                refresh();
                clearArray();
                return;
            }
        }

        //Änderung des Punktestandes
        switch (whichPlayer) {
            case 1 -> scoreOne += 1;
            case 2 -> scoreTwo += 1;
        }
    }

    public void fullReset() {
        scoreIndicator.setzeText("Spieler 1: 0 Punkte / Spieler 2: 0 Punkte");
        lastRoll = 0;
        activeRoll = 0;
        clearArray();
        lastNumber.setzeText(stringBuilder.toString());
        scoreOne = 0;
        scoreTwo = 0;
    }

    public void clearArray() {

        rolls = new int[99];
        rollNumber = 0;
        stringBuilder = new StringBuilder();
    }


}