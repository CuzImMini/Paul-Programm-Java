package de.paulcornelissen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class Gui {

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

    public void controlFrame(Instance instance, String name) {

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
        instanceControl.setSize(325, 200);

        //Setze String-Array
        String[] objekte = {"Baum", "Haus", "Buchstabe", "Stern"};

        //Erstellung Knöpfe
        JButton drawButton = new JButton("zeichnen");
        JButton deleteAll = new JButton("Alles löschen");
        JButton createPencil = new JButton("Stift erzeugen");
        JButton setBackground = new JButton("Hintergrundfarbe setzen");
        JComboBox comboBox = new JComboBox(objekte);
        JToggleButton toggleButton = new JToggleButton("Zeichenmodus ein");

        //Erstellung Zeichenknopf
        drawButton.addActionListener(e -> {

            if (instance.checkPencil()) {

                String malObjekt = comboBox.getSelectedItem().toString();

                //Dialog
                JTextField xCord = new JTextField(5);
                JTextField yCord = new JTextField(5);
                JTextField rotationCord = new JTextField(5);

                //Setze String-Array
                String[] color = {"Blau", "Cyan", "Grau", "Dunkelgrau", "Gelb", "Grün", "Hellgrau", "Magenta", "Orange", "Pink", "Rot", "Schwarz", "Weiß"};


                JPanel myPanel = new JPanel();
                JComboBox colorBox = new JComboBox(color);
                myPanel.add(new JLabel("Farbe:"));
                myPanel.add(colorBox);
                myPanel.add(Box.createHorizontalStrut(15)); //Abstand
                myPanel.add(new JLabel("x:"));
                myPanel.add(xCord);
                myPanel.add(Box.createHorizontalStrut(15)); //Abstand
                myPanel.add(new JLabel("y:"));
                myPanel.add(yCord);
                myPanel.add(Box.createHorizontalStrut(15)); //Abstand
                myPanel.add(new JLabel("rotation:"));
                myPanel.add(rotationCord);

                int result = JOptionPane.showConfirmDialog(null, myPanel, "Bitte Koordinaten, Rotation und Farbe wählen.", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {

                    if (rotationCord.getText().equals("")) {
                        rotationCord.setText("0");
                    }
                    instance.drawingCrawler(malObjekt, Integer.parseInt(xCord.getText()), Integer.parseInt(yCord.getText()), Integer.parseInt(rotationCord.getText()), colorBox.getSelectedItem().toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Kein Stift vorhanden! Erzeuge zuerst einen Stift.");
        });
        //Erstelle Stift-Summoner
        createPencil.addActionListener(e -> {
            if (instance.checkPencil()) {
                return;
            }
            instance.createPencil();
        });
        //Setze Hintergrundfarbe
        setBackground.addActionListener(e -> {

            //Dialog
            JTextField Farbe = new JTextField(5);

            //Setze String-Array
            String[] color = {"Eigene", "Blau", "Cyan", "Grau", "Dunkelgrau", "Gelb", "Grün", "Hellgrau", "Magenta", "Orange", "Pink", "Rot", "Schwarz", "Weiß"};

            //Setze Dialog
            JPanel myPanel = new JPanel();
            JComboBox colorBox = new JComboBox(color);
            myPanel.add(new JLabel("Farbe:"));
            myPanel.add(colorBox);

            int result = JOptionPane.showConfirmDialog(null, myPanel, "Bitte Farbe wählen.", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                if (colorBox.getSelectedItem().toString().equals("Eigene")) {

                    //Dialog
                    JTextField rValue = new JTextField(5);
                    JTextField gValue = new JTextField(5);
                    JTextField bValue = new JTextField(5);

                    JPanel myPanel2 = new JPanel();
                    myPanel2.add(new JLabel("Rot-Wert"));
                    myPanel2.add(rValue);
                    myPanel2.add(Box.createHorizontalStrut(15)); //Abstand
                    myPanel2.add(new JLabel("Grün-Wert"));
                    myPanel2.add(gValue);
                    myPanel2.add(Box.createHorizontalStrut(15)); //Abstand
                    myPanel2.add(new JLabel("Blau-Wert:"));
                    myPanel2.add(bValue);

                    int result2 = JOptionPane.showConfirmDialog(null, myPanel2, "Bitte Farbwerte eingeben", JOptionPane.OK_CANCEL_OPTION);
                    if (result2 == JOptionPane.OK_OPTION) {
                        instance.setBackgroundColor(Crawler.getColor(Integer.parseInt(rValue.getText()), Integer.parseInt(gValue.getText()), Integer.parseInt(bValue.getText())));
                    }
                    return;
                }

                instance.setBackgroundColor(Crawler.getColor(colorBox.getSelectedItem().toString()));
            }

        });
        //Erstelle Paint-Farbwahl
        String[] colors = {"Schwarz", "Blau", "Cyan", "Grau", "Dunkelgrau", "Gelb", "Grün", "Hellgrau", "Magenta", "Orange", "Pink", "Rot", "Weiß"};
        JComboBox colorSelector = new JComboBox<>(colors);
        colorSelector.addActionListener(e -> {
            instance.getPencil().setzeFarbe(Crawler.getColor(colorSelector.getSelectedItem().toString()));
        });
        //Erstelle Paint-Breite-Auswahl
        String[] breiten = {"dünn", "normal", "dick"};
        JComboBox breiteSelector = new JComboBox<>(breiten);
        breiteSelector.addActionListener(e -> {
            instance.getPencil().setzeLinienBreite(Crawler.getWidth(breiteSelector.getSelectedItem().toString()));
        });

        //Erstelle Paint-Toggle-Button
        toggleButton.addActionListener(e -> {

            if (instance.checkPencil()) {

                if (toggleButton.isSelected()) {
                    instance.addPaintingListener();
                    instanceControl.getContentPane().add(colorSelector);
                    instanceControl.setVisible(true);
                    instance.getPencil().setzeFarbe(Crawler.getColor("Schwarz"));
                } else {
                    instance.removePaintingListener();
                    instanceControl.getContentPane().remove(colorSelector);
                    instanceControl.setVisible(false);
                    instanceControl.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Kein Stift vorhanden! Erzeuge zuerst einen Stift.");
                toggleButton.setSelected(false);
            }
        });

        //Erstelle Zurücksetzen
        deleteAll.addActionListener(e -> {
            instance.reset();
            instance.getPencil().bewegeBis(0, 0);
            instance.setBackgroundColor(Crawler.getColor("Weiß"));
        });


        instanceControl.setLayout(new FlowLayout());

        instanceControl.getContentPane().add(breiteSelector);
        instanceControl.getContentPane().add(drawButton);
        instanceControl.getContentPane().add(comboBox);
        instanceControl.getContentPane().add(deleteAll);
        instanceControl.getContentPane().add(createPencil);
        instanceControl.getContentPane().add(setBackground);
        instanceControl.getContentPane().add(toggleButton);

        instanceControl.setLocationRelativeTo(null);
        instanceControl.setVisible(true);


    }


}

