package de.paulcornelissen;

import de.paulcornelissen.daumenkino.GifPlayer;
import de.paulcornelissen.daumenkino.Hampelmann;
import de.paulcornelissen.paulpaint.Application;
import de.paulcornelissen.paulpaint.Instance;
import de.paulcornelissen.pong.InstanceManager;
import de.paulcornelissen.pong.Pong;

import java.io.IOException;

public class Main {

    public static void main(String[] s) throws IOException {

        //Starte Paint
        //Application paulPaint = new Application("Paul-Paint");

        //GifPlayer
        //InstanceManager instance = new InstanceManager("Pauls-Daumenkino", 600, 400, false);
        //new GifPlayer().playHorseGif(instance);

        //Hampelmann
        //Instance hampelmannInstance = new Instance("Pauls-Daumenkino", 400, 600, true);
        //Hampelmann hampelmann = new Hampelmann(hampelmannInstance);

        //Pong
        Pong pong = new Pong();
    }

}
