//Codigo basado en el siguiente enlace: https://www.geeksforgeeks.org/quick-sort-using-multi-threading/

package algoritmos.concurrente;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

import datos.PivotStrategy;

public class QuickSortConcurrente
        extends RecursiveTask<Integer> {
    int start, end;
    int[] arr;
    private PivotStrategy strategy;

    /**
     * Finding random pivoted and partition
     * array on a pivot.
     * There are many different
     * partitioning algorithms.
     * @param start
     * @param end
     * @param arr
     * @return
     */
    private int partition(int start, int end,
                          int[] arr)
    {

        int i = start, j = end;

        // Elige un pivote random
        int pivoted = choosePivot(start, end, arr, strategy);

        // Intercambia "pivoted" (la posicion donde 
        // quedo el pivot en la iteracion anterior) con el ultimo
        // elemento del arreglo
        
        //El pivote pasa a ocupar la ultima posicion del arreglo
        int t = arr[j];
        arr[j] = arr[pivoted];
        arr[pivoted] = t;
        
        //Se decrementa el valor de j, ya que j vendria siendo la posicion
        //del ultimo elemento de la lista, que en nuestro caso va a ser el
        //pivote. El pivote debe ser excluido de las siguientes operaciones
        //que se realizaran
        j--;

        // Empieza a "particionar" mientras i y j no se "choquen"
        while (i <= j) {
        //En QuickSort, se elige un pivote y a la derecha del pivote
        //se van colocando los valores mayores al pivote y por la izquierda
        //se colocan los valores menores al pivote
        
        	
        //Con esta condicion se chequea si el elemento inicial de la izquierda
        //es menor o igual al elemento pivote que en este caso es el elemento
        //final del arreglo. Si se cumple la condicion, el iterador sigue avanzando
        //sin hacer nada ya que se considera que el elemento esta correctamente 
        //ubicado
             if (arr[i] <= arr[end]) {
                i++;
                continue;
            }
             
             
        //Chequea lo mismo que la primera condicion, pero en un sentido diferente.
        //Verifica si los elementos de la derecha son mayores o iguales al pivote.
        //Si cumplen con la condicion, el iterador se decrementa (avanza a su manera)
        //sin hacer nada mas.
            if (arr[j] >= arr[end]) {
                j--;
                continue;
            }
            
        //Si alguna o ninguna de las dos condiciones se cumplen, (se encuentra un valor mayor a pivote
        // a la izquierda o un valor menor a pivote a su derecha), se realiza un intercambio;
        //el valor en posicion i cambia de lugar con el valor en posicion j
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            j--;
            i++;
        }

        // Este intercambio final sucede entre el ultimo valor del ciclo while anterior
        // y el pivote. Durante el while se evito mover a pivote de su posicion y este 
        //ultimo swap justamente mueve a pivote a la posicion que le corresponde
        
        t = arr[j + 1];
        arr[j + 1] = arr[end];
        arr[end] = t;
        
        
        //Finalmente, la funcion partition retorna la posicion del ultimo
        //valor trabajado en el ciclo while + 1 para no volver a trabajar sobre
        //el mismo valor de vuelta
        return j + 1;
    }

    // Funcion para implementar
    // metodo QuickSort
    public QuickSortConcurrente(int start,
                                   int end,
                                   int[] arr, PivotStrategy strategy)
    {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.strategy = strategy;
    }

        public QuickSortConcurrente(int start,
                                   int end,
                                   int[] arr)
    {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    
    protected Integer compute()
    {
        // Caso base (los indices de principio y fin se "chocan" o superponen;
    	//no tendria sentido trabajar sobre esto
        if (start >= end)
            return null;

        // Encuentra la particion
        int p = partition(start, end, arr);

        // Divide el arreglo
        
        //Hace las operaciones
        
        //Crea dos objetos "QuickSortConcurrente" para hacer las
        //operaciones tanto a la izquierda como a la derecha del
        //pivote (por eso -1 para la izquierda del pivote y +1 
        //para la derecha del pivote); excluye al pivote en si de
        //toda esta operacion dividiendolo en dos partes
        
        QuickSortConcurrente left
                = new QuickSortConcurrente(start,
                p - 1,
                arr, strategy);

        QuickSortConcurrente right
                = new QuickSortConcurrente(p + 1,
                end,
                arr,  strategy);

        // left corre este mismo algoritmo en un hilo aparte
        left.fork();
        
        //right corre este mismo algoritmo recursivamente
        //en el hilo principal
        right.compute();

        // Esperamos a que el hilo en que se esta ejecutando
        //"left" termine
        left.join();
        
        
        //Se obtiene el nombre de cada hilo e imprimo un mensaje
        //Esto solo lo hago para probar que realmente los dos hilos
        //se terminan de ejecutar en tiempos diferentes

        // No queremos que retorne nada
        return null;
    }

    private int generateRandomPivot(){
        return new Random().nextInt(end - start + 1) + start;
    }

    private int choosePivot(int start, int end, int[] arr, PivotStrategy strategy) {
    switch (strategy) {
        case FIRST:
            return start; // Elige el primer elemento como pivote
        case LAST:
            return end; // Elige el último elemento como pivote
        case MEDIAN:
            int mid = start + (end - start) / 2;
            int a = arr[start], b = arr[mid], c = arr[end];
            // Devuelve el índice de la mediana de tres
            if ((a > b) != (a > c)) return start;
            else if ((b > a) != (b > c)) return mid;
            else return end;
        case RANDOM:
        default:
            return generateRandomPivot();
    }
  }
}
