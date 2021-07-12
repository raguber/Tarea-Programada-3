import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Reader{
    File movies;
    FileReader fire;
    BufferedReader bure;
    
    public Reader()throws IOException{
        movies=new File("netflix_titles_dep.csv");
        fire=new FileReader(movies);
        bure=new BufferedReader(fire);
    }
     
    public void read()throws IOException{
        String line=bure.readLine();
        while(line!=null){
            //System.out.println(line+" ");
            Pelicula p = new Pelicula(line);
            line=bure.readLine();
        }
        bure.close();
    }
    
    public static void main(String[]Args)throws IOException{
        Reader test = new Reader();
        test.read();
    }
}