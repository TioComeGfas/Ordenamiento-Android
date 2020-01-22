package cl.tiocomegfas.modelo;

import cl.tiocomegfas.orden.Hilo.Escuchadores.BubbleSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.CountingSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.InsertionSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.MergeSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.QuickSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.SelectionSortListener;
import cl.tiocomegfas.orden.Hilo.HiloManager;
import cl.tiocomegfas.orden.Interfaces.AccionesHilo;

public class Sistema {

    public static void main(String[] args) {

        Persona persona = new Persona(10,"Fredy");
        Persona persona1 = new Persona(100,"Camilo");
        Persona persona2 = new Persona(50,"Moncada");
        Persona persona3 = new Persona(1,"Contreras");

        Persona[] arreglo = {persona,persona1,persona2,persona3};

        try{
            System.out.println("Ordenando metodo Bubble Sort");
            ordenarBubbleSort(arreglo);
            System.out.println();

            System.out.println("Ordenando metodo Counting Sort");
            ordenarCountingSort(arreglo);
            System.out.println();

            System.out.println("Ordenando metodo Insertion Sort");
            ordenarInsertionSort(arreglo);
            System.out.println();

            System.out.println("Ordenando metodo Merge Sort");
            ordenarMergeSort(arreglo);
            System.out.println();

            System.out.println("Ordenando metodo Quick Sort");
            ordenarQuickSort(arreglo);
            System.out.println();

            System.out.println("Ordenando metodo Selection Sort");
            ordenarSelectionSort(arreglo);
            System.out.println();

        }catch(InterruptedException ignored){}
    }


    private static <T extends Comparable<T>> void ordenarBubbleSort(T[] arreglo) throws InterruptedException {

        BubbleSortListener listener = new BubbleSortListener() {
            @Override
            public <T> void onListo(T[] arreglo) {
                for(Persona p: (Persona[]) arreglo){
                    System.out.println(p.toString());
                }
            }

            @Override
            public void onError(String error) {
                System.out.println("Error: "+error);
            }
        };

        HiloManager hilo = new HiloManager(AccionesHilo.APLICAR_METODO_BUBBLE_SORT);
        hilo.configurarBubbleSort(AccionesHilo.TIPO_ORDENAMIENTO_ASCENDENTE,arreglo,listener);

        hilo.iniciar();

        hilo.obtener().join();

    }

    private static <T extends Comparable<T>> void ordenarCountingSort(T[] arreglo) throws InterruptedException {


        CountingSortListener listener = new CountingSortListener() {
            @Override
            public <T> void onListo(T[] arreglo) {
                for(Persona p: (Persona[]) arreglo){
                    System.out.println(p.toString());
                }
            }

            @Override
            public void onError(String error) {
                System.out.println("Error: "+error);
            }
        };

        HiloManager hilo = new HiloManager(AccionesHilo.APLICAR_METODO_COUNTING_SORT);
        hilo.configurarCountingSort(AccionesHilo.TIPO_ORDENAMIENTO_DESCENDENTE,arreglo,listener);

        hilo.iniciar();
        hilo.obtener().join();

    }

    private static <T extends Comparable<T>> void ordenarInsertionSort(T[] arreglo) throws InterruptedException{

        InsertionSortListener listener = new InsertionSortListener() {
            @Override
            public <T> void onListo(T[] arreglo) {
                for(Persona p: (Persona[]) arreglo){
                    System.out.println(p.toString());
                }
            }

            @Override
            public void onError(String error) {
                System.out.println("Error: "+error);
            }
        };

        HiloManager hilo = new HiloManager(AccionesHilo.APLICAR_METODO_INSERTION_SORT);
        hilo.configurarInsertionSort(AccionesHilo.TIPO_ORDENAMIENTO_DESCENDENTE,arreglo,listener);

        hilo.iniciar();
        hilo.obtener().join();
    }


    private static <T extends Comparable<T>> void ordenarMergeSort(T[] arreglo) throws InterruptedException{

        MergeSortListener listener = new MergeSortListener() {
            @Override
            public <T> void onListo(T[] arreglo) {
                for(Persona p: (Persona[]) arreglo){
                    System.out.println(p.toString());
                }
            }

            @Override
            public void onError(String error) {
                System.out.println("Error: "+error);
            }
        };

        HiloManager hilo = new HiloManager(AccionesHilo.APLICAR_METODO_MERGE_SORT);
        hilo.configurarMergeSort(AccionesHilo.TIPO_ORDENAMIENTO_DESCENDENTE,arreglo,listener);

        hilo.iniciar();
        hilo.obtener().join();

    }

    private static <T extends Comparable<T>> void ordenarQuickSort(T[] arreglo) throws InterruptedException{

        QuickSortListener listener = new QuickSortListener() {
            @Override
            public <T> void onListo(T[] arreglo) {
                for(Persona p: (Persona[]) arreglo){
                    System.out.println(p.toString());
                }
            }

            @Override
            public void onError(String error) {
                System.out.println("Error: "+error);
            }
        };

        HiloManager hilo = new HiloManager(AccionesHilo.APLICAR_METODO_QUICK_SORT);
        hilo.configurarQuickSort(AccionesHilo.TIPO_ORDENAMIENTO_DESCENDENTE,arreglo,listener);

        hilo.iniciar();
        hilo.obtener().join();

    }

    private static <T extends Comparable<T>> void ordenarSelectionSort(T[] arreglo) throws InterruptedException {

        SelectionSortListener listener = new SelectionSortListener() {
            @Override
            public <T> void onListo(T[] arreglo) {
                for(Persona p: (Persona[]) arreglo){
                    System.out.println(p.toString());
                }
            }

            @Override
            public void onError(String error) {
                System.out.println("Error: "+error);
            }
        };

        HiloManager hilo = new HiloManager(AccionesHilo.APLICAR_METODO_SELECTION_SORT);
        hilo.configurarSelectionSort(AccionesHilo.TIPO_ORDENAMIENTO_DESCENDENTE,arreglo,listener);

        hilo.iniciar();
        hilo.obtener().join();
    }

}
