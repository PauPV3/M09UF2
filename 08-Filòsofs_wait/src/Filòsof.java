import java.util.Random;

public class Filòsof extends Thread {
    private final int id;
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private int gana;
    private final Random random;

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
        System.out.println("Filòsof " + id + " està pensant.");
        Thread.sleep(1000 + random.nextInt(1000)); // Pensar entre 1s i 2s
    }

    private void menjar() throws InterruptedException {
        while (true) {
            if (esquerra.agafar()) {
                System.out.println("Filòsof " + id + " agafa la forquilla esquerra " + esquerra.getId());

                if (dreta.agafar()) {
                    System.out.println("Filòsof " + id + " agafa la forquilla dreta " + dreta.getId());
                    System.out.println("Filòsof " + id + " està menjant.");
                    Thread.sleep(1000 + random.nextInt(1000)); // Menja entre 1s i 2s
                    dreta.deixar();
                    esquerra.deixar();
                    System.out.println("Filòsof " + id + " ha acabat de menjar.");
                    return;
                } else {
                    esquerra.deixar();
                    System.out.println("Filòsof " + id + " deixa la forquilla esquerra (" + esquerra.getId() + ") i espera.");
                    gana++;
                    System.out.println("Filòsof " + id + " gana=" + gana);
                    Thread.sleep(500 + random.nextInt(500)); // Espera entre 0.5s i 1s
                }
            } else {
                Thread.sleep(500 + random.nextInt(500)); // Espera entre 0.5s i 1s
            }
        }
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