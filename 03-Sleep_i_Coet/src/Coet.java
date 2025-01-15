public class Coet {
    private Motor[] motors = new Motor[4];

    // Constructor
    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    // metode per passar els mototrs a una potencia
    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            // potencia ok
            throw new IllegalArgumentException("Potència fora de rang.");
        }
        // nova potencia pels motors
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    // metode per arrencar els motors
    public void arranca() {
        // llegeix la potenica objectiu
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("Introdueix la potència objectiu (0 per sortir):");
            int p = scanner.nextInt();
            if (p == 0) {
                passaAPotencia(0);
                break;
            }
            passaAPotencia(p);
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();
    }
}
