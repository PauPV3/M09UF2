import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private int placesDisponibles;
    private final int maxPlaces;
    private final List<Asistent> asistents;

    piblic Esdeveniment(int maxPlaces) {
        this.maxPlaces = maxPlaces;
        this.placesDisponibles = maxPlaces;
        this.asistents = new ArrayList<>();
    }

    public synchronized boolean ferReserva(Asistent asistent) {
        if (placesDisponibles > 0) {
            asistents.add(asistent);
            placesDisponibles --;
            System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
            return true;
        } else {
            System.out.println(assistent.getNom() + " no ha pogut fer la reserva. No hi ha places disponibles.");
            return false;
        }
    }

    public synchronized boolean cancelaReserva(Asistent asistent) {
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