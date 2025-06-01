package hilos;

public class HiloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("¡Hola desde el hilo Runnable!");
    }

    public static void main(String[] args) {
        Thread hilo = new Thread(new HiloRunnable());
        hilo.start();
        System.out.println("Hilo principal termina.");
    }
}