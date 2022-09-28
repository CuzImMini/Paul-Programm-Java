package de.paulcornelissen.tictactoe;

import basis.*;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TicTacToe extends Fenster {

    TicTacToePencilManager pencilManager;
    Feld[] feld = new Feld[9];

    Random random = new Random();
    int player = random.nextInt(2);

    JFrame jFrame = this.getMeinJFrame();

    public TicTacToe() {
        jFrame.setVisible(false);
        this.setzeGroesse(620, 620);
        this.setzeTitel("Paul-TicTacToe");
        this.setzeTastenLauscher(this.getKeyboardListener());
        this.setzeMausLauscherStandard(this.getMouseListener());

        pencilManager = new TicTacToePencilManager();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.initialize();
    }

    public void initialize() {

        //Raster-Bilder machen
        feld[0] = new Feld(20, 20, 180, 180);
        feld[1] = new Feld(220, 20, 180, 180);
        feld[2] = new Feld(420, 20, 180, 180);
        feld[3] = new Feld(20, 220, 180, 180);
        feld[4] = new Feld(220, 220, 180, 180);
        feld[5] = new Feld(420, 220, 180, 180);
        feld[6] = new Feld(20, 420, 180, 180);
        feld[7] = new Feld(220, 420, 180, 180);
        feld[8] = new Feld(420, 420, 180, 180);

        pencilManager.setObject(this).zeichneRaster();
    }

    public MausLauscherStandard getMouseListener() {
        return new MausLauscherStandard() {
            @Override
            public void bearbeiteMausDruck(Object o, int i, int i1) {
                setPlayer(i, i1);
            }

            @Override
            public void bearbeiteMausDruckRechts(Object o, int i, int i1) {

            }

            @Override
            public void bearbeiteMausLos(Object o, int i, int i1) {

            }

            @Override
            public void bearbeiteMausLosRechts(Object o, int i, int i1) {

            }

            @Override
            public void bearbeiteMausBewegt(Object o, int i, int i1) {

            }

            @Override
            public void bearbeiteMausGezogen(Object o, int i, int i1) {

            }
        };
    }

    public TastenLauscher getKeyboardListener() {
        return (komponente, c) -> {
            if (c == 'r') {
                jFrame.setVisible(false);
                Thread t = new Thread(TicTacToe::new);
                t.start();
            }
        };
    }


    public void setPlayer(int x, int y) {
        if (!(crawlClick(x, y).belegt == 90)) {
            return;
        }

        if (player == 0) {
            pencilManager.setObject(crawlClick(x, y)).zeichneO();
            player++;
            crawlClick(x, y).belegt = 1;
            this.checkWin();
            return;
        }
        if (player == 1) {
            pencilManager.setObject(crawlClick(x, y)).zeichneX();
            player--;
            crawlClick(x, y).belegt = 2;
            this.checkWin();
        }
    }

    public Feld crawlClick(int x, int y) {

        if (x > 10 && x < 210 && y > 10 && y < 210) {
            return feld[0];
        }
        if (x > 210 && x < 410 && y > 10 && y < 210) {
            return feld[1];
        }
        if (x > 410 && x < 610 && y > 10 && y < 210) {
            return feld[2];
        }
        if (x > 10 && x < 210 && y > 210 && y < 410) {
            return feld[3];
        }
        if (x > 210 && x < 410 && y > 210 && y < 410) {
            return feld[4];
        }
        if (x > 410 && x < 610 && y > 210 && y < 410) {
            return feld[5];
        }
        if (x > 10 && x < 210 && y > 410 && y < 610) {
            return feld[6];
        }
        if (x > 210 && x < 410 && y > 410 && y < 610) {
            return feld[7];
        }
        if (x > 410 && x < 610 && y > 410 && y < 610) {
            return feld[8];
        }

        return null;

    }

    public void checkWin() {
        //HORIZONTALE REIHEN
        //obere Reihe
        if ((feld[0].belegt == 1 && feld[1].belegt == 1 && feld[2].belegt == 1)) {
            pencilManager.setObject(this).zeichneWinHorizont(feld[0], feld[2]);
            winTimer(feld[0]);


        } else if ((feld[0].belegt == 2 && feld[1].belegt == 2 && feld[2].belegt == 2)) {
            pencilManager.setObject(this).zeichneWinHorizont(feld[0], feld[2]);
            winTimer(feld[0]);
        }
        //mittlere Reihe
        else if ((feld[3].belegt == 1 && feld[4].belegt == 1 && feld[5].belegt == 1)) {
            pencilManager.setObject(this).zeichneWinHorizont(feld[3], feld[5]);
            winTimer(feld[3]);

        } else if ((feld[3].belegt == 2 && feld[4].belegt == 2 && feld[5].belegt == 2)) {
            pencilManager.setObject(this).zeichneWinHorizont(feld[3], feld[5]);
            winTimer(feld[3]);

        }
        //untere Reihe
        else if ((feld[6].belegt == 1 && feld[7].belegt == 1 && feld[8].belegt == 1)) {
            pencilManager.setObject(this).zeichneWinHorizont(feld[6], feld[8]);
            winTimer(feld[6]);


        } else if ((feld[6].belegt == 2 && feld[7].belegt == 2 && feld[8].belegt == 2)) {
            pencilManager.setObject(this).zeichneWinHorizont(feld[6], feld[8]);
            winTimer(feld[6]);

        }
        //VERTIKALE REIHEN
        //linke Reihe
        else if ((feld[0].belegt == 1 && feld[3].belegt == 1 && feld[6].belegt == 1)) {
            pencilManager.setObject(this).zeichneWinVertikal(feld[0], feld[6]);
            winTimer(feld[0]);


        } else if ((feld[0].belegt == 2 && feld[3].belegt == 2 && feld[6].belegt == 2)) {
            pencilManager.setObject(this).zeichneWinVertikal(feld[0], feld[6]);
            winTimer(feld[0]);


        }
        //mittlere Reihe
        else if ((feld[1].belegt == 1 && feld[4].belegt == 1 && feld[7].belegt == 1)) {
            pencilManager.setObject(this).zeichneWinVertikal(feld[1], feld[7]);
            winTimer(feld[1]);


        } else if ((feld[1].belegt == 2 && feld[4].belegt == 2 && feld[7].belegt == 2)) {
            pencilManager.setObject(this).zeichneWinVertikal(feld[1], feld[7]);
            winTimer(feld[1]);


        }
        //rechte Reihe
        else if ((feld[2].belegt == 1 && feld[5].belegt == 1 && feld[8].belegt == 1)) {
            pencilManager.setObject(this).zeichneWinVertikal(feld[1], feld[7]);
            winTimer(feld[2]);


        } else if ((feld[2].belegt == 2 && feld[5].belegt == 2 && feld[8].belegt == 2)) {
            pencilManager.setObject(this).zeichneWinVertikal(feld[1], feld[7]);
            winTimer(feld[2]);


        }
        //QUERE-Reihen
        //oben-links bis unten-rechts Reihe
        else if ((feld[0].belegt == 1 && feld[4].belegt == 1 && feld[8].belegt == 1)) {
            pencilManager.setObject(this).zeichneWinQuerL(feld[0], feld[8]);
            winTimer(feld[0]);

        } else if ((feld[0].belegt == 2 && feld[4].belegt == 2 && feld[8].belegt == 2)) {
            pencilManager.setObject(this).zeichneWinQuerL(feld[0], feld[8]);
            winTimer(feld[0]);

        }
        //oben-rechts bis unten-links
        else if ((feld[2].belegt == 1 && feld[4].belegt == 1 && feld[6].belegt == 1)) {
            pencilManager.setObject(this).zeichneWinQuerR(feld[2], feld[6]);
            winTimer(feld[2]);

        } else if ((feld[2].belegt == 2 && feld[4].belegt == 2 && feld[6].belegt == 2)) {
            pencilManager.setObject(this).zeichneWinQuerR(feld[2], feld[6]);
            winTimer(feld[2]);

        } else if (feld[0].belegt + feld[1].belegt + feld[2].belegt + feld[3].belegt + feld[4].belegt + feld[5].belegt + feld[6].belegt + feld[7].belegt + feld[8].belegt < 20) {
            this.loescheAlles();
            for (int i = 0; i < 9; i++) {
                feld[i].loescheAlles();
            }
            this.setzeHintergrundFarbe(Farbe.WEISS);
            pencilManager.setObject(feld[4]).zeichneUnentschieden();
            pencilManager.setObject(feld[7]).rForReset();
        }

    }

    private void winTimer(Feld x) {

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.schedule(() -> win(x.belegt), 1500, TimeUnit.MILLISECONDS);

    }

    public void win(int player) {

        this.loescheAlles();
        for (int i = 0; i < 9; i++) {
            feld[i].loescheAlles();
        }
        this.setzeHintergrundFarbe(Farbe.WEISS);
        pencilManager.setObject(feld[4]).zeichneWinPlayer(player);
        pencilManager.setObject(feld[7]).rForReset();


    }


}
