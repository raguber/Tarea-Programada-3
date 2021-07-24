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

    public void busqueHilera(String cat,boolean mostrarCoincidenciaExacta)
    {
        String Hilera = cat;

        Hilera = Hilera.trim();
        String letraAnalizar = Hilera.substring(0,1);

        int numLetraAnalizar = deNumeroLetra(letraAnalizar);

        if(numLetraAnalizar>numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {

            if(letraDerecha != null)
            {
                letraDerecha.busqueHilera (Hilera,mostrarCoincidenciaExacta);
            }
            else
            {

            }
        }
        else
        {
            if(numLetraAnalizar==numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
            //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a Hilera ba o con ba inicialmente
            {

                Hilera = Hilera.substring(1);

                if(Hilera.isEmpty() == true)//Caso de existir mas letras a analizar
                {

                    if(mostrarCoincidenciaExacta  == true)
                    {
                        if(listaPeliculas != null)
                        {
                            listaPeliculas.muestre();
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
                    if(letraIzquierda != null)
                    {
                        letraIzquierda.busqueHilera(Hilera, mostrarCoincidenciaExacta);

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

    public void agreguePelicula(String texto,Pelicula pelicula)//Una pelicula puede tener hilera distintas, entonces se debe ingresar una cat, y no se puede sacar de la pelicula
    {
        System.out.println("Te 2 sd"+texto);

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
                agreguePeliculaLista(sub,pelicula,sub);
                System.out.println("prueba sda "+sub);

                
                texto=texto.substring(pos+1,texto.length());
                System.out.println(texto);
                System.out.println("prueba sda");

            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }

    }
    public void agreguePeliculaLista(String hil,Pelicula pelicula,String hileraExacta)
    {
        System.out.println("Esxdfsj");
        pelicula.muestre();

        String Hilera = hil;
        System.out.println("hil "+Hilera);

        Hilera = Hilera.trim();
        System.out.println("hil "+Hilera);
        String letraAnalizar = Hilera.substring(0,1);

        int numLetraAnalizar = deNumeroLetra(letraAnalizar);

        if(numLetraAnalizar>numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {
            System.out.println(numLetraAnalizar+" "+numeroLetra);
            letraDerecha.agreguePeliculaLista(Hilera,pelicula,hileraExacta);
        }
        else
        {
            if(numLetraAnalizar==numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
            //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a Hilera ba o con ba inicialmente
            {

                Hilera = Hilera.substring(1);

                if(Hilera.isEmpty() == true)//Caso de existir mas letras a analizar
                {
                    //Se pasa al izquierda y se analiza usando la letra que sigue

                    if(listaPeliculas == null)
                    {
                        listaPeliculas = new ListaPeliculas(hileraExacta);
                        System.out.println("asks");
                    }
                    listaPeliculas.agregue(pelicula);
                    System.out.println("asks");
                }
                else//Se llego a una Hilera exacta
                {

                    letraIzquierda.agreguePeliculaLista(Hilera, pelicula,hileraExacta);

                }

            }

        }
    }

    public void editeCategoria(String hileraExis, String nuevHilera)
    {
        boolean existeCategoria = determineSiExisteHilera(hileraExis);
        if(existeCategoria == true)
        {
            ListaPeliculas peliculas = retorneListaPeliculas(hileraExis);
            agregueHileraNueva(nuevHilera);

            editeCategoriaPeliculas(peliculas,nuevHilera);
        }
        else
        {
            System.out.println("Error no existen pelicualas con la categoria ingresada");
        }

    }

    public void editeCategoriaPeliculas(ListaPeliculas pelicula,String nuevHil)
    {
        agregueHileraNueva(nuevHil);
        while(pelicula.pelicula.next != null)
        {
            pelicula.pelicula.setCategoria(nuevHil);
        }
    }

    public void muestreCategoria()
    {

    }

    public ListaPeliculas retorneListaPeliculas(String hilera)
    {
        ListaPeliculas listaPeli = null;
        String Hilera = hilera;
        System.out.println("Hilera "+Hilera);
        Hilera = Hilera.trim();
        String letraAnalizar = Hilera.substring(0,1);

        int numLetraAnalizar = deNumeroLetra(letraAnalizar);

        if(numLetraAnalizar>numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {

            listaPeli = letraDerecha.retorneListaPeliculas(Hilera);
        }
        else
        {
            if(numLetraAnalizar==numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
            //En otro caso se encontro una coincidencia y se mostrarian las peliculas iguales a Hilera ba o con ba inicialmente
            {

                Hilera = Hilera.substring(1);
                System.out.println(Hilera+" Hilera nueva");
                if(Hilera.isEmpty() == true)//Caso de existir mas letras a analizar
                {
                    //Se pasa al izquierda y se analiza usando la letra que sigue

                    listaPeli = listaPeliculas;

                }
                else//Se llego a una Hilera exacta
                {

                    listaPeli = letraIzquierda.retorneListaPeliculas(Hilera);

                }

            }

        }
        return listaPeliculas;
    }

    public boolean determineSiExisteHilera(String cat)
    {
        boolean existe = false;
        String Hilera = cat;
        System.out.println("Hilera "+Hilera);
        Hilera = Hilera.trim();
        String letraAnalizar = Hilera.substring(0,1);

        int numLetraAnalizar = deNumeroLetra(letraAnalizar);

        if(numLetraAnalizar>numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {

            if(letraDerecha != null)
            {
                existe = letraDerecha.determineSiExisteHilera(Hilera);
            }
            else
            {
                existe = false;//En este caso se encuentra con un numero mayor entonces si se tiene b y se busca a, se sabe que a no existe

            }
        }
        else
        {
            if(numLetraAnalizar==numeroLetra)//Ej: se ingresa ba(2)(1) y se esta en b(2); entonces si hay mas letras se va a la izquierda y empieza a buscar desde a(1)
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
                    if(letraIzquierda != null)
                    {
                        existe = letraIzquierda.determineSiExisteHilera(Hilera);

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

    public void agregueHilera(String texto)
    {
        System.out.println("Te "+texto);

        int pos=0;
        String sub = "";
        String p = "";
        boolean siga = true;
        while(siga){
            try{
                pos=texto.indexOf(",");
                sub=texto.substring(0,pos);
                texto=texto.substring(pos+1,texto.length());
                System.out.println("prueba 2");
                agregueHileraNueva(sub);
            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }
    }

    public void agregueHileraNueva(String cat)
    {
        String Hilera = cat;
        System.out.println(Hilera);
        Hilera = Hilera.trim();

        int tamanoHilera = Hilera.length();

        String letraAgregar = Hilera.substring(0,1);

        int numLetraAgregar = deNumeroLetra(letraAgregar);

        if(numeroLetra == 0)
        {

            numeroLetra = numLetraAgregar;
            Hilera = Hilera.substring(1);

            if(Hilera.isEmpty()==true)
            {

            }
            else
            {
                if(letraIzquierda == null)
                {

                    letraIzquierda = new ArbolPeliculas();
                    letraIzquierda.agregueHileraNueva(Hilera);

                }
                else
                {

                    letraIzquierda.agregueHileraNueva(Hilera);
                    if(letraIzquierda.numeroLetra > numLetraAgregar)
                    {

                    }
                }
            }

        }
        else
        {

            if(numeroLetra<numLetraAgregar)
            {

                if(letraDerecha == null)
                {

                    letraDerecha = new ArbolPeliculas();
                    letraDerecha.agregueHileraNueva(Hilera);
                }
                else
                {

                    if(letraDerecha.numeroLetra>numLetraAgregar)
                    {

                        ArbolPeliculas letraDerechaTemp = letraDerecha;
                        ArbolPeliculas  nuevaLetraDerechaTemp = new ArbolPeliculas();
                        letraDerecha = nuevaLetraDerechaTemp;
                        letraDerecha.letraDerecha = letraDerechaTemp;
                        letraDerecha.agregueHileraNueva(Hilera);
                    }
                    else
                    {
                        if(letraDerecha.numeroLetra==numLetraAgregar)
                        {
                            letraDerecha.agregueHileraNueva(Hilera);


                
                    
                           
                        }

                    }
                }

                if(numeroLetra==numLetraAgregar)
                {

                    Hilera = Hilera.substring(1);

                    if(Hilera.isEmpty()==true)
                    {
                        //AgregueHilera;

                    }
                    else
                    {
                        letraAgregar = Hilera.substring(0,1);
                        numLetraAgregar = deNumeroLetra(letraAgregar);
                        if(letraIzquierda == null)
                        {
                            System.out.println("Letra no existe");
                            letraIzquierda = new ArbolPeliculas();
                            letraIzquierda.agregueHileraNueva(Hilera);
                        }
                        else
                        {
                            System.out.println(letraIzquierda.numeroLetra+" "+numLetraAgregar);
                            if(letraIzquierda.numeroLetra>numLetraAgregar)
                            {

                                ArbolPeliculas letraIzquierdaTemp = letraIzquierda;
                                ArbolPeliculas nuevaLetraIzquierda = new ArbolPeliculas();
                                letraIzquierda = nuevaLetraIzquierda;

                                letraIzquierda.letraDerecha = letraIzquierdaTemp;
                                letraIzquierda.agregueHileraNueva(Hilera);
                            }
                            else
                            {

                                letraIzquierda.agregueHileraNueva(Hilera);
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
        arbol.agregueHileraNueva("A");

    }
}
