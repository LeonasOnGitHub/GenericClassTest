package intervall;


import java.sql.Timestamp;
import java.util.Date;
import java.sql.Time;

public class Hauptprogramm {
    public static void main(String[] args) {

        //Test mit String Intervall
        Intervall<String> sIntervall = new Intervall<>("A", "D");
        System.out.println("Das Intervall ist leer: " + sIntervall.istLeer());
        System.out.println("Das Intervall enthaelt ein B: " + sIntervall.enthaelt("B"));
        System.out.println("Das Intervall enthaelt ein X: " + sIntervall.enthaelt("X"));
        Intervall<String> newSIntervall = sIntervall.schnitt(new Intervall<>("B", "E"));
        System.out.println("Das schnitt Intervall hat die Menge von: " + newSIntervall.untereGrenze + "-" + newSIntervall.obereGrenze);

        //test mit Date schnitt Date Intervall
        System.out.println("-------------------Date schnitt Date-------------------");
        Date date1 = new Date(200, 10, 1);
        Date date2 = new Date(201, 10, 1, 10, 55, 10);
        Date date3 = new Date(200, 11, 1);
        Date date4 = new Date(211, 8, 1);
        Intervall<Date> dateIntervall = new Intervall<>(date1, date2);
        Intervall<Date> newDateIntervall = dateIntervall.schnitt(new Intervall<>(date3, date4));
        System.out.println("Das schnitt Intervall hat die Menge von: " + newDateIntervall.untereGrenze + "-" + newDateIntervall.obereGrenze);

        //test mit Date schnitt Time Intervall
        System.out.println("-------------------Date schnitt Time-------------------");
        Time time1 = new Time(3600000L);
        Time time2 = new Time(39600000L);
        Intervall<Time> timeIntervall = new Intervall<>(time1, time2);
        Intervall<Date> newDateTimeIntervall = dateIntervall.schnitt(timeIntervall);
        System.out.println("Das schnitt Intervall hat die Menge von: " + newDateTimeIntervall.untereGrenze + "-" + newDateTimeIntervall.obereGrenze);

        //test ob TimeStamp in Date und Time enthalten ist
        System.out.println("----------------TimeStamp in Date/time-----------------");
        Timestamp ts=new Timestamp(13600000L);
        System.out.println("Das Time Intervall enthaelt den TS: " + timeIntervall.enthaelt(ts));
        System.out.println("Das Date Intervall enthaelt den TS: " + dateIntervall.enthaelt(ts));


       //FEHLER: Intervall<Number> falsch = new Intervall<>("A", "B");
        Intervall<Double> zahlen = new Intervall<>(1.2, 3.4);
        Intervall<String> texte = new Intervall<>("a", "b");
        //FEHLER: zahlen.schnitt(texte);
    }
}
