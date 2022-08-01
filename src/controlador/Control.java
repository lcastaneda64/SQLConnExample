package controlador;
/*
    @AUTOR Luis Eduardo Castañeda Delgadillo
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Estructura;
import vista.Principal;

public class Control implements ActionListener{
    
    private Estructura modelo;
    private Principal vista;
    
    public Control(Estructura modelo, Principal vista){
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setLocationRelativeTo(null);
        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnCambiar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.vista.btnInsertar)){
            this.modelo.registrarMySQL(this.vista.txtTexto.getText());
            this.modelo.registrarSQLServer(this.vista.txtTexto.getText());
            
        }else if(e.getSource().equals(this.vista.btnEliminar)){
            this.modelo.bajasMySQL(this.vista.txtTexto.getText());
            this.modelo.bajasSQLServer(this.vista.txtTexto.getText());
        }else if(e.getSource().equals(this.vista.btnCambiar)){
            this.modelo.cambiosMySQL(Integer.parseInt(this.vista.txtID.getText()), this.vista.txtTexto.getText());
            this.modelo.cambiosSQLServer(Integer.parseInt(this.vista.txtID.getText()), this.vista.txtTexto.getText());
        }
    }
    
}
