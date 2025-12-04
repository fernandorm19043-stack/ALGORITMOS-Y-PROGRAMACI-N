package gestor.ui;
import gestor.model.*;
import javax.swing.*;import java.awt.*;
public class PanelArtistas extends JPanel{
    GestorDatos g;DefaultListModel<Artista> m=new DefaultListModel<>();
    public PanelArtistas(GestorDatos g){
        this.g=g;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Artistas"));
        add(new JScrollPane(new JList<>(m)),BorderLayout.CENTER);
        JButton b=new JButton("Crear");
        add(b,BorderLayout.SOUTH);
        b.addActionListener(e->crear());
        refrescar();
    }
    void crear(){
        String n=JOptionPane.showInputDialog(this,"Nombre:");
        if(n!=null&&!n.isBlank()){g.getArtistas().add(new Artista(n));refrescar();}
    }
    void refrescar(){
        m.clear();
        for(Artista a:g.getArtistas())m.addElement(a);
    }
}