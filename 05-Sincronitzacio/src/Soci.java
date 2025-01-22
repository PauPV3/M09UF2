import java.util.Random;

public class Soci extends Runnable {
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

    }
}