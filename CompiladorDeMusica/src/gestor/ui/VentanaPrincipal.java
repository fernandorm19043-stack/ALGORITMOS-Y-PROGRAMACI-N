package gestor.ui;
import gestor.model.*;
import javax.swing.*;import java.awt.*;
public class VentanaPrincipal extends JFrame{
    public VentanaPrincipal(GestorDatos g){
        super("Gestor Música");
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,3));
        add(new PanelListas(g));
        add(new PanelArtistas(g));
        add(new PanelCanciones(g));
    }
}