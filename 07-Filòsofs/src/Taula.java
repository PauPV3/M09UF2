public class Taula {
    private final Filòsof[] filòsofs;
    private final Forquilla[] forquilles;

    //constructor
    public Taula(int numFilòsofs) {
        filòsofs = new Filòsof[numFilòsofs];
        forquilles = new Forquilla[numFilòsofs];

        for (int i = 0; i < numFilòsofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        //crear els filosofs
        for (int i = 0; i < numFilòsofs; i++) {
            filòsofs[i] = new Filòsof(i, forquilles[i], forquilles[(i + 1) % numFilòsofs]);
        }
    }

    //mostrar taula
    public void mostrarTaula() {
        for (Filòsof filòsof : filòsofs) {
            System.out.println("Comensal: fil" + filòsof.getFilId() + 
                               " esq:" + filòsof.getEsquerra().getId() + 
                               " dret:" + filòsof.getDreta().getId());
        }
    }

    //inicia filosofs
    public void cridarATaula() {
        for (Filòsof filòsof : filòsofs) {
            filòsof.start();
        }
    }

    public Filòsof[] getFilòsofs() {
        return filòsofs;
    }
}