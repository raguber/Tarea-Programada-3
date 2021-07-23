import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
Clase encargada de leer todas las películas e instanciarlas en objetos Pelicula
 */
public class Lector{
    File movies;
    FileReader fire;
    BufferedReader bure;

    /**
    Constructor. Crea los objetos File necesarios para leer las líneas del documento que contiene las películas.
     */
    public Lector()throws IOException{
        movies=new File("netflix_titles_dep.csv");
        fire=new FileReader(movies);
        bure=new BufferedReader(fire);
    }
    /*********************************************************************
     *                  Administracion de lectura
     * *******************************************************************
     */

    public void readTest()throws IOException{
        String line=bure.readLine();
        for(int i=0;i<10;i++){
            //System.out.println(line+" ");
            //Pelicula p = new Pelicula(line);
            line=bure.readLine();
            String x[] = line.split(";");
            for(int k=0;k<11;k++){
                System.out.print(x[k]+" ");
            }
            System.out.println();
        }

    }

    /**
    Lee e instancia todas las líneas del documento. Con cada línea leída crea un objeto película
     */
    public void lea()throws IOException{
        /**
         //Lector = string;
         *  }
         *  Devuelva categoria=
         *  
            ACction, drama, ciencia
         *  Pelicula peli = new Pelicula(String)
         *  pelicula mandeCategoria;
         *  devuelva=accion; Lector 
        ***************************************
            AgreguePeliculaArbol(peli);
            categogria = peli.getCategoria();
            while(existanLineas)
            }
                substring(0,",");
                categoriaAgregar = categoria[i] ;
               ArbolCategoria.agreguePelicula(categoriaAgregar,Peli);
            }
        ******************************************    
        
        
        
        
        while(line!=null){
        //System.out.println(line+" ");
        /**
         * ID line.splig(";");
         * String categoria ="";
         * while(line.split("j");
         * {
         *    intUltimo = categoria.indexof(";");
         *    salida = substring(
         *    
         *   arbolCategoria.agregue(salidaSplit))
         * categoria += salidaSplita;
         * SalidaSplit = line.split
         *   }
         * 
         */
        String line=bure.readLine();
        while(line!=null){
            //Crear los atributos de la pelicula:
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
            
            //Ir deshilachando la linea:
            int pos = line.indexOf(";");
            show_id=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            tipo=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            titulo=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            director=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            cast=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            pais=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            fecha=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            anio=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            audiencia=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            duracion=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            categoria=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            pos = line.indexOf(";");
            descripcion=line.substring(0,pos);
            line=line.substring(pos+1,line.length());
            
            Pelicula p = new Pelicula(show_id,tipo,titulo,director,cast,pais,fecha,anio,audiencia,duracion,categoria,descripcion);
            
            ///////Imprimir las peliculas:
            p.muestre(); //Imprime TODAS las peliculas con todos sus datos.
            line=bure.readLine();
        }
        
    }
        
    /**
    Cierra el FileReader y el BufferedReader
     */
    public void cierre() throws IOException {
        bure.close();
        fire.close();
    }
    /*********************************************************************
     * Administracion de categorias
     * *******************************************************************
     */

    public static void main(String[]Args)throws IOException{
        Lector test = new Lector();
        //test.readTest();
        test.lea();
        test.cierre();
    }
}
