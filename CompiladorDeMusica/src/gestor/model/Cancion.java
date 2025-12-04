package gestor.model;
public class Cancion{
    private String titulo;
    private Artista artista;
    public Cancion(String t,Artista a){titulo=t;artista=a;}
    public String getTitulo(){return titulo;}
    public Artista getArtista(){return artista;}
    public String toString(){return titulo+" ("+artista.getNombre()+")";}
}