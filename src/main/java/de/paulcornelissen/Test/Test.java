package de.paulcornelissen.Test;

import basis.Fenster;
import basis.IgelStift;

import javax.swing.*;

public class Test {

    private Fenster window;
    private IgelStift pencil;
    private JFrame gui;

    public static void main(String[] args) {
        new Test();
    }
    public Test() {
        window = new Fenster(700, 300);
        pencil = new IgelStift();

        this.addGui();
    }

    public void addGui() {
        gui = new JFrame();
        gui.setSize(200, 100);

        JButton start = new JButton("Start");
        start.addActionListener(e -> {
            pencil.bewegeBis(200,200);
            pencil.zeichneRechteck(getInputDialog("Welche breite?"),getInputDialog("Welche höhe?"));
        });
        gui.getContentPane().add(start);

        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }

    public int getInputDialog(String question) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, question, "Auswahl", JOptionPane.QUESTION_MESSAGE));
    }


}
