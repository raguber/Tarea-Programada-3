

public class ListaPeliculas
{
    // instance variables - replace the example below with your own
    String nombreFiltrado;
    Pelicula pelicula;
    /**
     * Constructor for objects of class ListaPeliculas
     */
    public ListaPeliculas()
    {
        // initialise instance variables
        nombreFiltrado = "";
        
        pelicula = null;
    }
    public void muestre()
    {
        pelicula.muestre();
    }
    public void agregue(Pelicula peli)
    {
        if(pelicula == null)
        {
            pelicula = peli;
        }
        else
        {
            pelicula.agregue(peli);
        }
    }

    
}
