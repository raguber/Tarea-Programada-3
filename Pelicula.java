/**
 * Clase Pelicula, la cual descompone cada hilera en objetos pelicula con sus 
 * respectivos atributos.
 * 
 * @author Randy Agüero B90082, Frayvin Alvarado B60292 y Andrés Serrano C07483
 * @version 24/7/2021
 */
public class Pelicula
{
     //Campos de la clase
    private Pelicula p;
    Pelicula next;
    String show_id;
    String tipo;
    String titulo;
    String director;
    String cast;
    String pais;
    String fecha;
    String anio;
    String audiencia;
    String duracion;
    String categoria;
    String descripcion;
    /**
     * CONSTRUCTOR
     */
    public Pelicula(String elShow_id, String elTipo, String elTitulo, String elDirector, String elCast, String elPais, String laFecha, String elAnio,
    String laAudiencia, String laDuracion, String lasCategorias, String laDescripcion)
    {
       show_id=elShow_id;
       tipo=elTipo;
       titulo=elTitulo;
       director=elDirector;
       cast=elCast;
       pais=elPais;
       fecha=laFecha;
       anio=elAnio;
       audiencia=laAudiencia;
       duracion=laDuracion;
       categoria=lasCategorias; 
       descripcion=laDescripcion;
    }//Cierre del constructor
    
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
        String tipoProcesada = tipo;
        tipoProcesada = tipoProcesada.replace('"',' ');
        tipoProcesada = tipoProcesada.trim();
        tipoProcesada = tipoProcesada.replaceAll(", ",",");
        tipoProcesada = tipoProcesada.trim();
        return tipoProcesada;
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
       String castProcesado = cast;
        castProcesado = castProcesado.replace('"',' ');
        castProcesado = castProcesado.trim();
        castProcesado = castProcesado.replaceAll(", ",",");
        castProcesado = castProcesado.trim();
       return castProcesado;
    }
    
    /** Devuelve un String con el país del show
    * @return pais
    */
    public String getPais()
        {
        String paisProcesada = pais;
        paisProcesada = paisProcesada.replace('"',' ');
        paisProcesada = paisProcesada.trim();
        paisProcesada = paisProcesada.replaceAll(", ",",");
        paisProcesada = paisProcesada.trim();
        return paisProcesada;
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
        String catProcesada = categoria;
        catProcesada = catProcesada.replace('"',' ');
        catProcesada = catProcesada.trim();
        catProcesada = catProcesada.replaceAll(", ",",");
        catProcesada = catProcesada.trim();
        
        return catProcesada;
    }
    
    /** Devuelve un String con la descripcion del show
    * @return descripcion
    */
    public String getDescripcion()
    {
        return descripcion;
    }
    
    /** Permite modificar el String de categorias
    * @param String newCat (la categoria modificada)
    */
    public void setCategoria(String newCat)
    {
        categoria +=","+newCat;
    }
    
    /** Este metodo imprime todos los valores de la pelicula
    * 
     */
    public void muestre()
    {
        System.out.println("Show id: "+ show_id + " Tipo: "+tipo+" Titulo: "+titulo+" Director: "+director+" Cast: "+cast+" Pais: "+pais+" Fecha: "+fecha+" Anio: "+anio+
        " Audiencia: "+audiencia+" Duracion: "+duracion+" Categoria: "+categoria+" Descripcion: "+descripcion);
    }
    //Cierre de la clase
}
