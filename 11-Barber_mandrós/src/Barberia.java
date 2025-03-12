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
        
    }
}