/**
 * Peu
 */
public class ArbolCategoria
{
    int numeroLetra;
    ArbolCategoria letraIzquierda;//Letra izquierda para letras que necesitan previamente valor del nodo (letra);
    ArbolCategoria letraDerecha;//Letra derecha para letras que no necesita previamente el valor del nodo (letra);
    ListaPel listaPeliculas;
    ArbolCategoria(int num)
    {
        numeroLetra = num;
        letraIzquierda = null;
        letraDerecha = null;
        listaPeliculas = null;
    }

    public void busqueCategoria(String cat,boolean mostrarCoincidenciaExacta)
    {
        String categoria = cat;
        categoria = categoria.trim();
        String letraAnalizar = categoria.substring(0,1);
        int numLetraAnalizar = deNumeroLetra(letraAnalizar);

        if(numeroLetra != 0)
        {
            if(numLetraAnalizar>numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
            {
                if(letraDerecha != null)
                {
                    letraDerecha.busqueCategoria (categoria,mostrarCoincidenciaExacta);
                }
                else
                {
                    System.out.println("Error, no existe peliculas segun la categoria ingresada ");
                }
            }
            else
            {
                if(numLetraAnalizar==numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
                //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a categoria ba o con ba inicialmente
                {
                    categoria = categoria.substring(1);
                    if(categoria.length()>1)//Caso de existir mas letras a analizar
                    {
                        //Se pasa al izquierda y se analiza usando la letra que sigue
                        letraIzquierda.busqueCategoria(categoria, mostrarCoincidenciaExacta);

                    }
                    else//Se llego a una categoria exacta
                    {
                        if(mostrarCoincidenciaExacta  == true)
                        {
                            // mostrarPeliculas();
                        }
                        else
                        {
                            //mostrarPeliculasInclSubarboles();
                        }
                    }
                }
                else//Numero Letra menor que la del nodo //Ej, se busca b pero se esta en c, ya se sabe que no existe, de existir una coincidencia no llegaria a c., si no que se quedaria en b
                //Ejemplo de rama (a)----(c) Si b>a (2>1), entonces a le dice a b que se vaya por el camino a la derecha, pero llega a c, entonces no existe un b guardado.
                {

                    System.out.println("Error, no existe peliculas segun la categoria ingresada");
                }

            }
        }
        else
        {
            System.out.println("No existe la categoria");
            //Por creacion del codigo no debera suceder esto, ya que de una u otra forma
            //El usuario tendra ya subidas las categorias, 
        }

    }

    public void agreguePelicula(String cat,Peli pelicula)//Una pelicula puede tener categorias distintas, entonces se debe ingresar una cat, y no se puede sacar de la pelicula
    {
        agregueCategoriaNueva(cat);//No hace falta verificar si ya existe, por de hacerlo se tendria que recorrer el arbol dos veces, uno para ver si existe "x" categoria y la segunda para agregar letras que no existam
        //El codigo va a ser eso en un solo proceso

    }

    public void agregueCategoriaNueva(String cat)
    {
        String categoria = cat;
        categoria = categoria.trim();
        int tamanoCategoria = categoria.length();
        String letraAgregar = categoria.substring(0,1);
        int numLetraAgregar = deNumeroLetra(letraAgregar);

        if(numeroLetra != 0)//La idea para agregar una letra es similar a la busqueda.
        {
            if(numLetraAgregar>numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
            {
                if(letraDerecha != null)
                {
                    letraDerecha.agregueCategoriaNueva(categoria);
                }
                else
                {
                    letraDerecha = new ArbolCategoria(numeroLetra);
                    categoria = categoria.substring(1);
                    if(categoria.length()>1)
                    {
                        letraDerecha.agregueCategoriaNueva(categoria);
                    }
                }
            }
            else
            {
                if(numLetraAgregar==numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
                //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a categoria ba o con ba inicialmente
                {
                    categoria = categoria.substring(1);
                    if(categoria.length()>1)//Caso de existir mas letras a analizar
                    {
                        //Se pasa al izquierda y se analiza usando la letra que sigue
                        if(letraIzquierda == null)
                        {
                            letraIzquierda = new ArbolCategoria(numeroLetra);
                              letraIzquierda.agregueCategoriaNueva(categoria.substring(1));
                        }
                        else
                        {
                            letraIzquierda.agregueCategoriaNueva(categoria);
                        }

                    }
                }

            }
        }
        else
        {
            //"No existe la categoria"
            numeroLetra = deNumeroLetra(letraAgregar);
            if(categoria.length()>=1)
            {
                categoria = categoria.substring(1);
            }
            if(categoria.length()>=1)
            {
              
                if(letraIzquierda == null)
                {
                    letraIzquierda = new ArbolCategoria(0);
                    letraIzquierda.agregueCategoriaNueva(categoria.substring(1));
                }
                else
                {
                    letraIzquierda.agregueCategoriaNueva(categoria.substring(1));
                }

            }

            //Por creacion del codigo no debera suceder esto, ya que de una u otra forma
            //El usuario tendra ya subidas las categorias, 
        }

    }

    public int deNumeroLetra(String L)
    {
        int valorLetra = 0;
        L = L.toLowerCase();
        switch (L)
        {
            case "a":
            valorLetra = 1;
            break;
            case "b":
            valorLetra = 2;
            break;
            case "c":
            valorLetra =  3;
            break;
            case "d":
            valorLetra =  4;
            break;
            case "e":
            valorLetra =  5;
            break;
            case "f":
            valorLetra =  6;
            break;
            case "g":
            valorLetra =  7;
            break;
            case "h":
            valorLetra =  8;
            break;
            case "i":
            valorLetra =  9;
            break;
            case "j":
            valorLetra =  10;
            break;
            case "k":
            valorLetra =  11;
            break;
            case "l":
            valorLetra =  12;
            break;
            case "m":
            valorLetra =  13;
            break;
            case "n":
            valorLetra =  14;
            break;
            case "ñ":
            valorLetra =  15;
            break;
            case "o":
            valorLetra =  16;
            break;
            case "p":
            valorLetra =  17;
            break;
            case "q":
            valorLetra = 18;
            break;
            case "r":
            valorLetra = 19;
            break;
            case "s":
            valorLetra = 20;
            break;
            case "t":
            valorLetra = 21;
            break;
            case "u":
            valorLetra = 22;
            break;
            case "v":
            valorLetra = 23;
            break;
            case "w":
            valorLetra = 24;
            break;
            case "x":
            valorLetra = 25;
            break;
            case "y":
            valorLetra = 26;
            break;
            case "z":
            valorLetra = 27;
            break;

        }
        return valorLetra;
    }

    public static void main (String args[])
    {
        ArbolCategoria arbol = new ArbolCategoria(1);
        String cat = " E Gsdg " ;
        System.out.println("Categoria "+cat); 
        String categoria = cat.trim();
        System.out.println("*"+categoria+"* sin espacios");
        String categoriaDesdeG = categoria.substring(2);
        System.out.println(categoriaDesdeG);
        int tamanoCategoria = categoria.length();
        System.out.println("Tamano categoria "+tamanoCategoria);
        String letraAnalizar = categoria.substring(0,1);
        System.out.println("letra a analizar :"+letraAnalizar);
        String letraAnalizarSinPrimera = categoria.substring(0,1);
        String letraPruebaSimbolosRaros = "*";
        System.out.println("Numero de simbolo *"+arbol.deNumeroLetra(letraPruebaSimbolosRaros));
        letraPruebaSimbolosRaros = "!";
        System.out.println("Numero de simbolo !"+arbol.deNumeroLetra(letraPruebaSimbolosRaros));;
    }

}
