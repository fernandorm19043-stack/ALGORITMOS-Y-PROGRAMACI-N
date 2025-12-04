package gestor.ui;
import gestor.model.*;
import javax.swing.*;import java.awt.*;
public class PanelListas extends JPanel{
    DefaultListModel<Coleccion> model=new DefaultListModel<>();
    JList<Coleccion> list=new JList<>(model);
    GestorDatos g;
    public PanelListas(GestorDatos g){
        this.g=g;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Listas"));
        add(new JScrollPane(list),BorderLayout.CENTER);
        JPanel p=new JPanel(new GridLayout(4,1));
        JButton c=new JButton("Crear"), a=new JButton("Agregar Canción"), r=new JButton("Refrescar"), v=new JButton("Ver canciones");
        p.add(c);p.add(a);p.add(r);p.add(v);
        add(p,BorderLayout.SOUTH);
        c.addActionListener(e->crear());
        a.addActionListener(e->agregar());
        r.addActionListener(e->refrescar());
        v.addActionListener(e->ver());
        refrescar();
    }
    void crear(){
        String n=JOptionPane.showInputDialog(this,"Nombre:");
        if(n!=null&&!n.isBlank()){g.getListas().add(new Coleccion(n));refrescar();}
    }
    void agregar(){
        Coleccion sel=list.getSelectedValue();
        if(sel==null){JOptionPane.showMessageDialog(this,"Seleccione lista");return;}
        Object[] cs=g.getCanciones().toArray();
        Cancion c=(Cancion)JOptionPane.showInputDialog(this,"Canción:","",JOptionPane.PLAIN_MESSAGE,null,cs,cs.length>0?cs[0]:null);
        if(c!=null) sel.agregarCancion(c);
    }
    void ver(){
        Coleccion s=list.getSelectedValue();
        if(s==null){JOptionPane.showMessageDialog(this,"Seleccione lista");return;}
        DefaultListModel<String> m=new DefaultListModel<>();
        for(Cancion c:s.getCanciones())m.addElement(c.toString());
        JDialog d=new JDialog((Frame)null,"Canciones",true);
        d.add(new JScrollPane(new JList<>(m)));
        d.setSize(300,400);d.setLocationRelativeTo(this);d.setVisible(true);
    }
    void refrescar(){
        model.clear();
        for(Coleccion c:g.getListas()) model.addElement(c);
    }
}