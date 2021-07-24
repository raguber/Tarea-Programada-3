
public class ListaPeliculas
{
    // instance variables - replace the example below with your own
    String nombreFiltrado;//
    Pelicula pelicula;
    ListaPeliculas peliculaDerecha;
    /**
     * Constructor for objects of class ListaPeliculas
     */
    public ListaPeliculas(String nombreFilt)
    {
        // initialise instance variables
        nombreFiltrado = nombreFilt;
        System.out.println("nom "+nombreFiltrado);

        pelicula = null;
        peliculaDerecha = null;
    }

    public void muestre()
    {
        pelicula.muestre();
        System.out.println(peliculaDerecha+" null");
        if(peliculaDerecha != null)
        {
            peliculaDerecha.muestre();
        }

    }
    public void muestreNombreFiltrado()
    {
        System.out.println("nom "+nombreFiltrado);
    }

    public void agregue(Pelicula peli)
    {
        if(pelicula == null)
        {
            System.out.println("PELO");
            pelicula = peli;
        }
        else
        {
            if(peliculaDerecha == null)
            {
                peliculaDerecha =  new ListaPeliculas(nombreFiltrado);
                System.out.println("edecaha"+nombreFiltrado);
                peliculaDerecha.agregue(peli);
            }
            else
            {
                peliculaDerecha.agregue(peli);
            }
        }
    }
    public static void main(String args[])
    {
        System.out.println("+"+"hola");
    }

}
