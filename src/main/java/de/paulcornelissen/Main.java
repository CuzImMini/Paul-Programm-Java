package de.paulcornelissen;

import basis.vw.Einstellungen;
import de.paulcornelissen.daumenkino.HorseGIF;
import de.paulcornelissen.daumenkino.Hampelmann;
import de.paulcornelissen.paulpaint.Application;
import de.paulcornelissen.pong.Pong;

import java.io.IOException;

public class Main {

    public static void main(String[] s) throws IOException {

        //Starte Paint
        //Application paulPaint = new Application("Paul-Paint");

        //GifPlayer
        //InstanceManager instance = new InstanceManager("Pauls-Daumenkino", 600, 400, false);
        //new HorseGIF().playHorseGif(instance);

        //Hampelmann
        //Hampelmann hampelmann = new Hampelmann();

        //Pong
        Pong pong = new Pong();
    }

}
