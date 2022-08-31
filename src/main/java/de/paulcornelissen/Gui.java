package de.paulcornelissen;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Gui extends JFrame {

    public Gui(String title) {
        this.mainframe(title);
    }

    private JComboBox<String> objectSelector;
    private JComboBox<String> widthSelector;
    private JToggleButton drawingToggle;

    private Instance instance;

    public void mainframe(String title) {

        //Setze String-Array
        String[] objekte = {"Baum", "Haus", "Buchstabe", "Stern"};
        String[] breiten = {"dünn", "normal", "dick"};
        String[] color = {"Eigene", "Blau", "Cyan", "Grau", "Dunkelgrau", "Gelb", "Grün", "Hellgrau", "Magenta", "Orange", "Pink", "Rot", "Schwarz", "Weiß"};


        JLabel titleLable = new JLabel();
        JButton startConstructor = new JButton();
        JButton fastStart = new JButton();
        JButton changeWindows = new JButton();
        JButton resetAll = new JButton();
        objectSelector = new JComboBox<>(objekte);
        widthSelector = new JComboBox<>(breiten);
        drawingToggle = new JToggleButton();
        JButton drawManually = new JButton();
        JButton summonPencil1 = new JButton();
        JButton testButton = new JButton();

        //---default-close-operation---
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //======== Title ========
        setTitle(title);
        setBackground(Color.white);
        var contentPane = getContentPane();

        //---- label1 ----
        titleLable.setText("Willkommen bei " + title + "!");
        titleLable.setForeground(Color.red);
        titleLable.setHorizontalAlignment(SwingConstants.LEFT);
        titleLable.setFont(titleLable.getFont().deriveFont(titleLable.getFont().getStyle() | Font.BOLD, titleLable.getFont().getSize() + 3f));
        titleLable.setBackground(new Color(51, 0, 51));

        //---- Erstelle Paint-Farbwahl ----
        JComboBox<String> colorSelector = new JComboBox<>(color);
        colorSelector.setSelectedItem(color[12]);
        colorSelector.addActionListener(e -> {
            if (instance == null) {
                return;
            }
            instance.getPencil().setzeFarbe(Crawler.getColor(Objects.requireNonNull(colorSelector.getSelectedItem()).toString()));
        });

        //---- Erstelle Breiten-Selektor ----
        widthSelector = new JComboBox<>(breiten);
        widthSelector.setSelectedItem(breiten[1]);
        widthSelector.addActionListener(ee -> {
            if (instance == null) {
                return;
            }
            instance.getPencil().setzeLinienBreite(Crawler.getWidth(Objects.requireNonNull(widthSelector.getSelectedItem()).toString()));
        });

        //---- startConstructor ----
        startConstructor.setText("Eigene Zeichenfl\u00e4che");
        startConstructor.addActionListener(e -> {
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

                if (instance == null) {
                    Thread t = new Thread(() -> instance = new Instance(name.getText(), Integer.parseInt(breite.getText()), Integer.parseInt(hoehe.getText()), summonPencil.isSelected()));
                    t.start();
                } else {
                    changeWindowDialog();
                }
            }
        });

        //---- fastStart ----
        fastStart.setText("Schnellstart");
        fastStart.addActionListener(e -> {

            if (instance == null) {
                Thread t = new Thread(() -> instance = new Instance("Zeichenfläche", 600, 600, true));
                t.start();
            } else {
                changeWindowDialog();
            }
        });

        //---- changeWindows ----
        changeWindows.setText("Fenster \u00e4ndern");
        changeWindows.addActionListener(e -> changeWindowDialog());

        //---- resetAll ----
        resetAll.setText("Fenster leeren");
        resetAll.addActionListener(e -> {
            if (instance == null) {
                return;
            }
            instance.reset();
            instance.getPencil().bewegeBis(0, 0);
            instance.setBackgroundColor(Crawler.getColor("Weiß"));
        });

        //---- drawingToggle ----
        drawingToggle.setText("Zeichenmodus ein");
        drawingToggle.addActionListener(e -> {
            if (instance == null) {
                return;
            }
            if (instance.checkPencil()) {

                if (drawingToggle.isSelected()) {

                    JPanel mypanel3 = new JPanel();
                    JCheckBox objectPlacement = new JCheckBox();
                    mypanel3.add(new JLabel("Objekte platzieren? Zum Zeichnen leer lassen."));
                    mypanel3.add(objectPlacement);
                    boolean placeObjects;

                    String[] options = {"Zeichnen", "Objekte platzieren"};
                    int result3 = JOptionPane.showOptionDialog(null, "Objekte platzieren oder zeichnen?", "Bitte wählen", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    placeObjects = result3 == 1;

                    instance.addPaintingListener(objectSelector, placeObjects);
                    instance.getPencil().setzeFarbe(Crawler.getColor(Objects.requireNonNull(colorSelector.getSelectedItem()).toString()));
                    instance.getPencil().setzeLinienBreite(Crawler.getWidth(Objects.requireNonNull(widthSelector.getSelectedItem()).toString()));
                } else {
                    instance.removePaintingListener();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Kein Stift vorhanden! Erzeuge zuerst einen Stift.");
                drawingToggle.setSelected(false);
            }
        });

        //---- drawManually ----
        drawManually.setText("zeichnen");
        drawManually.addActionListener(e -> {
            if (instance == null) {
                return;
            }
            if (instance.checkPencil()) {
                String malObjekt = Objects.requireNonNull(objectSelector.getSelectedItem()).toString();

                //Dialog
                JTextField xCord = new JTextField(5);
                JTextField yCord = new JTextField(5);
                JTextField rotationCord = new JTextField(5);


                JPanel myPanel = new JPanel();
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
                    instance.drawingCrawler(malObjekt, Integer.parseInt(xCord.getText()), Integer.parseInt(yCord.getText()), Integer.parseInt(rotationCord.getText()), Objects.requireNonNull(colorSelector.getSelectedItem()).toString());
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(null, "Kein Stift vorhanden! Erzeuge zuerst einen Stift.");
        });

        //---- summonPencil ----
        summonPencil1.setText("Stift erzeugen");
        summonPencil1.addActionListener(e -> {
            if (instance == null) {
                return;
            }
            if (instance.checkPencil()) {
                return;
            }
            instance.createPencil();
        });

        //---- setBackground ----
        testButton.setText("Hintergrund");
        testButton.addActionListener(e -> {
            if (instance == null) {
                return;
            }
            //Setze Dialog
            JPanel myPanel = new JPanel();
            JComboBox<String> colorBox = new JComboBox<>(color);
            myPanel.add(new JLabel("Farbe:"));
            myPanel.add(colorBox);

            int result = JOptionPane.showConfirmDialog(null, myPanel, "Bitte Farbe wählen.", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                if (Objects.requireNonNull(colorBox.getSelectedItem()).toString().equals("Eigene")) {

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


        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(startConstructor)
                                                                        .addComponent(changeWindows, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(resetAll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(fastStart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                                        .addComponent(objectSelector, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(colorSelector, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(widthSelector, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(titleLable, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(61, 61, 61))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(drawingToggle, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(drawManually, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(summonPencil1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(testButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(titleLable)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(startConstructor)
                                        .addComponent(fastStart))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(drawManually)
                                        .addComponent(summonPencil1)
                                        .addComponent(testButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(drawingToggle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(objectSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(widthSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(colorSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(changeWindows)
                                        .addComponent(resetAll))
                                .addGap(37, 37, 37))
        );
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);

    }


    public void changeWindowDialog() {
        if (instance == null) {
            return;
        }
        JTextField neueBreite = new JTextField(5);
        JTextField neueHoehe = new JTextField(5);

        JPanel mypanel4 = new JPanel();
        mypanel4.add(new JLabel("Neue höhe:"));
        mypanel4.add(neueHoehe);
        mypanel4.add(Box.createHorizontalStrut(15));
        mypanel4.add(new JLabel("Neue breite:"));
        mypanel4.add(neueBreite);
        mypanel4.add(Box.createHorizontalStrut(20));
        mypanel4.add(new JLabel("alte Höhe:  " + instance.getHoehe()));
        mypanel4.add(Box.createHorizontalStrut(10));
        mypanel4.add(new JLabel("alte Breite:  " + instance.getBreite()));

        int result4 = JOptionPane.showConfirmDialog(null, mypanel4, "Bitte neue Dimensionen wählen", JOptionPane.OK_CANCEL_OPTION);

        if (result4 == JOptionPane.OK_OPTION) {
            instance.setFenster(Integer.parseInt(neueHoehe.getText()), Integer.parseInt(neueBreite.getText()));
        }

    }
}
