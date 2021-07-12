/**
 * Write a description of class Pelicula here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pelicula
{
    //Instancias
    private Pelicula p;
    String show_id;
    String tipo;
    String titulo;
    String director;
    String cast; //Podria ser un arbol
    String pais;
    String fecha;
    String anio;
    String audiencia;
    String duracion;
    String categoria; //Hacer una lista dinamica o arbol
    String descripcion;
    /**
     * CONSTRUCTOR
     */
    public Pelicula(String v)
    {
        String l[]=v.split(";");
        show_id=l[0];
        tipo=l[1];
        titulo=l[2];
        director=l[3];
        cast=l[4];
        pais=l[5];
        fecha=l[6];
        anio=l[7];
        audiencia=l[8];
        duracion=l[9];
        categoria=l[10];
        descripcion=l[11];        
    }

    /**
     * METODOS
     */
    public String getShow_id()
    {
        return show_id;
    }
    
    public String getTipo()
    {
        return show_id;
    }
    
    public String getTitulo()
    {
        return titulo;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public String getCast()
    {
        return cast;
    }
    
    public String getPais()
    {
        return pais;
    }
    
    public String getFecha()
    {
        return fecha;
    }
    
    public String getAnio()
    {
        return anio;
    }
    
    public String getAudiencia()
    {
        return audiencia;
    }
    
    public String getDuracion()
    {
        return duracion;
    }
    
    public String getCategoria()
    {
        return categoria;
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
}
