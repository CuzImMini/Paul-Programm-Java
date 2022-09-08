package de.paulcornelissen;

import basis.Hilfe;

public class Main {

    public static void main(String[] s) {

        //Starte Paint
        Application paulPaint = new Application("Paul-Paint");

        //Testinstanz
        //Instance instance = new Instance("Bildergalerie", 500,500,true);

        //Test-Bildergalerie
        //TODO Bildergalerie in Gui implementieren
        // - Knopf in GUI hinzufügen
        //   - Knopf ruft über öffentliche Variablen die Klasse
        //     Bildergalerie in der laufenden Instanz auf
        Bildergalerie bg = new Bildergalerie();
    }

}
