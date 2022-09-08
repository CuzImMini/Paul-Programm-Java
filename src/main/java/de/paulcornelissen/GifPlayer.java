package de.paulcornelissen;

import basis.Hilfe;

import java.io.IOException;

public class GifPlayer {

    public GifPlayer() {
    }

    public void playHorseGif(Instance instance) throws IOException {
        while (true) {
            for (int i = 0; i < 15; i++) {

                String currentPath = new java.io.File("./repo/de/wikipedia/horse-" + i + ".png").getCanonicalPath();
                instance.setBackgroundPhoto(currentPath);
                Hilfe.warte(66);
            }
        }
    }

}
