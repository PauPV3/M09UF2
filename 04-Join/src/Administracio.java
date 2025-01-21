class Administracio {
    private final int numPoblacioActiva = 50;
    private final Treballador[] poblacioActiva;

    public Administracio() {
        poblacioActiva = new Treballador[numPoblacioActiva];
        for (int i = 0; i < numPoblacioActiva; i++) {
            poblacioActiva[i] = new Treballador(25000, 20, 65);
        }
    }

    public void iniciarSimulacio() {
        for (Treballador treballador : poblacioActiva) {
            treballador.start();
        }

        for (Treballador treballador : poblacioActiva) {
            try {
                treballador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numPoblacioActiva; i++) {
            System.out.printf("Ciutada-%d -> edat: %d / total: %.2f", i, poblacioActiva[i].getEdat(), poblacioActiva[i].getCobrat());
            System.out.println(" ");
        }
    }
}
