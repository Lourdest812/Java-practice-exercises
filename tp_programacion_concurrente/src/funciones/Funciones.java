package funciones;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import algoritmos.concurrente.QuickSortConcurrente;
import algoritmos.secuencial.QuickSortSecuencial;
import datos.PivotStrategy;

public class Funciones {
	
	public static void ejecutarQuickSortSecuencial(int [] arr) {
		QuickSortSecuencial.quickSort(arr, 0, arr.length - 1);
	}
	
	public static void ejecutarQuickSortConcurrente(int arr[], PivotStrategy strategy) {
		ForkJoinPool pool = ForkJoinPool.commonPool();
		pool.invoke(new QuickSortConcurrente(0, arr.length - 1, arr, strategy));
	}
	
	public static boolean sonIguales(int[]arr1, int [] arr2) {
		return Arrays.equals(arr1, arr2);
	}
    public static double calcularTiempoSecuencial(int[] arr){
        //Uso el metodo nanoTime para calcular cuanto tiempo tardara cada
        //version de QuickSort en nanosegundos
        long startSec = System.nanoTime();
        ejecutarQuickSortSecuencial(arr);
        long endSec = System.nanoTime();
        //formula para convertir los nanosegundos en milisegundos
        return (endSec - startSec) / 1e6;
    }

    public static double calcularTiempoConcurrente(int[] arr, PivotStrategy strategy){
        long startConc = System.nanoTime();
        ejecutarQuickSortConcurrente(arr, strategy);
        long endConc = System.nanoTime();
        return (endConc - startConc) / 1e6;
    }
    //Funcion que genera arrays con valores aleatorios de acuerdo al tamanio deseado
    public static int[] generarArrayAleatorio(int tam) {
    	Random rand = new Random();
    	int[] arr = new int[tam];
    	for (int i = 0; i < tam; i++) {
    		arr[i] = rand.nextInt(1, 1000000);
    	}
    	return arr;
    }

    // Verifica si un array está ordenado de menor a mayor
    public static boolean estaOrdenado(int[] arr) {
    	for (int i = 1; i < arr.length; i++) {
        //retorna false si el elemento en el indice anterior es mayor que al actual
        //si es asi, significa que el array no esta ordenado
    		if (arr[i - 1] > arr[i]) return false;
    }
    //si nunca cumple con la condicion de arriba, retorna true
    	return true;
    }
    
    // Mostrar arrays pequenios
    public static void mostrarArray(int[] arr){
        if(arr.length<20){
            System.out.print(Arrays.toString(arr));
        }else{
        	System.out.println("El array excede los 20 elementos");
            for(int i=0;i<20;i++){
                System.out.print(" " + arr[i] + " ");
            }
        }
    }
}
