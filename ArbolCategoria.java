
/**
 * Write a description of class Arbol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

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
public class ArbolCategoria{
    ArbolCategoria()
    {

    }

    public void busqueCategoria(String cat)
    {
        String categoria = cat;
        categoria = categoria.trim();
        int tamanoCategoria = categoria.length();
        String letraAnalizar = categoria.substring(0,0);
        int numLetraAnalizar = deNumeroLetra (letraAnalizar);
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

    }

    public void agregueCategoria(String cat)
    {

    }

    public int deNumeroLetra(String L)
    {
        int valorLetra = 0;
        L = L.toLowerCase();
        switch (L)
        {
            case "a":
            valorLetra = 1;
            break;
            case "b":
            valorLetra = 2;
            break;
            case "c":
            valorLetra =  3;
            break;
            case "d":
            valorLetra =  4;
            break;
            case "e":
            valorLetra =  5;
            break;
            case "f":
            valorLetra =  6;
            break;
            case "g":
            valorLetra =  7;
            break;
            case "h":
            valorLetra =  8;
            break;
            case "i":
            valorLetra =  9;
            break;
            case "j":
            valorLetra =  10;
            break;
            case "k":
            valorLetra =  11;
            break;
            case "l":
            valorLetra =  12;
            break;
            case "m":
            valorLetra =  13;
            break;
            case "n":
            valorLetra =  14;
            break;
            case "ñ":
            valorLetra =  15;
            break;
            case "o":
            valorLetra =  16;
            break;
            case "p":
            valorLetra =  17;
            break;
            case "q":
            valorLetra = 18;
            break;
            case "r":
            valorLetra = 19;
            break;
            case "s":
            valorLetra = 20;
            break;
            case "t":
            valorLetra = 21;
            break;
            case "u":
            valorLetra = 22;
            break;
            case "v":
            valorLetra = 23;
            break;
            case "w":
            valorLetra = 24;
            break;
            case "x":
            valorLetra = 25;
            break;
            case "y":
            valorLetra = 26;
            break;
            case "z":
            valorLetra = 27;
            break;

        }
        return valorLetra;
    }

    public static void main (String args[])
    {
        ArbolCategoria arbol = new ArbolCategoria();
        String cat = " E Gsdg " ;
        System.out.println("Categoria "+cat); 
        String categoria = cat.trim();
        System.out.println("*"+categoria+"* sin espacios");
        String categoriaDesdeG = categoria.substring(2);
        System.out.println(categoriaDesdeG);
        int tamanoCategoria = categoria.length();
        System.out.println("Tamano categoria "+tamanoCategoria);
        String letraAnalizar = categoria.substring(0,1);
        System.out.println("letra a analizar :"+letraAnalizar);
        String letraAnalizarSinPrimera = categoria.substring(0,1);
        String letraPruebaSimbolosRaros = "*";
        System.out.println("Numero de simbolo *"+arbol.deNumeroLetra(letraPruebaSimbolosRaros));
        letraPruebaSimbolosRaros = "!";
        System.out.println("Numero de simbolo !"+arbol.deNumeroLetra(letraPruebaSimbolosRaros));;
    }

}
