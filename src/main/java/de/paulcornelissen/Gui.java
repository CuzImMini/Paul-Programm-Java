package de.paulcornelissen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class Gui {

    static Instance fenster1;

    public Gui() {
        this.mainframe();
    }

    public void mainframe() {

        //Erstellung Mainframe
        JFrame frame = new JFrame("Mein UI");

        //Beende Prozess, wenn Fenster geschlossen wird
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setze Fensterattribute
        frame.setSize(300, 75);

        //Erstellung Knöpfe
        JButton startButton = new JButton("Start-Konstruktor");

        //Erstellung StartKnopf
        startButton.addActionListener(e -> {

            //Fenster-Dialog
            JTextField breite = new JTextField(5);
            JTextField hoehe = new JTextField(5);
            JTextField name = new JTextField(5);
            JCheckBox summonPencil = new JCheckBox();

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Breite: "));
            myPanel.add(breite);
            myPanel.add(Box.createHorizontalStrut(15)); //Abstand
            myPanel.add(new JLabel("Hoehe: "));
            myPanel.add(hoehe);
            myPanel.add(Box.createHorizontalStrut(15)); //Abstand
            myPanel.add(new JLabel("Name: "));
            myPanel.add(name);
            myPanel.add(Box.createHorizontalStrut(15));//Abstand
            myPanel.add(new JLabel("Stift erzeugen?"));
            myPanel.add(summonPencil);

            int result = JOptionPane.showConfirmDialog(null, myPanel, "Bitte Größe und Name wählen.", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {


                Thread t = new Thread(() -> {
                    //fenster1 = new Instance(name.getText(), Integer.parseInt(breite.getText()), Integer.parseInt(hoehe.getText()), summonPencil.isSelected());
                    controlFrame(new Instance(name.getText(), Integer.parseInt(breite.getText()), Integer.parseInt(hoehe.getText()), summonPencil.isSelected()), name.getText());
                });
                t.start();
            }
        });


        //Initialisierung Frame
        frame.getContentPane().add(startButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void controlFrame(Instance instance, String name) {

        JFrame instanceControl = new JFrame("Zeichen-Controller " + name);

        //Beende Prozess, wenn Fenster geschlossen wird
        instanceControl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        instanceControl.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            instanceControl.dispose();
            instance.closeInstance(instance);
            }
        });

        //Setze Fensterattribute
        instanceControl.setSize(300, 125);

        //Setze String-Array
        String[] objekte = {"Baum", "Haus", "Buchstabe"};

        //Erstellung Knöpfe
        JButton drawButton = new JButton("zeichnen");
        JButton deleteAll = new JButton("Alles löschen");
        JComboBox comboBox = new JComboBox(objekte);

        //Erstellung Zeichenknopf
        drawButton.addActionListener(e -> {
            String malObjekt = comboBox.getSelectedItem().toString();

            //Koordinaten-Dialog
            JTextField xCord = new JTextField(5);
            JTextField yCord = new JTextField(5);
            JTextField rotationCord = new JTextField(5);

            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("x:"));
            myPanel.add(xCord);
            myPanel.add(Box.createHorizontalStrut(15)); //Abstand
            myPanel.add(new JLabel("y:"));
            myPanel.add(yCord);
            myPanel.add(Box.createHorizontalStrut(15)); //Abstand
            myPanel.add(new JLabel("rotation:"));
            myPanel.add(rotationCord);

            int result = JOptionPane.showConfirmDialog(null, myPanel, "Bitte Koordinaten und Rotation wählen.", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {

                instance.pencil.drawingCrawler(malObjekt, Integer.parseInt(xCord.getText()), Integer.parseInt(yCord.getText()), Integer.parseInt(rotationCord.getText()));
            }

        });

        //Erstelle Zurücksetzen
        deleteAll.addActionListener(e -> {
            instance.fenster.loescheAlles();
            instance.pencil.bewegeBis(0, 0);
        });

        instanceControl.setLayout(new FlowLayout());

        instanceControl.getContentPane().add(drawButton);
        instanceControl.getContentPane().add(comboBox);
        instanceControl.getContentPane().add(deleteAll);

        instanceControl.setLocationRelativeTo(null);
        instanceControl.setVisible(true);


    }

}

