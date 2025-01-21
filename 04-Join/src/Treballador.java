import java.util.Random;

class Treballador extends Thread {
    private final float nouAnualBrut;
    private final int edatIniciTreball;
    private final int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private final Random rnd;

    public Treballador(float nouAnualBrut, int edatIniciTreball, int edatFiTreball) {
        this.nouAnualBrut = nouAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    public void cobra() {
        cobrat += nouAnualBrut / 12.0f;
    }

    public void pagaImpostos() {
        cobrat -= (nouAnualBrut / 12.0f) * 0.24f;
    }

    @Override
    public void run() {
        while (edatActual < edatFiTreball) {
            if (edatActual >= edatIniciTreball) {
                cobra();
                pagaImpostos();
            }
            edatActual++;
        }
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edatActual;
    }
}
