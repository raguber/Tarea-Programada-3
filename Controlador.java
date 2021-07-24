import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

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
    Scanner scan;
    EntradaDatos entrada;
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
        arbolActores.agregueHileraNueva(arbolActores,"a");
        arbolTipo=new ArbolPeliculas();
        arbolTipo.agregueHileraNueva(arbolTipo,"a");
        arbolPais=new ArbolPeliculas();
        arbolPais.agregueHileraNueva(arbolPais,"a");

        scan = new Scanner(System.in);
        entrada = new EntradaDatos();
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
        for(int i=0;i<10;i++){
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

            p.muestre();
            agreguePeliculaArboles(p);
            line=bure.readLine();
        }

        System.out.println("*********");

    }

    public void agreguePeliculaArboles(Pelicula p)
    {

       // arbolCategorias.agregueHilera(arbolActores,p.getCategoria());
        arbolCategorias.agregueHilera(arbolCategorias,"Prueba, Last, Primer");
        String letra = " Last";//Pruea
        letra.trim();
        boolean existe = arbolCategorias.determineSiExisteHilera(arbolCategorias," Last");
        System.out.println("prueba "+existe);
        System.out.println("SAFKN");
        //arbolesCategorias = arbolCategorias.agreguePelicula(arbolesActores,p.getCategoria(),p)
        //arbolActores.agregueHilera(arbolActores,p.getCast());
        //arbolTipo.agregueHileraNueva(arbolTipo,p.getTipo());
        //arbolPais.agregueHileraNueva(arbolPais,p.getPais());


        //agregar categorías, actores, tipo, pais de procedencia
        // String texto,sub;
        // boolean siga=true;
        // texto=p.getCategoria();
        // int pos;
        // while(siga){
        // try{
        // pos=texto.indexOf(",");
        // sub=texto.substring(0,pos);
        // texto=texto.substring(pos+1,texto.length());
        // arbolCategorias.agreguePelicula(sub,p);
        // }catch(StringIndexOutOfBoundsException e){
        // siga=false;
        // }
        // }
        // siga=true;
        // texto=p.getCast();
        // while(siga){
        // try{
        // pos=texto.indexOf(",");
        // sub=texto.substring(0,pos);
        // texto=texto.substring(pos+1,texto.length());
        // arbolActores.agreguePelicula(sub,p);
        // }catch(StringIndexOutOfBoundsException e){
        // siga=false;
        // }
        // }


    }

    /**
    Cierra el FileReader y el BufferedReader
     */
    public void cierre() throws IOException {
        bure.close();
        fire.close();
    }

    public void menu(){
        //opciones: Cuáles películas pertenecen a una categoría específica//imprimir la lista de x categoría
        //en cuales videos ha actuado una persona//imprimir la lista actores
        //devolver la lista completa
        //editar categoría
        boolean termine=false;
        String opciones="¿Qué desea hacer?\n1. Buscar una categoría\n2.Buscar un actor/actriz\n3.Editar una categoría\n4. Salir";
        while(termine!=true){
            //System.out.println(opciones);
            int decision=entrada.pidaNumeroRango(opciones,4,1);

            switch(decision){
                case 1:
                String input=entrada.pidaTexto("Escogió el 1. Inserte la categoría que quiere buscar");
                if(arbolCategorias.determineSiExisteHilera(arbolCategorias,input) ==  true){
                    ListaPeliculas x = arbolCategorias.retorneListaPeliculas(arbolCategorias,input);
                    x.muestre();
                }else{
                    System.out.println("La categoría insertada no existe");
                }
                break;
                case 2:
                String input2=entrada.pidaTexto("Escogió el 2. Inserte la persona que quiere buscar");
                if(arbolActores.determineSiExisteHilera(arbolCategorias,input2)){
                    ListaPeliculas x = arbolActores.retorneListaPeliculas(arbolCategorias,input2);
                    x.muestre();
                }else{
                    System.out.println("El/la actor/actriz insertado/a no existe");
                }
                break;
                case 3:
                String catEscogida=entrada.pidaTexto("Escogió el 3. Escoja alguna de las categorías");
                System.out.println(catEscogida+"cas");
                catEscogida.trim();
                boolean existe =  arbolCategorias.determineSiExisteHilera(arbolCategorias,catEscogida);
                System.out.println("existe prueba "+existe);  
                if((arbolCategorias.determineSiExisteHilera(arbolCategorias,catEscogida)==true)){
                    String nuevoNombre = entrada.pidaTexto("La categoría existe, inserte el nombre de la nueva categoría");
                    arbolCategorias.editeCategoria(arbolCategorias,catEscogida,nuevoNombre);
                }
                break;
                case 4:
                termine=true;
                break;
            }
        }

    }

    /*********************************************************************
     * Administracion de categorias
     * *******************************************************************
     */

    public static void main(String[]Args)throws IOException{
        Controlador test = new Controlador();
        test.lea();
        test.menu();
        test.cierre();
    }
}
