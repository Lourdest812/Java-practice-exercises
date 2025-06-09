package test;

import datos.PivotStrategy;
import funciones.Funciones;
import java.util.Arrays;

public class TestExcepcionesQuickSort {
    public static void main(String[] args) {
        int[][] casos = {
            null,                          // Array nulo
            new int[10000],                // Todos ceros (iguales)
            generarArrayIguales(10000, 42) // Todos iguales (valor 42)
        };

        for (int i = 0; i < casos.length; i++) {
            int[] arr = casos[i];
            System.out.println("\nCaso " + i); 
            for (PivotStrategy strategy : PivotStrategy.values()) {
                int[] arrCopy = arr == null ? null : Arrays.copyOf(arr, arr.length);
                System.out.print("Estrategia " + strategy + ": ");
                try {
                    Funciones.calcularTiempoConcurrente(arrCopy, strategy);
                    System.out.println("OK");
                } catch (StackOverflowError e) {
                    System.out.println("StackOverflowError");
                } catch (OutOfMemoryError e) {
                    System.out.println("OutOfMemoryError");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("ArrayIndexOutOfBoundsException");
                } catch (NullPointerException e) {
                    System.out.println("NullPointerException");
                } catch (Exception e) {
                    System.out.println("Otra excepción: " + e.getClass().getSimpleName() + " - " + e.getMessage());
                }
            }
        }
    }

    private static int[] generarArrayIguales(int tam, int valor) {
        int[] arr = new int[tam];
        Arrays.fill(arr, valor);
        return arr;
    }
}