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
         * line = "Antonio Banderas;San son; action, drama, comedia, duracion , et;
         * int posicionPuntoComa = indexOf(";");
         * Actor = line.substring(0,posicionPuntoComa
         * line = line-line.Substring(0,posicionPuntoComa);
         * line San son; action, drama, comedia;
         * psocionPuntoComa = indexOf(";");
         * Nombre = line-substring(0,posicion);
         * line = substring 
        String ";"
         *Line action, drama, comedia;
         *lineaCategoria = substring(0,lineaCategoria.indexOf(";");
         *while(lineaCategoria.isEmpty != true);
         *{
         *  salidaCategoria = lineaCategoria(0,lineaCategoria.indexof(,);
         *  arbolCategoria.agregue(salidaCategora);
         *  lineaCategoria = subString(0,lineaCategoria.indexof(",");
         *  categoria += ","+salidaCategoria;
         *  drama, comedia
         *  }

         *  Pelicula peli = new Pelicula(actor,nombre,categoria)
         *  
        
        ArbolCategoria.agreguePelicula(Peli);
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
            Pelicula p = new Pelicula(line);
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

    public static void main(String[]Args)throws IOException{
        Lector test = new Lector();
        //test.readTest();
        test.lea();
        test.cierre();
    }
}
