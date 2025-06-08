package test;
import algoritmos.secuencial.QuickSortSecuencial;
import algoritmos.concurrente.QuickSortConcurrente;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Test {
    //Creo un array con diversos tamanios para probar cada caso
    private static final int[] TAMANIOS = {10, 1000, 100000, 1000000};

    public static void main(String[] args) {
        for (int tam : TAMANIOS) {
            System.out.println("\n====================== Tamanio del array: " + tam + " ======================");
            int[] arr1 = generarArrayAleatorio(tam);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            
            //Uso el metodo nanoTime para calcular cuanto tiempo tardara cada
            //version de QuickSort en nanosegundos

            // Secuencial
            long startSec = System.nanoTime();
            QuickSortSecuencial.quickSort(arr1, 0, arr1.length - 1);
            long endSec = System.nanoTime();

            //formula para convertir los nanosegundos en milisegundos
            double tiempoSec = (endSec - startSec) / 1e6;
            System.out.println("QuickSort Secuencial tardo: " + tiempoSec + " ms en terminar");

            // Concurrente
            ForkJoinPool pool = ForkJoinPool.commonPool();
            long startConc = System.nanoTime();
            pool.invoke(new QuickSortConcurrente(0, arr2.length - 1, arr2));
            long endConc = System.nanoTime();
            double tiempoConc = (endConc - startConc) / 1e6;
            System.out.println("QuickSort Concurrente tardo: " + tiempoConc + " ms en terminar");

            // Mostrar arrays pequeños
            if (tam <= 20) {
                System.out.println("Array ordenado (Secuencial): " + Arrays.toString(arr1));
                System.out.println("Array ordenado (Concurrente): " + Arrays.toString(arr2));
            }
        }
    }
    //Funcion que genera arrays con valores aleatorios de acuerdo al tamanio deseado
    private static int[] generarArrayAleatorio(int tam) {
        Random rand = new Random();
        int[] arr = new int[tam];
        for (int i = 0; i < tam; i++) {
            arr[i] = rand.nextInt(1, 1000000);
        }
        return arr;
    }
}
