/**
 * Prueba
 */
public class ArbolCategoria
{
    int numeroLetra;
    ArbolCategoria letraIzquierda;//Letra izquierda para letras que necesitan previamente valor del nodo (letra);
    ArbolCategoria letraDerecha;//Letra derecha para letras que no necesita previamente el valor del nodo (letra);
    ListaPel listaPeliculas;
    ArbolCategoria()
    {
        numeroLetra = 0;//Pruebas
        letraIzquierda = null;
        letraDerecha = null;
        listaPeliculas = null;
    }

    public void muestreArbol(ArbolCategoria arb)
    {
        System.out.println("Arb "+numeroLetra);
        if(letraIzquierda != null)
        {
            System.out.print("iz");
            muestreArbol(letraIzquierda);
        }
        if(letraDerecha  != null)
        {
            System.out.println("der");
            muestreArbol(letraDerecha);
        }

    }

    public void busqueCategoria(String cat,boolean mostrarCoincidenciaExacta)
    {
        String categoria = cat;
        System.out.println("Categoria "+categoria);
        categoria = categoria.trim();
        String letraAnalizar = categoria.substring(0,1);

        int numLetraAnalizar = deNumeroLetra(letraAnalizar);
        System.out.println("letra "+letraAnalizar+" "+numLetraAnalizar);
        if(numeroLetra != 0)
        {
            System.out.println ("num letra nodo actual"+numeroLetra);
            if(numLetraAnalizar>numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
            {
                System.out.println("Letra actual menor que la letra a buscar, a la derecha");
                if(letraDerecha != null)
                {
                    letraDerecha.busqueCategoria (categoria,mostrarCoincidenciaExacta);
                }
                else
                {
                    //En este caso se encuentra con un numero mayor entonces si se tiene b y se busca a, se sabe que a no existe
                    System.out.println("Error, no existe peliculas segun la categoria ingresada ");
                }
            }
            else
            {
                if(numLetraAnalizar==numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
                //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a categoria ba o con ba inicialmente
                {
                    System.out.println("letra igual, se debe ir a la izquierda");
                    categoria = categoria.substring(1);
                    System.out.println(categoria+" categoria nueva");
                    if(categoria.isEmpty() == true)//Caso de existir mas letras a analizar
                    {
                        //Se pasa al izquierda y se analiza usando la letra que sigue
                        System.out.println("se encontraron todas las letras, existe categoria");

                        if(mostrarCoincidenciaExacta  == true)
                        {
                            //Mostar pelicula exacta
                        }
                        else
                        {
                            //mostrarPeliculasInclSubarboles();
                        }

                    }
                    else//Se llego a una categoria exacta
                    {
                        if(letraIzquierda != null)
                        {
                            letraIzquierda.busqueCategoria(categoria, mostrarCoincidenciaExacta);
                           
                        }
                        else
                        {
                            //Existe mas letras a buscar pero no existen letras agregadas, por lo cual se sabe que no existe
                               System.out.println("no mas letras a buscar");
                            System.out.println("no existe categoria");
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
        System.out.println("Letra "+letraAgregar+" num "+numLetraAgregar);

        if(numeroLetra == 0)
        {
            System.out.println("Letra no existe");

            numeroLetra = numLetraAgregar;

            categoria = categoria.substring(1);

            //Se mete a la izquierda
            if(categoria.isEmpty()==true)
            {
                System.out.println("No hay mas");
                //AgreguePeliculaAqui, else
            }
            else
            {
                if(letraIzquierda == null)
                {
                    System.out.println("A la izquierda");
                    letraIzquierda = new ArbolCategoria();
                    letraIzquierda.agregueCategoriaNueva(categoria);

                }
                else
                {
                    System.out.println("letra iz "+letraIzquierda.numeroLetra);
                    System.out.println("letraIzquierdaExiste");
                    letraIzquierda.agregueCategoriaNueva(categoria);
                    if(letraIzquierda.numeroLetra > numLetraAgregar)
                    {

                    }
                }
            }

        }
        else
        {
            System.out.println("Letra existe guardada"+numeroLetra);

            if(numeroLetra<numLetraAgregar)
            {
                System.out.println("A la derecha, la letra no es igual y es mayor que la actual "+numeroLetra +" "+numLetraAgregar);
                //Aqui se revisa el proximo,
                if(letraDerecha == null)
                {
                    System.out.println("Letra derecha null");
                    letraDerecha = new ArbolCategoria();
                    letraDerecha.agregueCategoriaNueva(categoria);
                }
                else
                {
                    System.out.println("Letra no null");
                    if(letraDerecha.numeroLetra>numLetraAgregar)
                    {
                        System.out.println("Existe Letra derecha pero mayor que letra agregar "+numLetraAgregar+" "+letraIzquierda.numeroLetra);
                        ArbolCategoria letraDerechaTemp = letraDerecha;
                        ArbolCategoria  nuevaLetraDerechaTemp = new ArbolCategoria();
                        letraDerecha = nuevaLetraDerechaTemp;
                        letraDerecha.letraDerecha = letraDerechaTemp;
                        letraDerecha.agregueCategoriaNueva(categoria);
                    }
                    else
                    {
                        if(letraDerecha.numeroLetra==numLetraAgregar)
                        {
                            letraDerecha.agregueCategoriaNueva(categoria);
                        }
                    }
                }
            }
            if(numeroLetra==numLetraAgregar)
            {
                System.out.println("LetraIgual , a la izquierda");
                categoria = categoria.substring(1);

                if(categoria.isEmpty()==true)
                {
                    //AgregueCategoria;
                }
                else
                {
                    letraAgregar = categoria.substring(0,1);
                    numLetraAgregar = deNumeroLetra(letraAgregar);
                    if(letraIzquierda == null)
                    {
                        System.out.println("Letra no existe");
                        letraIzquierda = new ArbolCategoria();
                        letraIzquierda.agregueCategoriaNueva(categoria);
                    }
                    else
                    {
                        System.out.println(letraIzquierda.numeroLetra+" "+numLetraAgregar);
                        if(letraIzquierda.numeroLetra>numLetraAgregar)
                        {
                            System.out.println("Existe Letra izq pero mayor que letra agregar "+numLetraAgregar+" "+letraIzquierda.numeroLetra+" se mete letra en medio");
                            ArbolCategoria letraIzquierdaTemp = letraIzquierda;
                            ArbolCategoria nuevaLetraIzquierda = new ArbolCategoria();
                            letraIzquierda = nuevaLetraIzquierda;

                            letraIzquierda.letraDerecha = letraIzquierdaTemp;
                            letraIzquierda.agregueCategoriaNueva(categoria);
                        }
                        else
                        {
                            System.out.println("Letra izquierda menor que letra agregar");
                            letraIzquierda.agregueCategoriaNueva(categoria);
                        }

                    }

                }
            }

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
        //Se hizo una prueba entonces, es posible reducir solo si es 1;
        ArbolCategoria arbol = new ArbolCategoria();
        arbol.agregueCategoriaNueva("A");//Por default se agrega a;
        System.out.println("Ebs");
        arbol.agregueCategoriaNueva("Ebs");

        System.out.println("************************************");
        System.out.println("Eas");
        arbol.agregueCategoriaNueva("Eas");
        System.out.println("*************Busqueda***********");
        
        arbol.busqueCategoria("Eas",false);
        System.out.println("********************************");
        arbol.busqueCategoria("Asd",false);
        System.out.println("********************************");
        arbol.busqueCategoria("Ebs",false);
        System.out.println("********************************");
        arbol.busqueCategoria("Ebx",false);//Ebx, exist parcialmente (EB);
        System.out.println("********************************");
        arbol.busqueCategoria("EbaASD",false);//Eba, existe parcialmente (EB);
        //arbol.agregueCategoriaNueva("safsdfsd");
        //arbol.agregueCategoriaNueva("Easffdas");
        //arbol.muestreArbol(arbol);
        // String cat = " E Gsdg " ;
        // System.out.println("Categoria "+cat); 
        // String categoria = cat.trim();
        // System.out.println("*"+categoria+"* sin espacios");
        // String categoriaDesdeG = categoria.substring(2);
        // System.out.println(categoriaDesdeG);
        // int tamanoCategoria = categoria.length();
        // System.out.println("Tamano categoria "+tamanoCategoria);
        // String letraAnalizar = categoria.substring(0,1);
        // System.out.println("letra a analizar :"+letraAnalizar);
        // String letraAnalizarSinPrimera = categoria.substring(0,1);
        // String letraPruebaSimbolosRaros = "*";
        // System.out.println("Numero de simbolo *"+arbol.deNumeroLetra(letraPruebaSimbolosRaros));
        // letraPruebaSimbolosRaros = "!";
        // System.out.println("Numero de simbolo !"+arbol.deNumeroLetra(letraPruebaSimbolosRaros));;
    }

}
