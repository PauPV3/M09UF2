public class Forquilla {
    private final int id;
    private boolean enUs;

    //constructor
    public Forquilla(int id) {
        this.id = id;
        this.enUs = false;
    }

    //agafar froquilla
    public synchronized boolean agafar() {
        if (!enUs) {
            enUs = true;
            return true;
        }
        return false;
    }

    //deixar forquilla
    public synchronized void deixar() {
        enUs = false;
    }

    public int getId() {
        return id;
    }
}
