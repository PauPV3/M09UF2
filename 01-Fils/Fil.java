public class Fil extends Thread {
    private String nom;
    private int tipusExecucio;

    public Fil(String nom, int tipusExecucio) {
        this.nom = nom;
        this.tipusExecucio = tipusExecucio;
    }

    @Override
    public void run() {
        switch (tipusExecucio) {
            case 1:
                for (int i = 1; i <= 9; i++) {
                    if (i % 2 == 0 || i % 2 != 0) { 
                        System.out.println(nom + " " + i);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case 2:
                synchronized (Fil.class) {
                    int i = 1;
                    while (i <= 9) {
                        System.out.println(nom + " " + i);
                        Fil.class.notifyAll();
                        try {
                            if (i < 9) {
                                Fil.class.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                }
                break;
        }
        System.out.println("Termina el fil " + nom);
    }
}