package ej3;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class Clase extends JFrame implements ActionListener {
    
    JComboBox<String> cbA = new JComboBox<String>();
    JComboBox<String> cbB = new JComboBox<String>();
    JButton btnAñadir= new JButton("Añadir");
    JButton btnQuitar= new JButton("Quitar");
    JButton btnTraspasar= new JButton("Traspasar");
    JButton btnTranspasar2= new JButton("Traspasar2");
    JTextField txf1= new JTextField("Escribe aquí lo que quieras agragar al primer combobox");
    JTextField txf2= new JTextField("Escribe aquí lo que quieras eliminar del primer combobox");
    JLabel lbl1= new JLabel("información del primer combobox");
    JLabel lbl2= new JLabel();
    JLabel lbl3= new JLabel();
    ArrayList<Object> componentes = new ArrayList<>(); 
    Timer timer = new Timer(60000,this);
    int x = 20,y = 10;

    public Clase(){
        super("Ejercicio 3");
        this.setLayout(null);
        componentes.add(cbA);
        componentes.add(cbB);
        componentes.add(btnAñadir);
        componentes.add(btnQuitar);
        componentes.add(btnTraspasar);
        componentes.add(btnTranspasar2);
        componentes.add(txf1);
        componentes.add(txf2);
        componentes.add(lbl1);
        componentes.add(lbl2);
        componentes.add(lbl3);
        this.addWindowListener(new WindowHandler(this));
        cbA.addItemListener(new ItemHandler(this));
        cbB.addItemListener(new ItemHandler(this));
        this.btnQuitar.addMouseListener(new MouseHandler(this));
        
        for(int i = 0;i < this.componentes.size();i++){
            JComponent comp = (JComponent)this.componentes.get(i);
            comp.setSize(comp.getPreferredSize());
            comp.setLocation(x,y);
            x+=0;
            y+=40;
            try {
                JButton b = (JButton) comp;
                b.addActionListener(new ActionHandler(this));   
            } catch (ClassCastException e) {
                
            }
            comp.setToolTipText("Este es el elemento: "+(i+1));
            this.add(comp);
        }
        this.cbB.setToolTipText("Indice del elemento seleccionado: "+this.cbB.getSelectedIndex());
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.txf1.setText("Escribe aquí lo que quieras agragar al primer combobox");
        this.txf2.setText("Escribe aquí lo que quieras eliminar del primer combobox");
        this.cbA.removeAllItems();
        this.cbB.removeAllItems();
    }
}