public class Main {
    public static void main(String[] args) {
        int numFilòsofs = 5; //numeero de filosofs a la taula

        //crear la taula
        Taula taula = new Taula(numFilòsofs);
        taula.mostrarTaula();

        //iniciar els filosofs
        taula.cridarATaula();
    }
}