package test;

import java.util.Arrays;

import datos.PivotStrategy;
import datos.Tamanios;
import funciones.Funciones;

public class TestStrategies {
    public static void main(String[] args) {
        
        pruebasQuickSortStrategies(Tamanios.TAMANIOS[0]);//10
        pruebasQuickSortStrategies(Tamanios.TAMANIOS[3]);//1000000
        
    }
    private static void pruebasQuickSortStrategies(int tam){
        for(PivotStrategy strategy: PivotStrategy.values()){
             System.out.println("\n====================== Estrategia: " + strategy + " ======================\n");
            int[] arr1 = Funciones.generarArrayAleatorio(tam);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            
            //Muestro los arrays ordenados por consola y los tiempos de ejecucion
            
            //Las funciones de calcularTiempoSecuencial y calcularTimepoConcurrente incluyen la ejecucion de los algoritmos
            //QuickSort
            
            // Secuencial
            System.out.println("QuickSort Secuencial tardo: " + Funciones.calcularTiempoSecuencial(arr1) + " ms en terminar");
            System.out.println("Array ordenado (Secuencial): " );
            Funciones.mostrarArray(arr1);
            // Concurrente
            System.out.println("\nQuickSort Concurrente tardo: " + Funciones.calcularTiempoConcurrente(arr2, strategy) + " ms en terminar");
            System.out.println("Array ordenado (Concurrente): ");
            Funciones.mostrarArray(arr2);
        }
    }
}

