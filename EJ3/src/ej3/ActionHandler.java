package ej3;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
                añadir(opciones);
                this.c.cbA.setSize(this.c.cbA.getPreferredSize());
            }
        } else if (arg0.getSource() == this.c.btnQuitar) {
            if (this.c.txf2.getText().trim().length() == 0) {
                this.c.cbA.removeItem(this.c.cbA.getSelectedItem());
                this.c.cbA.setSize(this.c.cbA.getPreferredSize());
            } else {
                this.c.txf2.setSize(this.c.txf2.getPreferredSize());
                int tamaño = this.c.cbA.getItemCount();
                for (int i = tamaño - 1; i >= 0; i--) {
                    if ((this.c.cbA.getItemAt(i)).toString().contains(this.c.txf2.getText())) {
                        this.c.cbA.removeItem(this.c.cbA.getItemAt(i));
                        System.out.println(i);
                    }
                }
                this.c.cbA.setSize(this.c.cbA.getPreferredSize());
                this.c.cbA.setSelectedIndex(0);
            }
        } else {
            if (arg0.getSource() == this.c.btnTraspasar) {
                if (this.c.cbA.getSelectedIndex() != -1) {
                    traspasar(this.c.cbA, this.c.cbB);
                } else {
                    JOptionPane.showMessageDialog(this.c, "El combobox de origen está vacio!");
                }
            } else {
                if (this.c.cbB.getSelectedIndex() != -1) {
                    traspasar(this.c.cbB, this.c.cbA);
                } else {
                    JOptionPane.showMessageDialog(this.c, "El combobox de origen está vacio!");
                }
            }
        }
        this.c.timer.restart();
    }

    private void añadir(ArrayList<String> opciones) {
        String res;
        res = this.c.txf1.getText().replace(" ;", "");
        res = res.replace(" ;", "");
        res = res.replace(";;", "");

        if (res.charAt(0) == ';') {
            res = res.substring(1, res.length());
        }

        for (int j = 0; j < res.split(";").length; j++) {
            this.c.cbA.addItem(res.split(";")[j]);
        }
    }

    private void traspasar(JComboBox<String> origen, JComboBox<String> destino) {
        destino.addItem(origen.getSelectedItem().toString());
        origen.removeItem(origen.getSelectedItem());
        origen.setSize(origen.getPreferredSize());
        destino.setSize(destino.getPreferredSize());
    }

}