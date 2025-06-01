package test;
import algoritmos.secuencial.QuickSortSecuencial;

import java.util.Arrays;
import java.util.Random;

public class Test {
    private static final int TAM = 15;
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[TAM];

        for(int i=0;i<TAM;i++){
            arr[i] = rand.nextInt(1,100);
        }

        //Muestro el array original
        System.out.println("----------------------ARRAY ORIGINAL-------------------------");
        System.out.println(Arrays.toString(arr));

        QuickSortSecuencial.quickSort(arr, 0, TAM-1);

        System.out.println();
        //Muestro el array ordenado
        System.out.println("----------------------ARRAY ORDENADO-------------------------");
        System.out.println(Arrays.toString(arr));
    }
}
