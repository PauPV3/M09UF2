public class Motor {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private int numeroMotor;

    // consturcot
    public Motor(int numero) {
        this.numeroMotor = numero;
    }

    // seter per establir la potencia objectiu
    public synchronized void setPotencia(int p) {
        potenciaObjectiu = p;
        // fil per simular lincrement o decrement de la potencia amb retards aleatoris
        new Thread(() -> {
            while (potenciaActual != potenciaObjectiu) {
                try {
                    // interval aleatori entre 1 i 2 segons
                    Thread.sleep((int)(Math.random() * 1000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // incrementa o decrementa la potencia actual
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                } else {
                    potenciaActual--;
                }
                // mostra la porencia actual i el numero del motor
                System.out.println("Motor " + numeroMotor + ": Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
            }
            // si arriba a 0 surt
            if (potenciaActual == 0) {
                System.out.println("Motor " + numeroMotor + " apagat.");
            }
        }).start();
    }
}