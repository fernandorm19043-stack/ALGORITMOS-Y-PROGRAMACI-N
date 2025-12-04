package gestor.model;
import java.io.*;import java.util.*;
public class GestorDatos{
    private List<Artista> artistas=new ArrayList<>();
    private List<Cancion> canciones=new ArrayList<>();
    private List<Coleccion> listas=new ArrayList<>();
    public GestorDatos(){}
    public void cargarDesdeArchivo(String ruta){
        File f=new File(ruta);
        if(!f.exists()) crearEjemplo(ruta);
        try(BufferedReader br=new BufferedReader(new FileReader(ruta))){
            String sec="",line;
            while((line=br.readLine())!=null){
                line=line.trim();
                if(line.isEmpty())continue;
                if(line.startsWith("#")){sec=line.substring(1).toUpperCase();continue;}
                switch(sec){
                    case "ARTISTAS":
                        artistas.add(new Artista(line));break;
                    case "CANCIONES":
                        String[] p=line.split("|");
                        if(p.length>=2){
                            Artista a=buscarArtista(p[1].trim());
                            if(a==null){a=new Artista(p[1].trim());artistas.add(a);}
                            canciones.add(new Cancion(p[0].trim(),a));
                        }break;
                    case "LISTAS":
                        String[] q=line.split(":");
                        Coleccion col=new Coleccion(q[0].trim());
                        if(q.length==2){
                            for(String t:q[1].split(",")){
                                Cancion c=buscarCancion(t.trim());
                                if(c!=null) col.agregarCancion(c);
                            }
                        }
                        listas.add(col);break;
                }
            }
        }catch(Exception e){e.printStackTrace();}
    }
    private void crearEjemplo(String r){
        
    }
    public Artista buscarArtista(String n){return artistas.stream().filter(a->a.getNombre().equalsIgnoreCase(n)).findFirst().orElse(null);}
    public Cancion buscarCancion(String n){return canciones.stream().filter(a->a.getTitulo().equalsIgnoreCase(n)).findFirst().orElse(null);}
    public List<Artista> getArtistas(){return artistas;}
    public List<Cancion> getCanciones(){return canciones;}
    public List<Coleccion> getListas(){return listas;}
}