package algoritmos.secuencial;

public class QuickSortSecuencial {
    public static int partition(int[] a, int low, int high)
    {
        int pivot = a[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {

            //chequea si el elemento es menor o igual a pivot
            if (a[j] <= pivot)
            {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }


    /* La funcion principal que implementa QuickSort()
        a[] --> Array a ordenar,
        l --> el indice de inicio
        h --> el indice final
     */
    public static void quickSort(int[] a, int l, int h)
    {
        if (l < h)
        {
            int pi = partition(a, l, h);
            // ordena los elementos recursivamentes antes
            // de "partition" y despues de "partition"
            quickSort(a, l, pi-1);
            quickSort(a, pi+1, h);
        }
    }

}