package cl.tiocomegfas.orden;

import org.junit.Test;

import cl.tiocomegfas.orden.Hilo.Escuchadores.BubbleSortListener;
import cl.tiocomegfas.orden.Hilo.HiloManager;
import cl.tiocomegfas.orden.Interfaces.AccionesHilo;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void pruebaMetodoBubbleSort(){


        BubbleSortListener listener = new BubbleSortListener() {
            @Override
            public <T> void onListo(T[] arreglo) {
                for(int i = 0; i < arreglo.length; i++){
                    System.out.println(arreglo[i]);
                }
            }

            @Override
            public void onError(String error) {
                System.out.println("ups, un problema: "+error);
            }
        };


        HiloManager<Integer> hilo = new HiloManager<>(AccionesHilo.APLICAR_METODO_BUBBLE_SORT);
        hilo.configurarBubbleSort(AccionesHilo.TIPO_ORDENAMIENTO_ASCENDENTE,new Integer[] {10,9,8,7,6,5,4,3,2,1},listener);
        hilo.iniciar();
    }

    @Test
    public void addition_isCorrect() {
        //assertEquals(4, 2 + 2);

    }
}