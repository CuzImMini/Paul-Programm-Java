package de.paulcornelissen.daumenkino;

import basis.Hilfe;

import java.io.IOException;

public class GifPlayer {

private DaumenkinoInstanceManager instance;

    public GifPlayer() {
        this.instance = new DaumenkinoInstanceManager("GifPlayer", 600, 400, false);

    }

    public void playHorseGif() {

        Thread t = new Thread(() -> {
            while (true) {
                try {
                    for (int i = 0; i < 15; i++) {

                        instance.setBackgroundPhoto(new java.io.File("./repo/de/wikipedia/horse-" + i + ".png").getCanonicalPath());
                        Hilfe.warte(66);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        t.start();



    }

}
