import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
Clase encargada de leer todas las películas e instanciarlas en objetos Pelicula
 */
public class Controlador{
    File movies;
    FileReader fire;
    BufferedReader bure;

 ArbolPeliculas arbolCategorias;
    ArbolPeliculas arbolActores;
    ArbolPeliculas arbolTipo;


    ArbolPeliculas arbolPais;
    /**
    Constructor. Crea los objetos File necesarios para leer las líneas del documento que contiene las películas.
     */
    public Controlador()throws IOException{
        movies=new File("netflix_titles_dep.csv");
        fire=new FileReader(movies);
        bure=new BufferedReader(fire);
        arbolCategorias=new ArbolPeliculas();
        arbolCategorias.agregueHileraNueva(arbolCategorias,"a");



        arbolActores=new ArbolPeliculas();
        arbolActores.agregueHileraNueva(arbolCategorias,"a");
        arbolTipo=new ArbolPeliculas();
        arbolTipo.agregueHileraNueva(arbolTipo,"a");
        arbolPais=new ArbolPeliculas();
        arbolPais.agregueHileraNueva(arbolTipo,"a");



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

        String line=bure.readLine();
        for(int i=0;i<2;i++){
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
            arbolCategorias.agregueHilera(arbolCategorias,categoria);
            line=line.substring(pos+1,line.length());

            pos = line.indexOf(";");
            descripcion=line.substring(0,pos);
            line=line.substring(pos+1,line.length());

            Pelicula p = new Pelicula(show_id,tipo,titulo,director,cast,pais,fecha,anio,audiencia,duracion,categoria,descripcion);

            agreguePeliculaArboles(p);
            

            ///////Imprimir las peliculas:

           
            p.muestre();
           agreguePeliculaArboles(p);
            line=bure.readLine();
        }

        System.out.println("*********");

    }

    public void agreguePeliculaArboles(Pelicula p)
    {

        p.muestre();
        System.out.println("ASD VsaSDASdSADDAdA");
        arbolCategorias.agregueHilera(arbolTipo,p.getCategoria());
        arbolTipo.agreguePelicula(arbolTipo,p.getCategoria(),p);
        System.out.println("SADsadddddddd");



                    //agregar categorías, actores, tipo, pais de procedencia
        String texto,sub;
        boolean siga=true;
        texto=p.getCategoria();
        int pos;
        while(siga){
            try{
                pos=texto.indexOf(",");
                sub=texto.substring(0,pos);
                texto=texto.substring(pos+1,texto.length());
                arbolCategorias.agreguePelicula(arbolCategorias,sub,p);
            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }
        siga=true;
        texto=p.getCast();
        while(siga){
            try{
                pos=texto.indexOf(",");
                sub=texto.substring(0,pos);
                texto=texto.substring(pos+1,texto.length());
                arbolActores.agreguePelicula(arbolActores,sub,p);
            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }
        //arbolTipo.agreguePelicula(arbolActores,p.getTipo(),p);
       // arbolPais.agreguePelicula(arbolActores,p.getPais(),p);
      

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
        Controlador test = new Controlador();
        //test.readTest();
        test.lea();
        test.cierre();
    }
}
