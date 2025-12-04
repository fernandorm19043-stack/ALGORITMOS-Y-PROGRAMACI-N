package gestor.model;
import java.util.*;
public class Coleccion{
    private String nombre;
    private List<Cancion> canciones=new ArrayList<>();
    public Coleccion(String n){nombre=n;}
    public String getNombre(){return nombre;}
    public void agregarCancion(Cancion c){if(c!=null)canciones.add(c);}
    public List<Cancion> getCanciones(){return canciones;}
    public String toString(){return nombre+" ("+canciones.size()+" canciones)";}
}