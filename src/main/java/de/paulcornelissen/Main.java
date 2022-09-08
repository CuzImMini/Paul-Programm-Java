package de.paulcornelissen;

import java.io.IOException;

public class Main {

    public static void main(String[] s) throws IOException {

        //Starte Paint
        //Application paulPaint = new Application("Paul-Paint");

        //Testinstanz
        Instance instance = new Instance("Bildergalerie", 600, 400, false);
        new GifPlayer().playHorseGif(instance);

        //Test-Bildergalerie
        //TODO Bildergalerie in Gui implementieren
        // - Knopf in GUI hinzufügen
        //   - Knopf ruft über öffentliche Variablen die Klasse
        //     Bildergalerie in der laufenden Instanz auf
        //Bildergalerie bg = new Bildergalerie();
    }

}
