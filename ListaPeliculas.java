

public class ListaPeliculas
{
    // instance variables - replace the example below with your own
    String categoria;
    Pelicula pelicula;
    Pelicula peliculaSiguiente;
    /**
     * Constructor for objects of class ListaPeliculas
     */
    public ListaPeliculas()
    {
        // initialise instance variables
        categoria = "";
        peliculaSiguiente = null;
        pelicula = null;
    }
    public void muestre()
    {
        pelicula.muestre();
        if(peliculaSiguiente != null)
        {
            peliculaSiguiente.muestre();
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
            if(peliculaSiguiente==null)
            {
                peliculaSiguiente = peli;
            }
            else
            {
                peliculaSiguiente.agregue(peli);
            }
        }
    }

    
}
