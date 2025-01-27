public class Associacio {
    private final int numSocis = 100;
    private final Soci[] socis;
    private final Compte compte;

    public Associacio() {
        this.compte = Compte.getInstancia();
        this.socis = new Soci[numSocis];

        for(int i = 0; i < numSocis; i++) {
            socis[i] = new Soci(compte);
        }
    }
    //iniciar els fils de socis
    public void iniciaCompteTempsSocis() {
        Thread[] fils = new Thread[numSocis];

        for (int i = 0; i < numSocis; i++) {
            fils[i] = new Thread(socis[i]); //crear un fil per cada soci
            fils[i].start();
        }

        //esperar que tots els fils acabin
        for (Thread fil : fils) {
            try {
                fil.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    //mostrar saldo final del compte
    public void mostraBalancComptes() {
        System.out.printf("Saldo: %.2f%n", compte.getSaldo()); // Mostrem el saldo final
    }
}