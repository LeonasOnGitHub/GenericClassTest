package intervall;

import javax.sound.midi.Soundbank;

public class Hauptprogramm {
    public static void main(String[] args) {
        String siog = "A";
        String siug = "D";

        Intervall<String> sIntervall = new Intervall<>(siog, siug);
        System.out.println("Das Intervall ist leer: " + sIntervall.istLeer());
        System.out.println("Das Intervall enthält ein B: " + sIntervall.enthaelt("B"));
        System.out.println("Das Intervall enthält ein X: " + sIntervall.enthaelt("X"));
        Intervall<String> newSIntervall = sIntervall.schnitt(new Intervall<>("B", "E"));
        System.out.println("Das schnitt Intervall hat die Menge von: " + newSIntervall.untereGrenze + "-" + newSIntervall.obereGrenze);


    }
}
