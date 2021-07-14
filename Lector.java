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
        String line=bure.readLine();
        while(line!=null){
            //System.out.println(line+" ");
            Pelicula p = new Pelicula(line);
            line=bure.readLine();
        }
        Pelicula x = new Pelicula(line);
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
