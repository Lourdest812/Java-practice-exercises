# QuickSort Secuencial y Concurrente en Java

Este proyecto compara la implementación secuencial y concurrente del algoritmo QuickSort en Java, permitiendo elegir distintas estrategias de pivote (primero, último, mediana, aleatorio). Incluye tests de rendimiento y manejo de excepciones.

## Estructura

- **src/algoritmos/secuencial/**: QuickSort secuencial.
- **src/algoritmos/concurrente/**: QuickSort concurrente usando Fork/Join y estrategias de pivote.
- **src/test/**: Pruebas de rendimiento, estrategias y manejo de excepciones.

## Ejecución

1. Clona el repositorio.
2. Compila el proyecto con tu IDE o desde terminal.
3. Ejecuta las clases de test en `src/test` para ver resultados y comparativas.

## Ejemplo de uso

```java
// Probar todas las estrategias de pivote con un array aleatorio
for (PivotStrategy strategy : PivotStrategy.values()) {
    int[] arr = Funciones.generarArrayAleatorio(10000);
    Funciones.calcularTiempoConcurrente(arr, strategy);
}
```

## Especificaciones del entorno

- **Sistema operativo:** Windows 10 64-bit
- **Procesador:** Intel(R) Core(TM) i3-10100F CPU @ 3.60Hz
- **Memoria RAM:** 16 GB
- **Versión de Java:** java version "18.0.1.1"
- **IDE:** Visual Studio Code / Eclipse

## Pruebas de excepciones

El proyecto incluye tests para detectar excepciones comunes como:
- StackOverflowError
- NullPointerException

## Créditos

- Basado en los ejemplos de GeeksForGeeks  
  - Algoritmo secuencial: https://www.geeksforgeeks.org/java-program-for-quicksort/  
  - Algoritmo concurrente: https://www.geeksforgeeks.org/quick-sort-using-multi-threading/

---
