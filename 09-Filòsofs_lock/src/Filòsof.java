import java.util.Random;

public class Filòsof extends Thread {
    private final int id;
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private int gana;
    private final Random random;
    private long iniciGana;
    private long fiGana;

    public Filòsof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensar() throws InterruptedException {
        iniciGana = System.currentTimeMillis(); // Iniciem el comptador de gana
        System.out.println("Filòsof " + id + " està pensant.");
        Thread.sleep(1000 + random.nextInt(1000)); // Pensar entre 1s i 2s
    }

    private void menjar() throws InterruptedException {
        while (true) {
            if (esquerra.agafar()) {
                System.out.println("Filòsof " + id + " agafa la forquilla esquerra " + esquerra.getId());

                if (dreta.agafar()) {
                    System.out.println("Filòsof " + id + " agafa la forquilla dreta " + dreta.getId());
                    fiGana = System.currentTimeMillis(); // Finalitzem el comptador de gana
                    gana = (int) (fiGana - iniciGana) / 1000; // Calculem la gana en segons
                    System.out.println("Filòsof " + id + " està menjant amb gana " + gana);
                    Thread.sleep(1000 + random.nextInt(1000)); // Menja entre 1s i 2s
                    dreta.deixar();
                    esquerra.deixar();
                    System.out.println("Filòsof " + id + " ha acabat de menjar.");
                    resetGana();
                    return;
                } else {
                    esquerra.deixar();
                    System.out.println("Filòsof " + id + " deixa la forquilla esquerra (" + esquerra.getId() + ") i espera.");
                    Thread.sleep(500 + random.nextInt(500)); // Espera entre 0.5s i 1s
                }
            } else {
                Thread.sleep(500 + random.nextInt(500)); // Espera entre 0.5s i 1s
            }
        }
    }

    private void resetGana() {
        iniciGana = 0;
        fiGana = 0;
        gana = 0;
    }

    public Forquilla getEsquerra() {
        return esquerra;
    }

    public Forquilla getDreta() {
        return dreta;
    }

    public int getFilId() {
        return id;
    }
}