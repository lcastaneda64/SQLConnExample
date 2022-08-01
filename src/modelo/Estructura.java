package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
    @AUTOR Luis Eduardo Castañeda Delgadillo
*/

public class Estructura {

    private static Connection conexionMySQL = null;
    private static String bddMySQL = "ejemplo";
    private static String bduserMySQL = "root";
    private static String bdpassMySQL = "SQL9551F3894E";
    private static String urlMySQL = "jdbc:mysql://localhost/" + bddMySQL;
    
    private static Connection conexionSQLServer = null;
    private static String bddSQLServer = "Ejemplo";
    private static String bduserSQLServer = "Eddy6413";
    private static String bdpassSQLServer = "SQL9551F3894E";
    private static String urlSQLServer = "jdbc:sqlserver://Eddy6413\\SQLEXPRESS:1433;databaseName=" + bddSQLServer;
    /*jdbc:sqlserver://Eddy6413\SQLEXPRESS:1433;databaseName=Ejemplo;user=Eddy6413;password=SQL9551F3894E*/
    public void conectarMySQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexionMySQL = (Connection) DriverManager.getConnection(urlMySQL,bduserMySQL,bdpassMySQL);
            
            if(conexionMySQL  != null){
                JOptionPane.showMessageDialog(null,"MYSQL: Conexión Exitosa");
            }
            
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println(ex);
            }
    }
    
    public void conectarSQLServer(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexionSQLServer = (Connection) DriverManager.getConnection(urlSQLServer, bduserSQLServer, bdpassSQLServer);
            
            if(conexionSQLServer  != null){
                JOptionPane.showMessageDialog(null,"SQL Server: Conexión Exitosa");
            }
            
            }catch(ClassNotFoundException | SQLException ex){
                System.out.println(ex);
            }
    }
    
    public void cerrarConexion(Connection con, PreparedStatement sql){
        try {
            con.close();
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarMySQL(String texto){
        try {
            conectarMySQL();
            PreparedStatement sql = conexionMySQL.prepareStatement("INSERT INTO texto VALUES(DEFAULT, ?)");
            sql.setString(1, texto);
            sql.executeUpdate();
            cerrarConexion(conexionMySQL, sql);
        } catch (SQLException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarSQLServer(String texto){
        try {
            conectarSQLServer();
            PreparedStatement sql = conexionSQLServer.prepareStatement("INSERT INTO texto VALUES(?)");
            sql.setString(1, texto);
            sql.executeUpdate();
            cerrarConexion(conexionSQLServer, sql);
        } catch (SQLException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bajasMySQL(String texto){
        try {
            conectarMySQL();
            PreparedStatement sql = conexionMySQL.prepareStatement("DELETE FROM texto WHERE texto = ?");
            sql.setString(1, texto);
            sql.executeUpdate();
            cerrarConexion(conexionMySQL, sql);
        } catch (SQLException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bajasSQLServer(String texto){
        try {
            conectarSQLServer();
            PreparedStatement sql = conexionSQLServer.prepareStatement("DELETE FROM texto WHERE texto = ?");
            sql.setString(1, texto);
            sql.executeUpdate();
            cerrarConexion(conexionSQLServer, sql);
        } catch (SQLException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiosMySQL(int ID, String texto){
        try {
            conectarMySQL();
            PreparedStatement sql = conexionMySQL.prepareStatement("UPDATE texto SET texto = ? WHERE ID = ?");
            sql.setString(1, texto);
            sql.setInt(2, ID);
            sql.executeUpdate();
            cerrarConexion(conexionMySQL, sql);
        } catch (SQLException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiosSQLServer(int ID, String texto){
        try {
            conectarSQLServer();
            PreparedStatement sql = conexionSQLServer.prepareStatement("UPDATE texto SET texto = ? WHERE ID = ?");
            sql.setString(1, texto);
            sql.setInt(2, ID);
            sql.executeUpdate();
            cerrarConexion(conexionSQLServer, sql);
        } catch (SQLException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
