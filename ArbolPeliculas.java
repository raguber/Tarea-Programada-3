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

    public void muestreArbol(ArbolPeliculas arb)
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
                System.out.println("sz");
                pos=texto.indexOf(",");
                sub=texto.substring(1);
                
                System.out.println(sub);
                arbolAGuardar = agreguePeliculaLista(arbol,sub,pelicula,sub);
                System.out.println("prueba sda "+sub);

                texto=texto.substring(pos+1,texto.length());
                System.out.println(texto);
                System.out.println("prueba sda");

            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }
        
        return arbolAGuardar;

    }

    public ArbolPeliculas agreguePeliculaLista(ArbolPeliculas arbol,String hil,Pelicula pelicula,String hileraExacta)
    {
        ArbolPeliculas arbolRetorno = null;
        System.out.println("Esxdfsj");
        pelicula.muestre();

        String Hilera = hil;
        System.out.println("hil "+Hilera);

        System.out.println("hil "+Hilera);
        String letraAnalizar = Hilera.substring(0,1);

        int numLetraAnalizar = deNumeroLetra(letraAnalizar);
        System.out.println(numLetraAnalizar+" "+numeroLetra);
        if(numLetraAnalizar>arbol.numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {
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

                    if(listaPeliculas == null)
                    {
                        arbol.listaPeliculas = new ListaPeliculas(hileraExacta);
                        
                    }
                    arbol.listaPeliculas.agregue(pelicula);
                    arbolRetorno = arbol;
                }
                else//Se llego a una Hilera exacta
                {

                    arbol.agreguePeliculaLista(arbol.letraIzquierda,Hilera, pelicula,hileraExacta);

                }

            }

        }
        return arbolRetorno;
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
                texto.trim();
                pos=texto.indexOf(",");
                sub=texto.substring(0,pos);
                texto=texto.substring(pos+1,texto.length());
               
                System.out.println("prueba 2"+sub+" "+texto);
                agregueHileraNueva(arbol,sub);
            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }
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
                    arbol.agregueHileraNueva(arbol.letraIzquierda,Hilera);
                    // if(letraIzquierda.numeroLetra > numLetraAgregar)
                    // {

                    // }
                }
            }

        }
        else
        {

            if(arbol.numeroLetra<numLetraAgregar)
            {
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

        }
        return valorLetra;
    }

    public static void main (String args[])
    {
        ArbolPeliculas arbol = new ArbolPeliculas();
        arbol.numeroLetra=(1);
        arbol.agregueHileraNueva(arbol,"A");

        boolean  existe = arbol.determineSiExisteHilera(arbol,"A");
        System.out.println("E "+existe+"\n");
        arbol.agregueHileraNueva(arbol,"asd");
        existe = arbol.determineSiExisteHilera(arbol,"asd");
        System.out.println("E "+existe);
        arbol.agregueHileraNueva(arbol,"asg");
        existe = arbol.determineSiExisteHilera(arbol,"asg");
        System.out.println("E "+existe+"\n");
        
        existe = arbol.determineSiExisteHilera(arbol,"asd");
        System.out.println("E "+existe+"\n");

            
            System.out.println("*******************pruebas***********");
    
            System.out.println("E "+existe+"\n");
    
            arbol.agregueHileraNueva(arbol,"sdasdsdfa sdfasf asfsdf");
            existe = arbol.determineSiExisteHilera(arbol,"sdasdsdfa sdfasf asfsdf");
            System.out.println("E "+existe+"\n");
            String letra = ("   ");
            System.out.println("N "+arbol.deNumeroLetra(" ")+" letra "+letra.length());        
            arbol.agregueHileraNueva(arbol,"sdfssd");
            existe = arbol.determineSiExisteHilera(arbol,"asd");
            System.out.println("E "+existe+"\n");

    }
}
