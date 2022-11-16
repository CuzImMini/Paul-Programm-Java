package de.paulcornelissen.Test;

import basis.Fenster;
import basis.IgelStift;
import basis.Knopf;
import basis.Stift;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        new Test();
    }

    //Variablen zur Steuerung des Programms können beliebig gewählt werden:

    //Fenstertitel
    String title = "Steuerung";
    //Nachricht in externem GUI
    String message = "Wähle eine Aktion!";
    //Text auf primärem Aktionsknopf
    String primaryButtonText = "Primäraktion";
    //Text auf sekundärem Aktionsknopf
    String secondaryButtonText = "Sekundäraktion";

    //klassen-weit genutzte Variablen

    //Stift zum vereinfachten Aufruf der Zeichenmethoden
    Stift pencil;

    public Test() {

        //Initialisierung Fenster
        new Fenster(620, 620);
        pencil = new Stift();

        //Erstellen der Steuerungs-UI
        JFrame controler = getControlFrame(title, message, primaryButtonText, secondaryButtonText);
        controler.setVisible(true);

        //Manuelle Knöpfe in Zeichenfläche
        Knopf manualButtonPrimary = new Knopf(primaryButtonText, 200, 500, 100, 50);
        manualButtonPrimary.setzeKnopfLauscher(knopf -> primaryAction());

        Knopf manualButtonSecondary = new Knopf(secondaryButtonText, 400, 500, 100, 50);
        manualButtonSecondary.setzeKnopfLauscher(knopf -> secondaryAction());

    }

    public JFrame getControlFrame(String title, String message, String primaryButtonText, String secondaryButtonText) {
        //Erstellen der externen GUI
        JFrame jFrame = new JFrame();
        //Setzen des Titels
        jFrame.setTitle(title);
        //Setzen der Nachricht
        JLabel messageLabel = new JLabel(message);
        jFrame.add(messageLabel);

        //Knöpfe setzen
        JButton primaryButton = new JButton(primaryButtonText);
        primaryButton.addActionListener(e -> primaryAction());
        jFrame.add(primaryButton);

        JButton secondaryButton = new JButton(secondaryButtonText);
        secondaryButton.addActionListener(e -> secondaryAction());
        jFrame.add(secondaryButton);

        //sonstige Einstellungen
        jFrame.setSize(400, 80);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());
        //Rückgabe
        return jFrame;
    }

    public void primaryAction() {
        //Ausführen der Primäraktion je nach Aufgabe
        pencil.kreis(getInputDigit("x-Cord"), getInputDigit("y-Cord"), getInputDigit("radius"));
    }

    public void secondaryAction() {
        //Ausführen der Sekundäraktion je nach Aufgabe
        pencil.rechteck(getInputDigit("x-Cord"), getInputDigit("y-Cord"), 150, 150);
    }

    public Integer getInputDigit(String message) {
        //Prüfen, ob eine Zahl eingegeben wurde mit try-catch
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(message));
        } catch (NumberFormatException e) {
            //Wenn String Fehler ausgibt, Dialog erneut aufrufen
            JOptionPane.showMessageDialog(null, "Gib eine Zahl ein!");
            return getInputDigit(message);
        }
    }


}
