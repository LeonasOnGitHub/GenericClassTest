package intervall;

public class Intervall<T extends Comparable<? super T>> {
    public T obereGrenze;
    public T untereGrenze;

    public Intervall(T untereGrenze, T obereGrenze) {
        this.untereGrenze = untereGrenze;
        this.obereGrenze = obereGrenze;
    }

    /**
     * Überptüft ob der Intervall leer ist
     * @return true, wenn der intervall leer ist
     */
    public boolean istLeer() {
        return obereGrenze.compareTo(untereGrenze) < 1;
    }

    public <T1 extends T> boolean enthaelt(T1 wert) {
        return wert.compareTo(obereGrenze) < 1 && wert.compareTo(untereGrenze) > 0;
    }

    public <T2 extends T> Intervall<T> schnitt(Intervall<T2> anderes) {
        T schnittObereGrenze;
        T schnittUntereGrenze;
        if (this.obereGrenze.compareTo(anderes.obereGrenze) <= 0) {
            schnittObereGrenze = this.obereGrenze;
        } else {
            schnittObereGrenze = anderes.obereGrenze;
        }
        if (this.untereGrenze.compareTo(anderes.untereGrenze) >= 0) {
            schnittUntereGrenze = this.obereGrenze;
        } else {
            schnittUntereGrenze = anderes.obereGrenze;
        }

        return new Intervall<>(schnittUntereGrenze, schnittObereGrenze);
    }

}
