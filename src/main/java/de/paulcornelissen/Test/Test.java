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

            /*
            JPanel panel = new JPanel();
            JTextField text = new JTextField(5);
            JLabel text11 = new JLabel("Wie oft platzieren?");
            panel.add(text11);
            panel.add(text);
            JLabel text22 = new JLabel("Abstand?");
            JTextField text2 = new JTextField(5);
            panel.add(text22);
            panel.add(text2);
            JTextField text3 = new JTextField(5);
            JLabel text33 = new JLabel("Größe?");
            panel.add(text33);
            panel.add(text3);



            int x = JOptionPane.showConfirmDialog(null, panel, "Test", JOptionPane.OK_CANCEL_OPTION);

            if (x == JOptionPane.OK_OPTION) {
                for (int i = 0; i < Integer.parseInt(text.getText()); i++) {
                    pencil.bewegeBis(100 + (i*Integer.parseInt(text2.getText())), 100);
                    pencil.zeichneRechteck(Integer.parseInt(text3.getText()),Integer.parseInt(text3.getText()));

                }
            }
            */

            for (int i = 0; i < anzahl; i++) {
                pencil.bewegeBis(100 + (i * abstand), 100);
                pencil.zeichneRechteck(breite, hoehe);

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
