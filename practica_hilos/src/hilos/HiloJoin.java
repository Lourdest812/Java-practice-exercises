package hilos;

public class HiloJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Hilo secundario: " + i);
            }
        });

        hilo.start();
        hilo.join(); // Espera que hilo termine
        System.out.println("¡Listo! El hilo secundario terminó.");
    }
}
