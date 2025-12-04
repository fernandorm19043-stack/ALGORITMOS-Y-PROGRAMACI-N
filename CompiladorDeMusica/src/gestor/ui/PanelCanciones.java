package gestor.ui;
import gestor.model.*;
import javax.swing.*;import java.awt.*;
public class PanelCanciones extends JPanel{
    GestorDatos g;DefaultListModel<Cancion> m=new DefaultListModel<>();
    public PanelCanciones(GestorDatos g){
        this.g=g;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Canciones"));
        add(new JScrollPane(new JList<>(m)),BorderLayout.CENTER);
        JButton b=new JButton("Crear");
        add(b,BorderLayout.SOUTH);
        b.addActionListener(e->crear());
        refrescar();
    }
    void crear(){
        String t=JOptionPane.showInputDialog(this,"Título:");
        if(t==null||t.isBlank())return;
        Object[] as=g.getArtistas().toArray();
        Artista a=(Artista)JOptionPane.showInputDialog(this,"Artista:","",JOptionPane.PLAIN_MESSAGE,null,as,as.length>0?as[0]:null);
        if(a==null)return;
        g.getCanciones().add(new Cancion(t,a));
        refrescar();
    }
    void refrescar(){
        m.clear();
        for(Cancion c:g.getCanciones())m.addElement(c);
    }
}