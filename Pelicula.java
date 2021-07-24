/**
 * Clase Pelicula, la cual descompone cada hilera en objetos pelicula con sus 
 * respectivos atributos.
 * 
 * @author Randy Agüero B90082, Frayvin Alvarado B60292 y Andrés Serrano C07483
 * @version 23/7/2021
 */
public class Pelicula
{
    //Instancias
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
        
        ///////////////////////////////////////////////////////////////////////////
        // Pelicula.show_id = show_id_nuevo; 
       /**
        int pos = v.indexOf(";");
        show_id=v.substring(0,pos);//ABC;DEF;GHI
        v=v.substring(pos+1,v.length());//DEF;GHI
        
        pos = v.indexOf(";");
        tipo=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        titulo=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        director=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        cast=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        pais=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        fecha=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        anio=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        audiencia=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        duracion=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        categoria=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        
        pos = v.indexOf(";");
        descripcion=v.substring(0,pos);
        v=v.substring(pos+1,v.length());
        */
       
       
        /**
         * agreguePelicula(categoria,pelicual):
         */
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
    public void agregue(Pelicula peli)
    {
    
    }
    public static void main(String args[])
    {
        Pelicula peli =  new Pelicula("ads","das","sda","asdf"," Antonido Banderas, Miguel Bose, Carlos ","pi","fas","e2","dsfad","safdsadf","Horror movies, Drama, Independet shows","fasdfd");
        
        System.out.println("*"+peli.getCategoria()+"*");
    }
  
}
