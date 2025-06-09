package test;
import datos.PivotStrategy;
import funciones.Funciones;
import java.util.Arrays;
import datos.Tamanios;

public class TestTamanios {
    public static void main(String[] args) {
        //Ejecuta QuickSort secuencial y concurrente para probar con los diferentes tamanios
        pruebasQuickSortPorTamanio();
        
    }

    private static void pruebasQuickSortPorTamanio(){
        for (int tam : Tamanios.TAMANIOS) {
            System.out.println("\n====================== Tamanio del array: " + tam + " ======================");
            int[] arr1 = Funciones.generarArrayAleatorio(tam);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            
            // Secuencial
            System.out.println("\nQuickSort Secuencial tardo: " + Funciones.calcularTiempoSecuencial(arr1) + " ms en terminar");
            //Muestro los arrays ordenados por consola
            System.out.println("Array Ordenado (Secuencial): " );
            Funciones.mostrarArray(arr1);
            // Concurrente
            System.out.println("\nQuickSort Concurrente tardo: " + Funciones.calcularTiempoConcurrente(arr2, PivotStrategy.RANDOM) + " ms en terminar");
            System.out.println("Array ordenado (Concurrente): ");
            Funciones.mostrarArray(arr2);

        }
    }
}
        