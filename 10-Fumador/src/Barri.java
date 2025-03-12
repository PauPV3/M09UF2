public class Barri {
    private Estanc estanc = new Estanc();
    private Fumador[] fumadors = new Fumador[3];

    public Barri() {
        for (int i = 0; i < 3; i++) {
            fumadors[i] = new Fumador(estanc, i);
        }
    }

    public void executa() throws InterruptedException {
        for (Fumador fumador : fumadors) {
            fumador.start();
        }
        estanc.executa();

        for (Fumador fumador : fumadors) {
            fumador.join();
        }
        estanc.tancarEstanc();
    }

    public static void main(String[] args) throws InterruptedException {
        Barri barri = new Barri();
        barri.executa();
    }
}