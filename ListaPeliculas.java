
public class ListaPeliculas
{
    // instance variables - replace the example below with your own
    String nombreFiltrado;//
    Pelicula pelicula;
    ListaPeliculas peliculaDerecha;
    /**
     * Constructor for objects of class ListaPeliculas
     */
    public ListaPeliculas(String nombreFiltrado)
    {
        // initialise instance variables
        nombreFiltrado = nombreFiltrado;

        pelicula = null;
        peliculaDerecha = null;
    }

    public void muestre()
    {
        pelicula.muestre();
        if(peliculaDerecha != null)
        {
            peliculaDerecha.muestre();
        }
        
    }

    public void agregue(Pelicula peli)
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

}
