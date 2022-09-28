package de.paulcornelissen;

import de.paulcornelissen.daumenkino.GifPlayer;
import de.paulcornelissen.daumenkino.Hampelmann;
import de.paulcornelissen.paulpaint.PaulPaint;
import de.paulcornelissen.pong.Pong;
import de.paulcornelissen.tictactoe.TicTacToe;

import javax.swing.*;

public class MainGui extends JFrame {
    private JButton startHampelmann;
    private JButton startVierGewinnt;
    private JButton startPaulPaint;
    private JButton startHorseGif;
    private JButton startTictacToe;
    private JButton startPong;
    private JPanel mainframe;

    public MainGui() {
        this.setTitle("Paul's Programm");
        this.setSize(550, 400);
        this.getContentPane().add(mainframe);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addActionListeners();


        this.setVisible(true);
    }

    public void addActionListeners() {
        startHampelmann.addActionListener(e -> {
            Thread hampelmannThread = new Thread(Hampelmann::new);
            hampelmannThread.start();
        });
        startVierGewinnt.addActionListener(e -> {
            Thread vierGThrad = new Thread(() -> System.out.println("Vier Gewinnt"));
            vierGThrad.start();
        });
        startPaulPaint.addActionListener(e -> {
            Thread paulPaintThread = new Thread(() -> {
                new PaulPaint("Paul-Paint");
            });
            paulPaintThread.start();
        });
        startHorseGif.addActionListener(e -> {
            Thread horseGifThread = new Thread(GifPlayer::new);
            horseGifThread.start();
        });
        startTictacToe.addActionListener(e -> {
            Thread ticTacToeThread = new Thread(TicTacToe::new);
            ticTacToeThread.start();
        });
        startPong.addActionListener(e -> {
            Thread pongThread = new Thread(Pong::new);
            pongThread.start();
        });
    }
}
