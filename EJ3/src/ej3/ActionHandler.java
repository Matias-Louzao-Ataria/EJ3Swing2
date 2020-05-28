package ej3;

import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;

public class ActionHandler implements ActionListener {

    private Clase c;

    public ActionHandler(Clase c) {
        super();
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == this.c.btnAñadir) {
            String res = "";
            ArrayList<String> opciones = new ArrayList<>();
            if (this.c.txf1.getText().trim().length() != 0) {
                tratarString(opciones);

                for (String string : opciones) {
                    this.c.cbA.addItem(string);
                    this.c.cbA.setSize(this.c.cbA.getPreferredSize());
                }
            }
        } else if (arg0.getSource() == this.c.btnQuitar) {
            if (this.c.txf2.getText().trim().length() == 0) {
                this.c.cbA.removeItem(this.c.cbA.getSelectedItem());
                this.c.cbA.setSize(this.c.cbA.getPreferredSize());
            } else {
                this.c.txf2.setSize(this.c.txf2.getPreferredSize());
                for (int i = 0; i < this.c.cbA.getItemCount(); i++) {
                    System.err.println(this.c.cbA.getItemAt(i).toString());
                    if (((String) this.c.cbA.getItemAt(i)).contains(this.c.txf2.getText())) {
                        this.c.cbA.removeItem(this.c.cbA.getItemAt(i)); 
                    }
                    this.c.cbA.setSize(this.c.cbA.getPreferredSize());
                }
            }
        } else {

        }
    }

    private void tratarString(ArrayList<String> opciones) {
        String res;
        int cont = -1;
        res = this.c.txf1.getText().replace(" ;", "");
        res = res.replace(" ;", "");
        res = res.replace(";;", "");

        for (int j = 0; j < res.length(); j++) {
            if((res.charAt(j) == ';' || j == 0) && j < res.length()-1){
                opciones.add("");
                cont++;
            }
            if(res.charAt(j) != ';'){
                opciones.set(cont, opciones.get(cont) + res.charAt(j));
            }
        }
    }

}