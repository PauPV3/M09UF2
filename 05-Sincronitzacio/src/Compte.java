public class Compte {
    private static Compte instancia;
    private float saldo;

    private Compte() {
        this.saldo = 0f; //salod inicial 0
    }

    //getter de instancia
    public static synchronized Compte getInstancia() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    //getter de saldo
    public synchronized float getSaldo() {
        return saldo;
    }

    //setter saldo
    public synchronized void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    //metode per actualitzar el saldo
    public synchronized void actualitzaSaldo(float quantitat) {
        saldo = saldo + quantitat;
    }
}