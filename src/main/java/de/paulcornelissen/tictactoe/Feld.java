package de.paulcornelissen.tictactoe;

import basis.Bild;

public class Feld extends Bild {

    int belegt = 90;
    TicTacToe ticTacToe;

    public Feld(int x, int y, int breite, int hoehe, TicTacToe ticTacToe) {
        this.clear();
        this.setzeGroesse(breite, hoehe);
        this.setzePosition(x, y);
        this.ticTacToe = ticTacToe;
    }

    public int getX() {
        return (int) this.hPosition();
    }

    public int getY() {
        return (int) this.vPosition();
    }

    public void setPlayer() {
        switch (ticTacToe.player) {
            case 0 -> {
                ticTacToe.getPencilManager().setObject(this).zeichneO();
                belegt = 1;
            }
            case 1 -> {
                ticTacToe.getPencilManager().setObject(this).zeichneX();
                belegt = 2;
            }
        }
    }

    public void clear() {
        this.loescheAlles();
    }
}
