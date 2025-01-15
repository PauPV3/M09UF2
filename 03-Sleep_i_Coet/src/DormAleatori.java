import java.util.Random;

class DormAleatori extends Thread {
    private long instantCreacio;

    // constructos
    public DormAleatori(String nom) {
        super(nom);
        this.instantCreacio = System.currentTimeMillis(); // guardem el temps de creacio
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int intervalAleatori = random.nextInt(1000); // generem interval aleatori
            long tempsTotal = System.currentTimeMillis() - instantCreacio; // temps total des de la creacio
            System.out.println(getName() + "(" + i + ") a dormir " + intervalAleatori + "ms total " + tempsTotal);
            try {
                Thread.sleep(intervalAleatori); // dormim durant l'interval
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start(); // execucio fil joan
        pep.start();  // execucio fil pep

        System.out.println("-- Fi de main -----------");
    }
}
