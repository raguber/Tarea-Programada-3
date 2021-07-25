/**
 * Esta clase guarda peliculas ordenadas por hileras, donde las hileras pueden ser categorias, paises, entre otros,
 * Usa un valor asignado a caracteres de hileras alfabeticas para organizar el arbol
 * El funcionamiento del arbol basicamente se reduce a agregar a la derecha los valores mayores que un valor determinado, donde un valor derecho es un valor que se excluye cuando se compararan dos numero
 * Si se encuentra un valor igual se va a la izquierda, se corta la hilera, para ir guardando categorias por numeros segun cada caracter.
 * El arbol funciona con numeros, sin embargo, el guardado de lo "filtrado" se guarda tal y como se ingreso en una listaSimple, con objetos Pelicuña
 * 
 * @author Randy Agüero B90082, Frayvin Alvarado B60292 y Andrés Serrano C07483
 * @version 24/7/2021
 *
 */
public class ArbolPeliculas
{
    int numeroLetra;
    ArbolPeliculas letraIzquierda;
    ArbolPeliculas letraDerecha;
    ListaPeliculas listaPeliculas;
    /**
     * Constructor de ArbolPeliculas, deja valores nulos;
     */
    ArbolPeliculas()
    {
        numeroLetra = 0;
        letraIzquierda = null;
        letraDerecha = null;
        listaPeliculas = null;
    }

    /**
     * Este metodo es usado para mostrar un arbol por filtradado,
     * Por ejemplo para mostrar categorias
     * @para arbol Este es el arbol a modificar
     * @param mostrarPeliculas Este es usado para ver si se muestra cada pelicula;
     */
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

    /**
     * Este metodo agrega a un arbol una pelicula en una lista
     * 
     * @param arbol Este es el arbol que se va a modificar
     * @param hil Hilera que se va a ir desintegrando para ordenar el arbol
     * @param pelicula Esta es la pelicula que se agregaria
     * @param hil Hilera que se va a guardar en la lista de peliculas tal y como se ingreso.
     * 
     */
    public void agreguePeliculaLista(ArbolPeliculas arbol,String hil,Pelicula pelicula,String hileraExacta)
    {
        String Hilera = hil;
        String letraAnalizar = Hilera.substring(0,1);
        int numLetraAnalizar = deNumeroLetra(letraAnalizar);
        if(numLetraAnalizar>arbol.numeroLetra)
        {
            arbol.agreguePeliculaLista(arbol.letraDerecha,Hilera,pelicula,hileraExacta);
        }
        else
        {
            if(numLetraAnalizar==arbol.numeroLetra)
            {
                Hilera = Hilera.substring(1);
                if(Hilera.isEmpty() == true)
                {
                    if(arbol.listaPeliculas == null)
                    {
                        arbol.listaPeliculas = new ListaPeliculas(hileraExacta);
                    }
                    arbol.listaPeliculas.agregue(pelicula);
                }
                else
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

    /**
     * Este metodo permite editar una categoria de un conjunto de peliculas
     * 
     * @param arbol Este es el arbol al que se le guardara la pelicula
     * @param hilersExis Esta es la hilera que existe previamente guardada
     *        se tomara una lista de peliculas con la palabra a filtrar. 
     * @param nuevHilera Este es la nueva hilera que se le puede agregar a las peliculas (categorias);
     */
    public void editeCategoria(ArbolPeliculas arbol,String hileraExis, String nuevHilera )
    {
        boolean existeCategoria = determineSiExisteHilera(arbol,hileraExis,false);
        ListaPeliculas peliculas = new ListaPeliculas("Vacio");
        peliculas = retorneListaPeliculas(arbol,hileraExis);
        agregueHileraNueva(arbol,nuevHilera);
        editeCategoriaPeliculas(arbol,peliculas, nuevHilera);
    }

    /**
     * Este metodo dado va seleccionando pelicula por pelicula y la va a agregando a una nueva categoria
     * 
     * @param arbol Este es el arbol a que se le agregara las peliculas con nuevo filtrado
     * @param peliculas Lista de peliculas a agregarles una nueva categoria
     * @param nuevHil Nueva categoria para peliculas ya seleccionadas.
     *
     */
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
                masPeliculas = false;
            }
            peliculas = peliculas.peliculaDerecha;
        }
        arbol.determineSiExisteHilera(arbol,nuevHil, true);
    }

    /**
     *Este metodo devuelte una lista de peliculas dada una hilera
     *
     * @param arbol Este es el arbol al que se le solicita una lista de peliculas
     * @param hilera Hilera que determinara cual lista se devolvera
     * @return listaPeli Lista de peliculas que se encontro dada una hilera
     */
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
            if(numLetraAnalizar==arbol.numeroLetra)
            {
                Hilera = Hilera.substring(1);
                if(Hilera.isEmpty() == true)
                {
                    listaPeli = arbol.listaPeliculas;
                }
                else
                {
                    listaPeli = letraIzquierda.retorneListaPeliculas(arbol.letraIzquierda,Hilera);
                }
            }
        }
        return listaPeli;
    }

    /**
     * Este metodo determina si dada una hilera existen peliculas agregadas
     * @param arbol Este es el arbol al que se le buscara la existencia de peliculas
     * @param hil Esta es la hilera que funciona como filtradado, esta se va descomponiendo
     * @boolean mostrarPeliculas Este booleano permite mostrar si se le muestra o no las peliculas en caso de existencia dada una hilera
     * @return existe Este valor sera true o false dependiendo de si existen peliculas con una categoria dada
     * 
     */
    public boolean determineSiExisteHilera(ArbolPeliculas arbol,String hil, boolean mostrarPeliculas)
    {
        boolean existe = false;
        String Hilera = hil;
        String letraAnalizar = Hilera.substring(0,1);
        int numLetraAnalizar = deNumeroLetra(letraAnalizar);
        if(numLetraAnalizar>arbol.numeroLetra)
        {
            if(arbol.letraDerecha != null)
            {
                existe = arbol.determineSiExisteHilera(arbol.letraDerecha,Hilera,mostrarPeliculas);
            }
            else
            {
                existe = false;
            }
        }
        else
        {
            if(numLetraAnalizar==arbol.numeroLetra)
            {
                Hilera = Hilera.substring(1);
                if(Hilera.isEmpty() == true)
                {
                    if(arbol.listaPeliculas != null)
                    {
                        if(mostrarPeliculas == true)
                        {
                            arbol.listaPeliculas.muestre();
                        }
                        existe = true;   
                    }
                }
                else
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
            else
            {
                existe=false;
            }
        }
        return existe;
    }

    /**
     * Este metodo llamada a otro metodo para que vaya mandando diferentes hileras, dada la division previa de estas
     * 
     * @param arbol Arbol a agregarle hileras
     * @param texto Texto a dividir para posteriormente enviar al arbol
     */
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

    /**
     * Este metodo funciona para agregar una pelicula dada una hilera definida
     * 
     * @param arbol Arbol a ser agregada una pelicula
     * @param texto a ser usado para dividir el texto en pequeños trozos y agregar peliculas en los lugares correspondientes
     * @param pelicula pelicula a ser guardada en un lugar del arbol dada una hilera
     * @return arbolAGuardad devuelve el arbol con la pelicula guardad
     * 
     */
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
                    siga = false;
                }
                agreguePeliculaLista(arbol,sub,pelicula,sub);
            }catch(StringIndexOutOfBoundsException e){
                siga=false;
            }
        }
        return arbolAGuardar;
    }

    /**
     * Este metodo agrega una hilera en el arbol, la hilera se va descomponiendo por letras (guardadas como numeros)
     * el metodo determina si un numero es igual a otro , en caso de ser igual se agrega a la izquierda y se va desintegrando la hilera
     * En caso de ser mayo una letra a agregar y una letra se envia la hilera a la derecha, y se continua el mismo procedimiento
     * 
     * @param arbol Este arbol es al que se le va a agregar una hilera
     * @param cat Esta es la hilera a agregar
     */

    public void agregueHileraNueva(ArbolPeliculas arbol,String hil)
    {
        String Hilera = hil;
        int tamanoHilera = Hilera.length();
        String letraAgregar = Hilera.substring(0,1);
        int numLetraAgregar = deNumeroLetra(letraAgregar);
        if(arbol.numeroLetra == 0)
        {
            numeroLetra = numLetraAgregar;
            Hilera = Hilera.substring(1);
            if(Hilera.isEmpty()==true)
            {

            }
            else
            {
                letraAgregar = Hilera.substring(0,1);
                numLetraAgregar = deNumeroLetra(letraAgregar);
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

    /**
     * Este metodo devuelve un valor numero determinado, de acuerdo a un caracter
     * Se envia un numero del 1 al 27 si es una letra, 28 si es un espacio y 30 en cualquier otro caso
     */

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
    }
}