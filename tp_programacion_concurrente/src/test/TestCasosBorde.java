package test;

import java.util.Arrays;

import datos.PivotStrategy;
import funciones.Funciones;

public class TestCasosBorde {
    public static void main(String[] args) {
        // Pruebas adicionales con casos borde
    	
    	//Creo una matriz con un caso en cada fila
        int[][] casos = {
                {}, // vacío
                {1}, // un solo elemento
                {2, 1}, // dos elementos desordenados
                {1, 2}, // dos elementos ordenados
                {5, 5, 5, 5}, // todos iguales
                {9, 8, 7, 6, 5, 4, 3, 2, 1}, // descendente
                {1, 2, 3, 4, 5, 6, 7, 8, 9}, // ascendente
            };
        
        //Prueba con la estrategia RANDOM en todos los casos, menos los dos ultimos (arrays ordenados)
        for(int i = 0; i < casos.length - 2; i++) {
        	probarCasosBorde(PivotStrategy.RANDOM, casos[i]);
        }
        
        //Prueba con las estrategias FIRST y LAST en los arrays ordenados
        probarCasosBorde(PivotStrategy.FIRST, casos[casos.length-2]);
        probarCasosBorde(PivotStrategy.LAST, casos[casos.length-1]);
    }
    // Pruebas de casos borde y especiales
    private static void probarCasosBorde(PivotStrategy strategy, int []caso) {
        System.out.println("\n======= Pruebas de casos borde =======");
        //Creo una matriz con un caso en cada fila
            //Secuencial
            int[] arr1 = Arrays.copyOf(caso, caso.length);

            //Concurrente
            int[] arr2 = Arrays.copyOf(caso, caso.length);

            System.out.println("Caso: " + Arrays.toString(caso));
            //Las funciones calcularTiempoSecuencial y calcularTiempoConcurrente ejecutan QuickSort secuencial
            //y concurrente respectivamente
            System.out.println("Tiempo (Secuencial): " + Funciones.calcularTiempoSecuencial(arr1)+ " ms");
            System.out.println("Array ordenado (Secuencial): ");
            Funciones.mostrarArray(arr1);
            System.out.println("\nTiempo (Concurrente): " + Funciones.calcularTiempoConcurrente(arr2, strategy)+ " ms");
            System.out.println("Array ordenado (Concurrente): ");
            Funciones.mostrarArray(arr2);
            System.out.println("\nIguales: " + Funciones.sonIguales(arr1, arr2));
            System.out.println("Boolean estaOrdenado (Secuencial): " + Funciones.estaOrdenado(arr1));
            System.out.println("Boolean estaOrdenado (Concurrente): " + Funciones.estaOrdenado(arr2));
            System.out.println();
        
    }
}

