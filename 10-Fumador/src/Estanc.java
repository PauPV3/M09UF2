// Estanc.java
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    private List<Tabac> tabacs = new ArrayList<>();
    private List<Paper> papers = new ArrayList<>();
    private List<Llumi> llumins = new ArrayList<>();
    private boolean obert = true;
    private int fumadorsAcabats = 0; // Comptador de fumadors que han acabat

    public Estanc() {
        // Constructor: inicialitza les llistes buides
    }

    public synchronized void nouSubministrament() {
        Random rand = new Random();
        int opcio = rand.nextInt(3);
        switch (opcio) {
            case 0: addTabac(); break;
            case 1: addPaper(); break;
            case 2: addLlumi(); break;
        }
    }

    public synchronized void addTabac() {
        tabacs.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll(); // Notifica als fumadors que hi ha tabac
    }

    public synchronized void addPaper() {
        papers.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll(); // Notifica als fumadors que hi ha paper
    }

    public synchronized void addLlumi() {
        llumins.add(new Llumi());
        System.out.println("Afegint Llumi");
        notifyAll(); // Notifica als fumadors que hi ha llumins
    }

    public synchronized Tabac venTabac() {
        while (tabacs.isEmpty() && obert) {
            try {
                wait(); // Espera si no hi ha tabac
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tabacs.remove(0);
    }

    public synchronized Paper venPaper() {
        while (papers.isEmpty() && obert) {
            try {
                wait(); // Espera si no hi ha paper
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return papers.remove(0);
    }

    public synchronized Llumi venLlumi() {
        while (llumins.isEmpty() && obert) {
            try {
                wait(); // Espera si no hi ha llumins
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return llumins.remove(0);
    }

    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll(); // Notifica a tots que l'estanc es tanca
    }

    public synchronized void fumadorAcabat() {
        fumadorsAcabats++;
        if (fumadorsAcabats == 3) { // Si tots els fumadors han acabat
            tancarEstanc(); // Tanca l'estanc
        }
    }

    public void executa() {
        while (obert) { // Continua generant subministraments mentre l'estanc estigui obert
            nouSubministrament();
            try {
                Thread.sleep(500 + new Random().nextInt(1000)); // Espera entre 0.5 i 1.5s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Estanc tancat");
    }
}