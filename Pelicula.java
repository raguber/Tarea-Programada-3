/**
 * Clase Pelicula, la cual descompone cada hilera en objetos pelicula con sus 
 * respectivos atributos.
 * 
 * @author Randy Agüero B90082, Frayvin Alvarado B60292 y Andrés Serrano C07483
 * @version 20/7/2021
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
    
    /** Devuelve un String con el identificador del show
    * @return show_id el identificador
    */
    public String getShow_id()
    {
        return show_id;
    }
    
    /** Devuelve un String con el Tipo
    * @return tipo
    */
    public String getTipo()
    {
        return show_id;
    }
    
    /** Devuelve un String con el Titulo o nombre del show
    * @return titulo
    */
    public String getTitulo()
    {
        return titulo;
    }
    
    /** Devuelve un String con el Director del show 
    * @return director
    */
    public String getDirector()
    {
        return director;
    }
    
    /** Devuelve un String con el reparto del show, separados por comas
    * @return cast
    */
    public String getCast()
    {
        return cast;
    }
    
    /** Devuelve un String con el país del show
    * @return pais
    */
    public String getPais()
    {
        return pais;
    }
    
    /** Devuelve un String con la fecha de produccion del show
    * @return fecha
    */
    public String getFecha()
    {
        return fecha;
    }
    
    /** Devuelve un String con el año de produccion del show
    * @return anio
    */
    public String getAnio()
    {
        return anio;
    }
    
    /** Devuelve un String con el numero de audiencia del show
    * @return audiencia
    */
    public String getAudiencia()
    {
        return audiencia;
    }
    
    /** Devuelve un String con la duracion del show
    * @return duracion
    */
    public String getDuracion()
    {
        return duracion;
    }
    
    /** Devuelve un String con las categoria del show, separadas por comas
    * @return categoria
    */
    public String getCategoria()
    {
        return categoria;
    }
    
    /** Devuelve un String con la descripcion del show
    * @return descripcion
    */
    public String getDescripcion()
    {
        return descripcion;
    }
}
