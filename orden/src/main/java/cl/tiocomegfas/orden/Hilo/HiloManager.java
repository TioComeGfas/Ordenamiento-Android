package cl.tiocomegfas.orden.Hilo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cl.tiocomegfas.orden.Algortimos.BubbleSort;
import cl.tiocomegfas.orden.Algortimos.CountingSort;
import cl.tiocomegfas.orden.Algortimos.InsertionSort;
import cl.tiocomegfas.orden.Algortimos.MergeSort;
import cl.tiocomegfas.orden.Algortimos.QuickSort;
import cl.tiocomegfas.orden.Algortimos.SelectionSort;
import cl.tiocomegfas.orden.Excepciones.CodigoErrorHilo;
import cl.tiocomegfas.orden.Excepciones.OrdenException;
import cl.tiocomegfas.orden.Hilo.Escuchadores.BubbleSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.CountingSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.InsertionSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.MergeSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.QuickSortListener;
import cl.tiocomegfas.orden.Hilo.Escuchadores.SelectionSortListener;
import cl.tiocomegfas.orden.Interfaces.AccionesHilo;

public class HiloManager<T extends Comparable<T>> implements Runnable, AccionesHilo, CodigoErrorHilo {

    /**
     * Instancia del hilo que representa a esta clase
     */
    private Thread hilo;

    /**
     *  Esta variable almacena la accion que debe realizar el hilo
     */
    private Integer accion;

    /**
     * Esta variables se utiliza para informar si el usuario desea ordenar de forma ascendente o descendente
     */
    private Integer tipo;

    /**
     * Este es el arreglo que contiene la informacion a ordenar
     */
    private T[] arreglo;


    /**
     * Esta interfaz es un escuchador para cuando el usuario desee ordenar el arreglo con el metodo bubble sort
     */
    @Nullable
    private BubbleSortListener bubbleListener;

    @Nullable
    private CountingSortListener countingListener;

    @Nullable
    private InsertionSortListener insertionListener;

    @Nullable
    private MergeSortListener mergeListener;

    @Nullable
    private QuickSortListener quickListener;

    private SelectionSortListener selectionListener;

    /**
     * Constructor de la clase Hilo Manager
     * @param metodo el metodo a ordenar
     */
    public HiloManager(int metodo){
        this.accion = metodo;
        this.tipo = TIPO_ORDENAMIENTO_SIN_APLICAR;
        this.arreglo = null;
        this.hilo = new Thread(this);

        bubbleListener = null;
        countingListener = null;
        insertionListener = null;
        mergeListener = null;
        quickListener = null;
    }

    @Override
    public void run() throws OrdenException{

        if(accion == -1) throw new OrdenException(ERROR_ACCION_ES_NULA);
        if(tipo == TIPO_ORDENAMIENTO_SIN_APLICAR) throw new OrdenException(ERROR_TIPO_ES_NULO);
        if(arreglo == null || arreglo.length < 2) throw new OrdenException(ERROR_ARREGLO_INVALIDO);

        try{

            switch (accion){
                case APLICAR_METODO_BUBBLE_SORT:{
                    if(bubbleListener == null) throw new OrdenException(ERROR_BUBBLE_SORT_LISTENER_NULO);

                    BubbleSort.aplicar(tipo,arreglo);
                    bubbleListener.onListo(arreglo);
                    break;
                }case APLICAR_METODO_COUNTING_SORT:{
                    if(countingListener == null) throw new OrdenException(ERROR_COUNTING_SORT_LISTENER_NULO);

                    CountingSort.aplicar(tipo,arreglo);
                    countingListener.onListo(arreglo);
                    break;
                }case APLICAR_METODO_INSERTION_SORT:{
                    if(insertionListener == null) throw new OrdenException(ERROR_INSERTION_SORT_LISTENER_NULO);

                    InsertionSort.aplicar(tipo,arreglo);
                    insertionListener.onListo(arreglo);
                    break;
                }case APLICAR_METODO_MERGE_SORT:{
                    if(mergeListener == null) throw new OrdenException(ERROR_MERGE_SORT_LISTENER_NULO);

                    MergeSort.aplicar(tipo,arreglo);
                    mergeListener.onListo(arreglo);
                    break;
                }case APLICAR_METODO_QUICK_SORT:{
                    if(quickListener == null) throw new OrdenException(ERROR_QUICK_SORT_LISTENER_NULO);

                    QuickSort.aplicar(tipo, arreglo);
                    quickListener.onListo(arreglo);
                    break;
                }case APLICAR_METODO_SELECTION_SORT:{
                    if(selectionListener == null) throw new OrdenException(ERROR_SELECTION_SORT_LISTENER_NULO);

                    SelectionSort.aplicar(tipo,arreglo);
                    selectionListener.onListo(arreglo);
                    break;
                }
            }
        }catch (OrdenException o){
            if(accion == APLICAR_METODO_BUBBLE_SORT) bubbleListener.onError(o.getMessage()); //la aplicacion debe romperse

        }
    }

    /**
     * Este metodo lanza el hilo para ordenar
     */
    public void iniciar(){
        hilo.start();
    }

    /**
     * Configuracion del hilo para ordenar el arreglo con el metodo bubble sort
     * @param tipo ascendente o descente
     * @param listener El escuchado donde se comunicara con la interfaz de usuario
     */
    public void configurarBubbleSort(int tipo,@NonNull BubbleSortListener listener){
        this.tipo = tipo;
        this.bubbleListener = listener;
    }

    public void configurarCountingSort(int tipo,@NonNull CountingSortListener listener){
        this.tipo = tipo;
        this.countingListener = listener;
    }

    public void configurarInsertionSort(int tipo, @NonNull InsertionSortListener listener){
        this.tipo = tipo;
        this.insertionListener = listener;
    }

    public void configurarMergeSort(int tipo, @NonNull MergeSortListener listener){
        this.tipo = tipo;
        this.mergeListener = listener;
    }

    public void configurarQuickSort(int tipo, @NonNull QuickSortListener listener){
        this.tipo = tipo;
        this.quickListener = listener;
    }

    public void configurarSelectionSort(int tipo, @NonNull SelectionSortListener listener){
        this.tipo = tipo;
        this.selectionListener = listener;
    }


}
