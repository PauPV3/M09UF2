import java.util.Random;

public class Asistent extends Thread {
    private final String nom;
    private final Esdeveniment esdeveniment;
    private final Random random;

    public Asistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
        this.random = new random();
    }

    public String getNom() {
        return "Assistent-" + nom;
    }

    @Override
    public void run() {
        
    }
}