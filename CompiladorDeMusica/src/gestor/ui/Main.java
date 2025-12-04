package gestor.ui;
import gestor.model.*;
import javax.swing.SwingUtilities;

public class Main{
    public static void main(String[]args){
        SwingUtilities.invokeLater(()->{
            GestorDatos g=new GestorDatos();
            g.cargarDesdeArchivo("data.txt");
            new VentanaPrincipal(g).setVisible(true);
        });
    }
}