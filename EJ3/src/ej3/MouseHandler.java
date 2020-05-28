package ej3;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class MouseHandler extends MouseAdapter {
    
    private Clase c;

    public MouseHandler(Clase c) {
        super();
        this.c = c;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == this.c.btnQuitar){
            this.c.btnQuitar.setForeground(Color.RED);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this.c.btnQuitar){
            this.c.btnQuitar.setForeground(null);
        }
    }

}