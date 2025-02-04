import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private int placesDisponibles;
    private final int maxPlaces;
    private final List<Assistent> assistents;

    public Esdeveniment(int maxPlaces) {
        this.maxPlaces = maxPlaces;
        this.placesDisponibles = maxPlaces;
        this.assistents = new ArrayList<>();
    }

    public synchronized boolean ferReserva(Assistent assistent) {
        if (placesDisponibles > 0) {
            assistents.add(assistent);
            placesDisponibles --;
            System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
            return true;
        } else {
            System.out.println(assistent.getNom() + " no ha pogut fer la reserva. No hi ha places disponibles.");
            return false;
        }
    }

    public synchronized boolean cancelaReserva(Assistent assistent) {
        if (assistents.remove(assistent)) {
            placesDisponibles++;
            System.out.println(assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            return true;
        } else {
            System.out.println(assistent.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDisponibles);
            return false;
        }
    }
}