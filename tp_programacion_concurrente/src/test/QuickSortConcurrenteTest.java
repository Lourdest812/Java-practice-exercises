package test;

import algoritmos.concurrente.QuickSortConcurrente;
import java.util.concurrent.ForkJoinPool;
import org.junit.Test;
import static org.junit.Assert.*;


public class QuickSortConcurrenteTest {

    @Test
    public void testQuickSortConcurrente() {
        int[] arr = {5, 3, 8, 4, 2};
        int[] expected = {2, 3, 4, 5, 8};
        ForkJoinPool.commonPool().invoke(
            new QuickSortConcurrente(0, arr.length - 1, arr, null)
        );
        assertArrayEquals(expected, arr);
    }
    
    @Test
    public void testQuickSortConcurrenteIfEmpty() {
        int[] arr = {};
        int[] expected = {};
        ForkJoinPool.commonPool().invoke(
            new QuickSortConcurrente(0, arr.length - 1, arr, null)
        );
        assertArrayEquals(expected, arr);
    }
}

