import java.util.Random;

public class Soci implements Runnable {
    private final Compte compte;
    private final float aportacio = 10f; 
    private final int esperaMax = 100;
    private final int maxAnys = 10;
    private final Random random = new Random();

    public Soci(Compte compte) {
        this.compte = compte;
    }

    @Override
    public void run() {
        for (int any = 0; any < maxAnys; any++) { // pels anys
            for (int mes = 1; mes <= 12; mes++) { // pels mesos
                if (mes % 2 == 0) {
                    compte.actualitzaSaldo(aportacio);
                } else {
                    compte.actualitzaSaldo(-aportacio);
                }

                // Simular temps d'espera aleatori
                try {
                    Thread.sleep(random.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}