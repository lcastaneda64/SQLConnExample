package conexionmysqlserver;
/*
    @AUTOR Luis Eduardo Castañeda Delgadillo
*/

import modelo.Estructura;
import vista.Principal;
import controlador.Control;

public class ConexionMySQLServer {

    public static void main(String[] args) {
        Estructura modelo = new Estructura();
        Principal vista = new Principal();
        Control control = new Control(modelo, vista);
        vista.setVisible(true);
    }
    
}
