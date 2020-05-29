package ej3;

import java.awt.event.*;

public class ItemHandler implements ItemListener {
    private Clase c;

    public ItemHandler(Clase c) {
        super();
        this.c = c;
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        if(arg0.getSource() == this.c.cbA){
            this.c.lbl1.setText("Cantidad de elementos en cbA: "+this.c.cbA.getItemCount()+" \nElemento seleccionado: "+this.c.cbA.getSelectedItem());
            this.c.lbl1.setSize(this.c.lbl1.getPreferredSize());
        }else{
            this.c.cbB.setToolTipText("Indice del elemento seleccionado: "+this.c.cbB.getSelectedIndex());
        }

    }
}