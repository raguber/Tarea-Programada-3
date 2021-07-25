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

    ListaPeliculas listaPeliculas;
    ArbolPeliculas()
    {
        numeroLetra = 0;
        letraIzquierda = null;
        letraDerecha = null;

        listaPeliculas = null;
    }

    public void muestreFiltradoArbol(ArbolPeliculas arbol, boolean mostrarPeliculas)
    {

        if(arbol.listaPeliculas != null)
        {

            arbol.listaPeliculas.muestreNombreFiltrado();
            if(mostrarPeliculas == true)
            {
                arbol.listaPeliculas.muestre();
            }
        }
        if(arbol.letraIzquierda != null)
        {

            muestreFiltradoArbol(arbol.letraIzquierda,mostrarPeliculas);

        }
        if(arbol.letraDerecha  != null)
        {

            muestreFiltradoArbol(arbol.letraDerecha,mostrarPeliculas);
        }

    }

    public void agreguePeliculaLista(ArbolPeliculas arbol,String hil,Pelicula pelicula,String hileraExacta)
    {

        String Hilera = hil;
        String letraAnalizar = Hilera.substring(0,1);
        int numLetraAnalizar = deNumeroLetra(letraAnalizar);
        if(numLetraAnalizar>arbol.numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {

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

                        arbol.listaPeliculas = new ListaPeliculas(hileraExacta);

                        
                    }
                    
                        arbol.listaPeliculas.agregue(pelicula);
                    

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

    public void editeCategoria(ArbolPeliculas arbol,String hileraExis, String nuevHilera )
    {
        boolean existeCategoria = determineSiExisteHilera(arbol,hileraExis,false);

        ListaPeliculas peliculas = new ListaPeliculas("Vacio");
        peliculas = retorneListaPeliculas(arbol,hileraExis);

        agregueHileraNueva(arbol,nuevHilera);

        editeCategoriaPeliculas(arbol,peliculas, nuevHilera);

    }

    public void editeCategoriaPeliculas(ArbolPeliculas arbol,ListaPeliculas peliculas,String nuevHil)
    {
        Pelicula pelicula = peliculas.pelicula;
        arbol.agreguePeliculaLista(arbol,nuevHil,pelicula, nuevHil);
        pelicula.setCategoria(nuevHil);
        boolean masPeliculas = true;
        while(masPeliculas)
        {
            if(peliculas.peliculaDerecha != null)
            {
                peliculas.peliculaDerecha.pelicula.setCategoria(nuevHil);
                arbol.agreguePeliculaLista(arbol,nuevHil,peliculas.peliculaDerecha.pelicula,nuevHil);

            }
            else
            {
                peliculas = peliculas.peliculaDerecha;
                masPeliculas = false;
            }
        }
        arbol.determineSiExisteHilera(arbol,nuevHil, true);
    }
    // }

    public void muestreCategoria()
    {

    }

    public ListaPeliculas retorneListaPeliculas(ArbolPeliculas arbol,String hilera)
    {
        ListaPeliculas listaPeli = arbol.listaPeliculas;

        String Hilera = hilera;

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
      
        return listaPeli;
    }

    public boolean determineSiExisteHilera(ArbolPeliculas arbol,String cat, boolean mostrarPeliculas)
    {
        boolean existe = false;
        String Hilera = cat;

        String letraAnalizar = Hilera.substring(0,1);
        int numLetraAnalizar = deNumeroLetra(letraAnalizar);
        if(numLetraAnalizar>arbol.numeroLetra)//Ej: se ingresa b(2); y si se esta en a(1) entonces se verifica que exista alguien mayor que a y se manda b al siguiete
        {

            if(arbol.letraDerecha != null)
            {
                existe = arbol.determineSiExisteHilera(arbol.letraDerecha,Hilera,mostrarPeliculas);
            }
            else
            {

                existe = false;//En este caso se encuentra con un numero mayor entonces si se tiene b y se busca a, se sabe que a no existe

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
                    //Se pasa al izquierda y se analiza usando la letra que sigue

                    if(arbol.listaPeliculas != null)
                    {
                        if(mostrarPeliculas == true)
                        {
                            arbol.listaPeliculas.muestre();
                        }
                        existe = true;   
                    }

                }
                else//Se llego a una Hilera exacta
                {
                    if(arbol.letraIzquierda != null)
                    {

                        existe = arbol.determineSiExisteHilera(arbol.letraIzquierda,Hilera,mostrarPeliculas);

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

        int pos=0;
        String sub = "";
        String p = "";
        boolean siga = true;
       
        while(siga){
            try{

                pos=texto.indexOf(",");
           
              

                if(pos != -1)
                {

                    sub=texto.substring(0,pos);

                    texto=texto.substring(pos+1,texto.length());
                    
                }
                else
                {
                    
                    sub=texto;
                    
                    siga = false;
                }

                boolean existe = determineSiExisteHilera(arbol,sub,false);
                if(existe == false)
                {
                    agregueHileraNueva(arbol,sub);
                }

            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }
    }

    public ArbolPeliculas agreguePelicula(ArbolPeliculas arbol, String texto,Pelicula pelicula)//Una pelicula puede tener hilera distintas, entonces se debe ingresar una cat, y no se puede sacar de la pelicula
    {

        ArbolPeliculas arbolAGuardar = arbol;
        int pos=0;
        String sub = "";
        String p = "";
        boolean siga = true;
        
        while(siga){
            try{

                pos=texto.indexOf(",");

                if(pos != -1)
                {

                    sub=texto.substring(0,pos);

                    texto=texto.substring(pos+1,texto.length());
                }
                else
                {
                    
                    sub=texto;
                    
                    sub=texto;
                    
                    siga = false;
                }

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

        int tamanoHilera = Hilera.length();
        String letraAgregar = Hilera.substring(0,1);
        int numLetraAgregar = deNumeroLetra(letraAgregar);

        if(arbol.numeroLetra == 0)
        {

            numeroLetra = numLetraAgregar;
            Hilera = Hilera.substring(1);

            if(Hilera.isEmpty()==true)
            {
                //AgregueHilera;

            }
            else
            {

                letraAgregar = Hilera.substring(0,1);
                numLetraAgregar = deNumeroLetra(letraAgregar);

                //Se debe agregar a la izquierda 
                if(arbol.letraIzquierda == null)
                {

                    arbol.letraIzquierda = new ArbolPeliculas();
                    arbol.letraIzquierda.numeroLetra = numLetraAgregar;
                    arbol.agregueHileraNueva(arbol.letraIzquierda,Hilera);

                }
                else
                {

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

                if(arbol.letraDerecha == null)
                {

                    arbol.letraDerecha = new ArbolPeliculas();
                    arbol.letraDerecha.numeroLetra = numLetraAgregar;
                    arbol.agregueHileraNueva(arbol.letraDerecha,Hilera);
                }
                else
                {

                    if(arbol.letraDerecha.numeroLetra>numLetraAgregar)
                    {

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

                    Hilera = Hilera.substring(1);

                    if(Hilera.isEmpty()==true)
                    {
                        //AgregueHilera;

                    }
                    else
                    {

                        letraAgregar = Hilera.substring(0,1);

                        numLetraAgregar = deNumeroLetra(letraAgregar);

                        if(arbol.letraIzquierda == null)
                        {

                            arbol.letraIzquierda = new ArbolPeliculas();
                            arbol.letraIzquierda.numeroLetra= numLetraAgregar;
                            arbol.agregueHileraNueva(arbol.letraIzquierda,Hilera);

                        }
                        else
                        {

                            if(arbol.letraIzquierda.numeroLetra>numLetraAgregar)
                            {

                                ArbolPeliculas letraIzquierdaTemp = arbol.letraIzquierda;

                                arbol.letraIzquierda = new ArbolPeliculas();
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
        boolean existe = arbol.determineSiExisteHilera(arbol,"Dramas",false);
        System.out.println("Existe +"+existe);
        // arbol.agregueHilera(arbol,);

    }
}
