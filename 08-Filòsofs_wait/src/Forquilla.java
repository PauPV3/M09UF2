public class Forquilla {
    private final int id;
    private boolean enUs;

    public Forquilla(int id) {
        this.id = id;
        this.enUs = false;
    }

    public synchronized boolean agafar() throws InterruptedException {
        while (enUs) {
            wait();
        }
        enUs = true;
        return true;
    }

    public synchronized void deixar() {
        enUs = false;
        notifyAll();
    }

    public int getId() {
        return id;
    }
}