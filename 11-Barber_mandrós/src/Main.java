public class Main {
    public static void main(String[] args) throws InterruptedException {
        Barberia barberia = new Barberia(3); //barberia amb 3 cadires
        Barber barber = new Barber("Pepe", barberia); //barber Pepe
        barber.start();
        barberia.executa();
    }
}