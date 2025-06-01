package hilos;

// Extiende Thread
public class Hilo extends Thread {
    @Override
    public void run() {
        System.out.println("¡Hola! Soy un hilo nuevo.");
    }

    public static void main(String[] args) {
        Hilo hilo = new Hilo(); // Crear hilo
        hilo.start(); // Lanzar hilo (ejecuta run())
        System.out.println("Soy el hilo principal.");
    }
}
