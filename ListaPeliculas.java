
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

        pelicula = null;
        peliculaDerecha = null;
    }

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

    public void muestreNombreFiltrado()
    {
        System.out.println("Categoria *"+nombreFiltrado+"*");
    }

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

                    peliculaDerecha.agregue(peli);
                }
                else
                {
                    peliculaDerecha.agregue(peli);
                }
            }
        }
        else
        {
            System.out.println("La pelicula ya existe");
        }
    }

    public static void main(String args[])
    {
        System.out.println("+"+"hola");
    }

}
