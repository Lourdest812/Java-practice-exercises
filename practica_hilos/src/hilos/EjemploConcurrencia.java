package hilos;
public class EjemploConcurrencia extends Thread{
    public static void main(String[] args) {
        Thread tareaA = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Tarea A - paso " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });
        Thread tareaB = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Tarea B - paso " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        });

        tareaA.start();
        tareaB.start();

        try {
            tareaA.join();
            tareaB.join();
        } catch (InterruptedException e) {}
        System.out.println("¡Ambas tareas terminaron!");
    }
}