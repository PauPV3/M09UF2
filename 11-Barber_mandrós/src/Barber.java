public class Barber extends Thread {
    private String nom;
    private Barberia barberia;

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = barberia.seguentClient(); //agafa el seguent client
            if (client != null) {
                try {
                    System.out.println("Li toca al client " + client.getNom());
                    client.tallarseElCabell(); //talla el cabell
                    Thread.sleep(900 + (int)(Math.random() * 100)); //temps tallan
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                synchronized (barberia.getCondBarber()) {
                    try {
                        System.out.println("Barber " + nom + " dormint");
                        barberia.getCondBarber().wait(); //dorm si no hi ha clients
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}