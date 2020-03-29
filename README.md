[![](https://jitpack.io/v/TioComeGfas/Ordenamiento-Android.svg)](https://jitpack.io/#TioComeGfas/Ordenamiento-Android)


# Order
Esta pequeña libreria incluye un hilo que realiza el orden, para evitar al programador ensuciar su proyecto, dejando asi un codigo mas limpio al momento de integrar esta libreria a su proyecto.

# Clases Utiles

+ HiloManager: Hilo encargado de manejar todo el proceso de ordenamiento

+ BubbleSortListener : Escuchador para utilizar BubbleSort
+ CountingSortListener: Escuchador para utilizar CountingSort
+ InsertionSortListener: Escuchador para utilizar InsertionSort
+ MergeSortListener: Escuchador para utilizar MergeSort
+ QuickSortListener: Escuchador par utilizar QuickSort
+ SelectionSortListener: Escuchador para utilizar SelectionSort

# Implementacion:

+   Para poder ordenar ojetos, se debe configurar cada instancia que se desea ordenar, para este ejemplo tengo una clase Persona que implementa la interface Comparable<Persona>
  
```Java
public class Persona implements Comparable<Persona> {

    private int id;
    private String nombre;

    public Persona(int id, String nombre){...}

    // GETTER Y SETTER

    @Override
    public int compareTo(Persona persona) {
        if(this.id == persona.id) return 0;
        else if(this.id > persona.id) return 1;
        else return -1;
    }
}
```
El metodo compareTo(...) se debe configurar de la siguiente manera:
  + si A == B entonces debes retornar 0
  + Si A > B entonces debes retornar 1
  + Si A < B entonces debes retornar -1

+ Suponiendo que estas en una actividad o fragmento:
```Java
public class MainActivity extends Activity{
  
  //todo lo relacionado a la actividad
  ...

  BubbleSortListener listener = new BubbleSortListener() {
            @Override
            public <T> void onListo(T[] arreglo) {
              // este metodo sera utilizado para informar que el hilo concluyo su labor
              // El arreglo T viene toda la informacion ordenada
              
                for(Persona p: (Persona[]) arreglo){
                    System.out.println(p.toString());
                }
            }

            @Override
            public void onError(String error) {
                // este metodo sera utilizado para informar que ocurrio un problema al realizar la labor
                // El String error trae el mensaje de error
                System.out.println("Error: "+error);
            }
        };
}
```
Una vez tengamos configurada el Objeto y creado es escuchador nos disponemos a lanzar el hilo

```Java
  
  Persona p1 = new Persona(1,"Fredy");
  Persona p2 = new Persona(100,"Camilo");
  Persona p3 = new Persona(50,"Felipe");
  Persona p4 = new Persona(15,"Antonio");
  
  Persona[] arreglo = {p1,p2,p3,p4};
  
  HiloManager hilo = new HiloManager(AccionesHilo.APLICAR_METODO_BUBBLE_SORT);
  hilo.configurarBubbleSort(AccionesHilo.TIPO_ORDENAMIENTO_ASCENDENTE,arreglo,listener);
  hilo.iniciar(); // da inicio al hilo para iniciar
 
  // Como se puede ver se requiere crear una instancia de HiloManager, 
  // el cual es el encargado de manejar el hilo y procesar el arreglo 
  // segun el metodo que haya seleccionado el usuario
  
  // Como parametros al crear la instancia necesita identificar que algoritmo utilizara,
  // para esto disponde de la interface AccionesHilo, la cual contiene el numero 
  // que se identifica dentro del hilo.
  // Tambien requiere definir si lo va a ordenar de forma ascentente o descendente,
  // el arreglo a ordenar y el escuchador.
  
  // Una vez terminado el proceso retornara por el escuchador, si concluyo 
  // correctamente informara por el onListo(...) y si     
  // ocurrio un problema por onError()
```

# Gradle
Agréguelo en su raíz build.gradle al final de los repositorios:
```Gradle
allprojects {
   repositories {
     maven { url 'https://jitpack.io' }
     }
}
```
Agregar la dependencia
```Gradle
dependencies {
    implementation 'com.github.TioComeGfas:Ordenamiento-Android:1.0'
}
```



