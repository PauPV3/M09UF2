public class Organitzador {
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);
        Assistent[] assistents = new Assistent[10];

        for (int i = 0; i < 10; i++) {
            assistents[i] = new Assistent(String.valueOf(i), esdeveniment);
            assistents[i].start();
        }
    }
}
