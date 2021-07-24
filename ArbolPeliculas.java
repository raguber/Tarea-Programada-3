/**
 * Esta clase guarda peliculas ordenadas por hileras, donde las hileras pueden ser categorias, paises, entre otros,
 * Usa un valor asignado a caracteres de hileras alfabeticas para organizar el arbol
 * El funcionamiento del arbol basicamente se reduce a agregar a la derecha los valores mayores que un valor determinado, donde un valor derecho es un valor "poco importante"
 * Si se encuentra un valor igual se va a la izquierda, se corta la hilera, para ir guardando categorias por hileras.
 * 
 * @author Randy Agüero B90082, Frayvin Alvarado B60292 y Andrés Serrano C07483
 * @version 20/7/2021
 *
 */
public class ArbolPeliculas
{
    int numeroLetra;
    ArbolPeliculas letraIzquierda;//Letra izquierda para letras que necesitan previamente valor del nodo (letra);
    ArbolPeliculas letraDerecha;//Letra derecha para letras que no necesita previamente el valor del nodo (letra);
    Pelicula pelicula;
    ListaPeliculas listaPeliculas;
    ArbolPeliculas()
    {
        numeroLetra = 0;//Pruebas
        letraIzquierda = null;
        letraDerecha = null;
        pelicula = null;
        listaPeliculas = null;
    }

    public void muestreCategoriasArbol(ArbolPeliculas arbol)
    {
        System.out.println("Arb "+arbol.numeroLetra);
        if(arbol.listaPeliculas != null)
        {
            System.out.println("muestra lista");
            arbol.listaPeliculas.muestre();
            arbol.listaPeliculas.muestreNombreFiltrado();
        }
        if(arbol.letraIzquierda != null)
        {

            muestreCategoriasArbol(arbol.letraIzquierda);
        }
        if(arbol.letraDerecha  != null)
        {

            muestreCategoriasArbol(arbol.letraDerecha);
        }

    }

    public void busqueHilera(ArbolPeliculas arbol,String cat,boolean mostrarCoincidenciaExacta)
    {
        String Hilera = cat;

        String letraAnalizar = Hilera.substring(0,1);
        int numLetraAnalizar = deNumeroLetra(letraAnalizar);
        if(numLetraAnalizar>arbol.numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {

            if(arbol.letraDerecha != null)
            {
                arbol.busqueHilera (arbol.letraDerecha,Hilera,mostrarCoincidenciaExacta);
            }
            else
            {

            }
        }
        else
        {
            if(numLetraAnalizar==arbol.numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
            //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a Hilera ba o con ba inicialmente
            {

                Hilera = Hilera.substring(1);

                if(Hilera.isEmpty() == true)//Caso de existir mas letras a analizar
                {

                    if(mostrarCoincidenciaExacta  == true)
                    {
                        if(arbol.listaPeliculas != null)
                        {
                            arbol.listaPeliculas.muestre();
                        }
                        else
                        {

                        }
                    }
                    else
                    {
                        //mostrarPeliculasInclSubarboles();
                    }

                }
                else//Se llego a una Hilera exacta
                {
                    if(arbol.letraIzquierda != null)
                    {
                        arbol.busqueHilera(arbol.letraIzquierda,Hilera, mostrarCoincidenciaExacta);

                    }
                    else
                    {

                    }
                }
            }
            else//Numero Letra menor que la del nodo //Ej, se busca b pero se esta en c, ya se sabe que no existe, de existir una coincidencia no llegaria a c., si no que se quedaria en b
            //Ejemplo de rama (a)----(c) Si b>a (2>1), entonces a le dice a b que se vaya por el camino a la derecha, pero llega a c, entonces no existe un b guardado.
            {

            }
        }
    }

    public void agreguePeliculaLista(ArbolPeliculas arbol,String hil,Pelicula pelicula,String hileraExacta)
    {

        pelicula.muestre();
        String Hilera = hil;
        System.out.println("hil *"+Hilera);
        String letraAnalizar = Hilera.substring(0,1);

        int numLetraAnalizar = deNumeroLetra(letraAnalizar);
        System.out.println(numLetraAnalizar+" "+numeroLetra+"*"+letraAnalizar+"*");

        if(numLetraAnalizar>arbol.numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {
            System.out.println("hil ***"+Hilera);
            System.out.println(numLetraAnalizar+" "+numeroLetra);
            arbol.agreguePeliculaLista(arbol.letraDerecha,Hilera,pelicula,hileraExacta);
        }
        else
        {
            if(numLetraAnalizar==arbol.numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
            //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a Hilera ba o con ba inicialmente
            {

                Hilera = Hilera.substring(1);

                if(Hilera.isEmpty() == true)//Caso de existir mas letras a analizar
                {
                    //Se pasa al izquierda y se analiza usando la letra que sigue

                    if(arbol.listaPeliculas == null)
                    {
                        System.out.println("hilera exacta "+hileraExacta);
                        arbol.listaPeliculas = new ListaPeliculas(hileraExacta);
                        System.out.println("hilera ");
                        arbol.listaPeliculas.muestreNombreFiltrado();
                        arbol.listaPeliculas.agregue(pelicula);
                    }
                    else
                    {
                        arbol.listaPeliculas.agregue(pelicula);
                    }
                    System.out.println("SS");

                }
                else//Se llego a una Hilera exacta
                {

                    arbol.agreguePeliculaLista(arbol.letraIzquierda,Hilera, pelicula,hileraExacta);

                }

            }
            else
            {
                arbol.agreguePeliculaLista(arbol.letraDerecha,Hilera, pelicula,hileraExacta);
            }

        }

    }

    public void editeCategoria(ArbolPeliculas arbol,String hileraExis, String nuevHilera)
    {
        boolean existeCategoria = determineSiExisteHilera(arbol,hileraExis);
        if(existeCategoria == true)
        {
            ListaPeliculas peliculas = retorneListaPeliculas(arbol,hileraExis);
            agregueHileraNueva(arbol,nuevHilera);

            //editeCategoriaPeliculas(peliculas);
        }
        else
        {
            System.out.println("Error no existen pelicualas con la categoria ingresada");
        }

    }

    public void editeCategoriaPeliculas(Pelicula pelicula,String nuevHil)
    {
        // agregueHileraNueva(nuevHil);
        // while(peliculas.peliculaSiguiente != null)
        // {

        // }
    }

    public void muestreCategoria()
    {

    }

    public ListaPeliculas retorneListaPeliculas(ArbolPeliculas arbol,String hilera)
    {
        ListaPeliculas listaPeli = null;
        String Hilera = hilera;
        System.out.println("Hilera "+Hilera);

        String letraAnalizar = Hilera.substring(0,1);

        int numLetraAnalizar = deNumeroLetra(letraAnalizar);

        if(numLetraAnalizar>arbol.numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {

            listaPeli = retorneListaPeliculas(arbol.letraDerecha,Hilera);
        }
        else
        {
            if(numLetraAnalizar==arbol.numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
            //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a Hilera ba o con ba inicialmente
            {

                Hilera = Hilera.substring(1);
                System.out.println(Hilera+" Hilera nueva");
                if(Hilera.isEmpty() == true)//Caso de existir mas letras a analizar
                {
                    //Se pasa al izquierda y se analiza usando la letra que sigue

                    listaPeli = arbol.listaPeliculas;

                }
                else//Se llego a una Hilera exacta
                {

                    listaPeli = letraIzquierda.retorneListaPeliculas(arbol.letraIzquierda,Hilera);

                }

            }

        }
        return listaPeliculas;
    }

    public boolean determineSiExisteHilera(ArbolPeliculas arbol,String cat)
    {
        boolean existe = false;
        String Hilera = cat;
        System.out.println("Hilera "+Hilera);

        String letraAnalizar = Hilera.substring(0,1);

        int numLetraAnalizar = deNumeroLetra(letraAnalizar);
        System.out.println("LEtra 1 "+arbol.numeroLetra+" "+numLetraAnalizar);
        if(numLetraAnalizar>arbol.numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {
            System.out.println("SFA");
            System.out.println("LEtra 1 "+arbol.numeroLetra+" "+numLetraAnalizar);
            if(arbol.letraDerecha != null)
            {
                existe = arbol.determineSiExisteHilera(arbol.letraDerecha,Hilera);
            }
            else
            {
                System.out.println("NO hay mas");
                existe = false;//En este caso se encuentra con un numero mayor entonces si se tiene b y se busca a, se sabe que a no existe

            }
        }
        else
        {
            System.out.println("Arbol "+arbol.numeroLetra+" "+numLetraAnalizar);
            if(numLetraAnalizar==arbol.numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
            //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a Hilera ba o con ba inicialmente
            {

                Hilera = Hilera.substring(1);
                System.out.println(Hilera+" Hilera nueva");
                if(Hilera.isEmpty() == true)//Caso de existir mas letras a analizar
                {
                    //Se pasa al izquierda y se analiza usando la letra que sigue

                    existe = true;

                }
                else//Se llego a una Hilera exacta
                {
                    if(arbol.letraIzquierda != null)
                    {

                        existe = arbol.determineSiExisteHilera(arbol.letraIzquierda,Hilera);

                    }
                    else
                    {

                        existe=false;
                    }
                }
            }
            else//Numero Letra menor que la del nodo //Ej, se busca b pero se esta en c, ya se sabe que no existe, de existir una coincidencia no llegaria a c., si no que se quedaria en b
            //Ejemplo de rama (a)----(c) Si b>a (2>1), entonces a le dice a b que se vaya por el camino a la derecha, pero llega a c, entonces no existe un b guardado.
            {

                existe=false;
            }

        }

        return existe;
    }

    public void agregueHilera(ArbolPeliculas arbol,String texto)
    {
        System.out.println("Te "+texto);
        System.out.println("Te "+texto);
        int pos=0;
        String sub = "";
        String p = "";
        boolean siga = true;
        while(siga){
            try{
             
                pos=texto.indexOf(",");

                if(pos != 0)
                {
                
                    sub=texto.substring(0,pos);
                    System.out.println("texto *"+sub+"* sub *"+sub+"*");
                    texto=texto.substring(pos+1,texto.length());
                }
                else
                {
                    sub=texto;
                }

                System.out.println("prueba 2"+sub+" "+texto);
          
                boolean existe = determineSiExisteHilera(arbol,sub);
                if(existe == false)
                {
                    agregueHileraNueva(arbol,sub);
                }

                System.out.println("existe "+sub+" "+existe);
            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }
    }

    public ArbolPeliculas agreguePelicula(ArbolPeliculas arbol, String texto,Pelicula pelicula)//Una pelicula puede tener hilera distintas, entonces se debe ingresar una cat, y no se puede sacar de la pelicula
    {
        System.out.println("Te 2 sd"+texto);
        ArbolPeliculas arbolAGuardar = arbol;
        int pos=0;
        String sub = "";
        String p = "";
        boolean siga = true;
        while(siga){
            try{
                
                pos=texto.indexOf(",");

                if(pos != 0)
                {
                   
                    sub=texto.substring(0,pos);
                    System.out.println("texto *"+sub+"* sub *"+sub+"*");
                    texto=texto.substring(pos+1,texto.length());
                }
                else
                {
                    sub=texto;
                }

                System.out.println("prueba 2"+sub+" "+texto);


                agreguePeliculaLista(arbol,sub,pelicula,sub);
            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }

        return arbolAGuardar;

    }

    public void agregueHileraNueva(ArbolPeliculas arbol,String cat)
    {
        String Hilera = cat;
        System.out.println(Hilera);

        int tamanoHilera = Hilera.length();
        String letraAgregar = Hilera.substring(0,1);
        int numLetraAgregar = deNumeroLetra(letraAgregar);
        System.out.println("letra agregar pi "+letraAgregar+" "+numLetraAgregar);

        if(arbol.numeroLetra == 0)
        {

            numeroLetra = numLetraAgregar;
            Hilera = Hilera.substring(1);

            if(Hilera.isEmpty()==true)
            {
                //AgregueHilera;
                System.out.println("letras vacias vacio");

            }
            else
            {
                System.out.println("quedan no vacio");
                letraAgregar = Hilera.substring(0,1);
                numLetraAgregar = deNumeroLetra(letraAgregar);
                System.out.println(Hilera);
                //Se debe agregar a la izquierda 
                if(arbol.letraIzquierda == null)
                {

                    arbol.letraIzquierda = new ArbolPeliculas();
                    arbol.letraIzquierda.numeroLetra = numLetraAgregar;
                    arbol.agregueHileraNueva(arbol.letraIzquierda,Hilera);

                }
                else
                {

                    System.out.println("letra no vacio");

                    if(arbol.letraIzquierda.numeroLetra > numLetraAgregar)
                    {
                        ArbolPeliculas letraIzquierdaTemp = arbol.letraIzquierda;
                        arbol.letraIzquierda = new ArbolPeliculas ();
                        arbol.letraIzquierda.numeroLetra = numLetraAgregar;
                        arbol.letraIzquierda.letraDerecha = letraIzquierdaTemp;
                        arbol.agregueHileraNueva(arbol.letraIzquierda,Hilera);
                    }
                    else
                    {
                        arbol.agregueHileraNueva(arbol.letraIzquierda,Hilera);
                    }
                }
            }

        }
        else
        {

            if(arbol.numeroLetra<numLetraAgregar)
            {
                if(numLetraAgregar == 30 && letraAgregar.equals(" ")== false)
                {
                    System.out.println("num Letra "+numLetraAgregar+" letra *"+letraAgregar+"*");
                }
                System.out.println("letra menor derecha");
                if(arbol.letraDerecha == null)
                {
                    System.out.println("letra derec vacio");
                    arbol.letraDerecha = new ArbolPeliculas();
                    arbol.letraDerecha.numeroLetra = numLetraAgregar;
                    arbol.agregueHileraNueva(arbol.letraDerecha,Hilera);
                }
                else
                {
                    System.out.println("letra derf no vacio");
                    if(arbol.letraDerecha.numeroLetra>numLetraAgregar)
                    {
                        System.out.println("letra mayor letra");
                        ArbolPeliculas letraDerechaTemp = arbol.letraDerecha;

                        arbol.letraDerecha = new ArbolPeliculas();
                        arbol.letraDerecha.numeroLetra = numLetraAgregar;
                        arbol.letraDerecha.letraDerecha = letraDerechaTemp;
                        arbol.agregueHileraNueva(arbol.letraDerecha,Hilera);
                    }
                    else
                    {
                        if(arbol.letraDerecha.numeroLetra==numLetraAgregar)
                        {
                            System.out.println("letra igual Derecha");
                            arbol.agregueHileraNueva(arbol.letraDerecha,Hilera);

                        }
                        else
                        {
                            arbol.agregueHileraNueva(arbol.letraDerecha,Hilera);
                        }

                    }

                }
            }
            else
            {
                if(arbol.numeroLetra==numLetraAgregar)
                {
                    System.out.println(Hilera);
                    System.out.println("letras iguales");
                    Hilera = Hilera.substring(1);

                    System.out.println(Hilera);
                    if(Hilera.isEmpty()==true)
                    {
                        //AgregueHilera;
                        System.out.println("letras vacias vacio");

                    }
                    else
                    {
                        System.out.println("quedan no vacio "+Hilera);

                        letraAgregar = Hilera.substring(0,1);

                        numLetraAgregar = deNumeroLetra(letraAgregar);
                        System.out.println(Hilera);
                        if(arbol.letraIzquierda == null)
                        {
                            System.out.println("Letra no existe");
                            arbol.letraIzquierda = new ArbolPeliculas();
                            arbol.letraIzquierda.numeroLetra= numLetraAgregar;
                            arbol.agregueHileraNueva(arbol.letraIzquierda,Hilera);

                        }
                        else
                        {
                            System.out.println(arbol.letraIzquierda.numeroLetra+" "+numLetraAgregar);
                            if(arbol.letraIzquierda.numeroLetra>numLetraAgregar)
                            {
                                System.out.println("letra izquidsc mayo vacio");
                                ArbolPeliculas letraIzquierdaTemp = arbol.letraIzquierda;

                                arbol.letraIzquierda = new ArbolPeliculas();
                                arbol.letraIzquierda.numeroLetra = numLetraAgregar;

                                arbol.letraIzquierda.letraDerecha = letraIzquierdaTemp;
                                arbol.agregueHileraNueva(arbol.letraIzquierda,Hilera);

                            }
                            else
                            {
                                //LEtra igual letra menor;

                                arbol.agregueHileraNueva(arbol.letraIzquierda,Hilera);
                            }

                        }

                    }
                }
            }
        }

    }

    public int deNumeroLetra(String L)
    {
        int valorLetra = 30;
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
            case " ":
            valorLetra = 28;

        }
        return valorLetra;
    }

    public static void main (String args[])
    {
        ArbolPeliculas arbol = new ArbolPeliculas();
        arbol.numeroLetra=(1);

        arbol.agregueHilera(arbol,"International TV Shows, TV Dramas, TV Sci-Fi & Fantasy");
        arbol.agregueHilera(arbol,"Dramas, International Movies");
        arbol.agregueHilera(arbol,"Dramas, International Movies");
        arbol.agregueHilera(arbol,"Horror Movies, International Movies");
        arbol.agregueHilera(arbol,"Action & Adventure, Independent Movies, Sci-Fi & Fantasy");
        boolean existe = arbol.determineSiExisteHilera(arbol,"Dramas");
        System.out.println("Existe +"+existe);
        // arbol.agregueHilera(arbol,);

    }
}
