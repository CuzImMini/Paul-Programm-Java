package de.paulcornelissen.Test;

import basis.Fenster;
import basis.IgelStift;

import javax.swing.*;

public class Test {

    private final IgelStift pencil;

    public static void main(String[] args) {
        new Test();
    }
    public Test() {
        new Fenster(700, 300);
        pencil = new IgelStift();


        this.addGui();
    }

    public void addGui() {
        JFrame gui = new JFrame();
        gui.setSize(200, 100);

        JButton start = new JButton("Start");
        start.addActionListener(e -> {
            int anzahl = Integer.parseInt(getInputDialog("Wie oft platzieren?"));
            int abstand = Integer.parseInt(getInputDialog("Welcher Abstand?"));

            int breite = Integer.parseInt(getInputDialog("Welche breite?"));
            int hoehe = Integer.parseInt(getInputDialog("Welche höhe?"));

            for (int i = 0; i < anzahl; i++) {
                pencil.bewegeBis(100 + (i*abstand), 100);
                pencil.zeichneRechteck(breite,hoehe);

            }
        });
        gui.getContentPane().add(start);

        gui.setLocationRelativeTo(null);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);


    }

    public String getInputDialog(String question) {
        return JOptionPane.showInputDialog(null, question, "Auswahl", JOptionPane.QUESTION_MESSAGE);
    }

}
