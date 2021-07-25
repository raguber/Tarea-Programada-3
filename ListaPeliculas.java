/**
 * Clase ListaPeliculas, la cual crea una lista de peliculas para el arbol de categorias, de cast, de tipo y de pais de procedencia.
 * 
 * @author Randy Agüero B90082, Frayvin Alvarado B60292 y Andrés Serrano C07483
 * @version 24/7/2021
 */
public class ListaPeliculas
{
     //Campos de la clase
    String nombreFiltrado;//
    Pelicula pelicula;
    ListaPeliculas peliculaDerecha;
    /**
     * Constructor for objects of class ListaPeliculas
     */
    public ListaPeliculas(String nombreFilt)
    {
        nombreFiltrado = nombreFilt;
        pelicula = null;
        peliculaDerecha = null;
    }//Cierre del constructor
    
    /**
     * METODOS
    */
   
    /**Muestra las peliculas en la lista
     *
     */
    public void muestre()
    {
        pelicula.muestre();
        if(peliculaDerecha == null)
        {
            System.out.println("No mas peliculas \n");
        }
        else
        {
            peliculaDerecha.muestre();
        }
    }
    
    /**Muestra las peliculas en la lista
     *
     */
    public void muestreNombreFiltrado()
    {
        System.out.println("TipoFiltrado *"+nombreFiltrado+"*");
    }
    
    /**Agrega la pelicula a esta lista de peliculas
     *@param pelicula, la cual se va a agregar a la lista
     */
    public void agregue(Pelicula peli)
    {
        if((pelicula != peli))
        {
            if(pelicula == null)
            {
                pelicula = peli;
            }
            else
            {
                if(peliculaDerecha == null)
                {
                    peliculaDerecha =  new ListaPeliculas(nombreFiltrado);
                }
                peliculaDerecha.agregue(peli);
            }
        }
        else
        {
        }
    }
    
    public static void main(String args[])
    {
        System.out.println("+"+"hola");
    }
    //Cierre de la clase
}
