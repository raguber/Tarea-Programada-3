
/**
 * Write a description of class listaPel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListaPel
{
    Pelicula peli;
    //ListaPel next;
    String categoria;
    public ListaPel(String cat){
        categoria=cat;
    }
    
    public void compare(Pelicula x){
        String cats = x.getCategoria();
        String estaCategoria;
        while(cats.length()!=0){
            int pos = cats.indexOf(",");
            estaCategoria=cats.substring(0,pos);
            if(estaCategoria.equals(categoria)){
                add(x);
                break;
            }
        }
    }
    
    public void add(Pelicula x){
        if(peli==null ){
            peli = x;
        }else if(peli!=null){
            peli.add(x);
        }
    }
}
