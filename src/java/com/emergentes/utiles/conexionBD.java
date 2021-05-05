package com.emergentes.utiles;
import java.sql.*;
public class conexionBD {
    static String url = ":dbc:mysgl://localhost:3306/bd_anuncios"; 
    static String usuario = "root"; 
    static String passvord = ""; 
protected Connection conn = null; 
public conexionBD() { 
    try { 
   conn = DriverManager.getConnection(url, usuario, passvord);
if (conn != null) { 
    System.out.println("Cznexion Ck: " + conn);
} 
} catch (SQLException ex){
    System.out.println("error SQL: " + ex.getMessage());
} 
}
public Connection conectar() { 
return conn; 
}
public void desconectar() 
{
System.out.println("Cerrando la BD: + conn"); 
 try { 
     conn.close(); }
 catch (SQLException ex)      
 {System.out.println("Error de SQL: " + ex.getMessage()); 
} 
}
}
