import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.Serializable;

/**
 * @author Randy Agüero B90082 y Andrés Serrano C07483
 * Esta clase se usara para pedir datos al usuario
 */
public class EntradaDatos implements Serializable

{
    /** Boceto busqueda en arbol
     * categoriaABuscar  = 5,7 "EG";
     * tamanoCategoria = categoriaABuscar.length();
     * letra = 5 "e"; **Se analizara letra por letra"
     * contadorLetra = 1; EG tiene dos letras, se empieza por la primera.
     * valor = valor del Nodo; (letra); 
     * if(valor != null)
     *    {
     *    if(valor>letra);//Recordar que los valores estarian ordenados de mayor a menor
     *    {
     *     "Categoria no existente"
     *     **Esto significa que las letra mientras se busco no concordaron
     *    }
     *     else **Valor de la letra menor o igual
     *     {
     *        if(valorLetra=letra)
     *        {
     *         letra = 7;
     *         if(tamanoCategoria=contador);
     *         {
     *             muestrePeliculas (Peliculas podrian mostrarse buscando en una lista de peliculas);
     *         }
     *         else
     *         {
     *         busqueLetra = (letra,contadorLetra++,categoriaABuscar)
     *         }
     *        else
     *        {
     *          ** Si no se encuentra se continua a la derecha;
     *          if(nodoIzquierod = 
     *     }
     *   }
     * }
     * else
     * {
     *  
           "Categoria no existente"**En realidad no existen categorias, o sea arbol vacio
     *  }
     * 
     * 
     */
    public EntradaDatos()
    {

    }
    
    public int pidaNumeroRango(String mensaje,int opcionMaxima, int opcionMinima)
    {
        boolean entradaIncorrecta = true;
        boolean numeroOpcionInvalido = true;
        int opcionElegida = opcionMinima-1;
        //Se pedira mientras el usuario ingrese algo incorrecto, datos, en este caso seran numeros, que representan la eleccion del usuario
        while ((entradaIncorrecta)||(numeroOpcionInvalido))
        {
            try
            {
                System.out.println(mensaje);
                Scanner entradaOpcion = new Scanner(System.in);
                opcionElegida = entradaOpcion.nextInt();

                entradaIncorrecta= false;
            }

            catch(java.util.InputMismatchException ie)
            {
                System.out.println("Error, entrada no valida");
            }

            if ((opcionElegida<opcionMinima)||(opcionElegida>opcionMaxima))
            {
                System.out.println("Debe digitar un numero entero entre "+opcionMinima+" y "+opcionMaxima);
            }
            else
            {
                numeroOpcionInvalido = false;
            }
        }
        return opcionElegida;
    }
    
    

   
    /**
     * Este metodo funciona para pedir un texto, como el nombre
     */
    public String pidaTexto(String mensaje)
    {
        boolean textoIncorrecto = true;
        String texto = ("");
        while(textoIncorrecto)
        {
            System.out.println(mensaje);
            Scanner entradaTexto = new Scanner (System.in);
            String textoTemporal = entradaTexto.nextLine();
            if((textoTemporal.trim()).isEmpty())
            {
                System.out.println("Error, no ha ingresado ningun dato");
            }
            else
            {
                textoIncorrecto = false;

                texto = textoTemporal.trim();
            }
        }

        return texto;
    }
    /**
     * Este metodo funciona para pedir un numero
     * necesita un numero minimo
     */
    public int pidaNumero(String mensaje,int numeroMinimo)
    {
        int numero = 0;
        boolean entradaIncorrecta = true;
        boolean numeroOpcionInvalido = true;
        while ((entradaIncorrecta)||(numeroOpcionInvalido))
        {
            try
            {
                System.out.println(mensaje);
                Scanner entradaNumero = new Scanner(System.in);
                numero = entradaNumero.nextInt();
                entradaIncorrecta= false;
            }
            catch(java.util.InputMismatchException ie)
            {
                System.out.println("Error, Lo ingresado no es un numero entero");
            }
            if ((numero<numeroMinimo))
            {
                System.out.println("Debe digitar un numero entero mayor que "+numeroMinimo);
            }
            else
            {
                numeroOpcionInvalido = false;
            }

        }
        return numero;
    }
    

}
