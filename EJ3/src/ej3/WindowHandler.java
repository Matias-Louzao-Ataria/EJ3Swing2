package ej3;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class WindowHandler extends WindowAdapter{
    private Clase c;

    public WindowHandler(Clase c) {
        super();
        this.c = c;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int select = JOptionPane.showConfirmDialog(this.c, "¿Quieres cerrar el programa?");
        if(select == 0){
            this.c.dispose();
        }
    }

}