import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    private Queue<Client> salaEspera = new LinkedList<>();
    private int maxCadires;
    private Object condBarber = new Object();
    private static Barberia instancia;
    
    public Barberia(int maxCadires) {
        this.maxCadires = maxCadires;
        instancia = this;
    }

    public static Barberia getInstancia() {
        return instancia;
    }

    public Object getCondBarber() {
        return condBarber;
    }

    public synchronized Client seguentClient() {
        return salaEspera.poll();
    }

    public synchronized void entrarClient(Client client) {
        if (salaEspera.size() < maxCadires) {
            salaEspera.offer(client); //afegeix el client a la cua
            System.out.println(client.getNom() + " en espera");
            synchronized (condBarber) {
                condBarber.notify(); //desperta al barber
            }
        } else {
            System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
        }
    }

    public void executa() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            entrarClient(new Client(i));
            Thread.sleep(500); //espera 0.5 seg
        }
        Thread.sleep(10000);
        for (int i = 11; i <= 20; i++) {
            entrarClient(new Client(i));
            Thread.sleep(500);
        }
    }
}