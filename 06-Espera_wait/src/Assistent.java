import java.util.Random;

public class Assistent extends Thread {
    private final String nom;
    private final Esdeveniment esdeveniment;
    private final Random random;

    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
        this.random = new Random();
    }

    public String getNom() {
        return "Assistent-" + nom;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(1000)); // Espera entre 0 i 1s
                if (random.nextBoolean()) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}