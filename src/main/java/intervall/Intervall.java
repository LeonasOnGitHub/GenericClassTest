package intervall;

/*
Diese Klasse stellt ein Intervall zwischen zwei beliben werten dar
 */
public class Intervall<T extends Comparable<? super T>> {
    public T obereGrenze;
    public T untereGrenze;

    public Intervall(T untereGrenze, T obereGrenze) {
        this.untereGrenze = untereGrenze;
        this.obereGrenze = obereGrenze;
    }

    /**
     * Überptüft ob der Intervall leer ist
     *
     * @return true, wenn der intervall leer ist
     */
    public boolean istLeer() {
        return obereGrenze.compareTo(untereGrenze) < 1;
    }

    /**
     * gibt an ob ein wert sich inerhalb this Intervalss befindet
     *
     * @param wert den zu überprüfenden wert
     * @param <T1>
     * @return ob der wert in dem this Intervall ist
     */
    public <T1 extends Comparable<? super T>> boolean enthaelt(T1 wert) {
        return wert.compareTo(obereGrenze) < 1 && wert.compareTo(untereGrenze) > 0;
    }

    /**
     * Macht asu this und einem weiteren intervall ein Schnittintervall
     *
     * @param anderes das weitere Intervall
     * @param <T2>
     * @return das neue Schnittintervall
     */
    public <T2 extends T> Intervall<T> schnitt(Intervall<T2> anderes) {
        T schnittObereGrenze;
        T schnittUntereGrenze;
        if (this.obereGrenze.compareTo(anderes.obereGrenze) <= 0) {
            schnittObereGrenze = this.obereGrenze;
        } else {
            schnittObereGrenze = anderes.obereGrenze;
        }
        if (this.untereGrenze.compareTo(anderes.untereGrenze) >= 0) {
            schnittUntereGrenze = this.untereGrenze;
        } else {
            schnittUntereGrenze = anderes.untereGrenze;
        }

        return new Intervall<>(schnittUntereGrenze, schnittObereGrenze);
    }

}
