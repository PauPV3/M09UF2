// Fumador.java
import java.util.Random;

public class Fumador extends Thread {
    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int numFumades = 0;
    private Random rand = new Random();

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    public void fuma() throws InterruptedException {
        System.out.println("Fumador " + id + " fumant");
        Thread.sleep(500 + rand.nextInt(500)); // Fuma entre 0.5 i 1s
        numFumades++;
        System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades");
    }

    // Mètode per comprar ingredients en ordre aleatori
    public void compraIngredients() {
        int[] ordre = {0, 1, 2}; // 0: tabac, 1: paper, 2: llumi
        shuffleArray(ordre); // Aleatoritza l'ordre

        for (int i : ordre) {
            switch (i) {
                case 0:
                    tabac = estanc.venTabac();
                    System.out.println("Fumador " + id + " comprant Tabac");
                    break;
                case 1:
                    paper = estanc.venPaper();
                    System.out.println("Fumador " + id + " comprant Paper");
                    break;
                case 2:
                    llumi = estanc.venLlumi();
                    System.out.println("Fumador " + id + " comprant Llumi");
                    break;
            }
        }
    }

    // Mètode per barrejar l'ordre dels ingredients
    private void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    @Override
    public void run() {
        while (numFumades < 3) { // Fuma fins a 3 vegades
            compraIngredients(); // Compra ingredients en ordre aleatori
            try {
                fuma();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        estanc.fumadorAcabat(); // Notifica a l'estanc que ha acabat
    }
}