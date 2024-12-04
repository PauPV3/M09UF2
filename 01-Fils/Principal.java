public class Principal {
    public static void main(String[] args) {
        System.out.println("Inici del programa principal");
        Fil juan = new Fil("Juan", 1);
        Fil pepe = new Fil("Pepe", 1);

        if (juan != null && pepe != null) {
            juan.start();
            pepe.start();
        }

        try {
            juan.join();
            if (pepe.isAlive()) {
                pepe.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fi del programa principal");
    }
}
