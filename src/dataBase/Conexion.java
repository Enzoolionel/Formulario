//CONEXION A BASE DE DATOS CON DRIVER SQL.

package dataBase;
// IMPORTAMOS SQL A LA CLASE.
import javax.swing.*;
import java.sql.*;

public class Conexion {
//  CREAMOS LA VARIABLE QUE VA A MANEJAR EL ESTADO DE LA CONEXION VA A SER
// PRIVADA ESTATICA Y DE TIPO CONNECTION QUE SE VA A LLAMAR CONEXION.
  private static Connection conexion;


//CREAMOS UNA VARIABLE PARA CREAR UNA SOLA INSTANCIA.
  private static Conexion instancia;

//CREAMOS LA VARIABLE QUE VA A CONTENER LA URL DE LA BD
  private static final String url = "jdbc:mysql://localhost/db_registros";

//CREAMOS LA VARIABLE QUE VA A CONTENER EL NOMBRE DE USUARIO DE LA BD
  private static final String userName = "root";

//CREAMOS LA VARIABLE QUE VA A CONTENER LA CONTRASEÑA DE LA BD SI ES QUE TIENE.
  private static final String password = "";



  //CREAMOS EL METODO QUE NOS CONECTA A LA BASE DE DATOS.
  public Connection conectar(){
    try {

//INFORMAMOS QUE DE LA CLASS CON NOMBRE Y LE PASAMOS EL NOMBRE
      Class.forName("com.mysql.cj.jdbc.Driver");

// A LA VARIABLE CONEXION LE PASAMOS CON DRIVERMANAGER.GERCONNECTION LOS DATOS QUE ASIGNAMOS ARRIBA
      conexion = DriverManager.getConnection(url,userName,password);
      return conexion;

    }catch (Exception e){
      JOptionPane.showMessageDialog(null,"error: " + e);
    }
      return conexion;
  }

//CREAMOS EL METODO PARA CERRAR LA CONEXION
  public void cerrarConexion() throws SQLException {
    try {
      conexion.close();
    }catch (Exception e){
      JOptionPane.showMessageDialog(null, "error: " + e);
      conexion.close();
    }finally {
      conexion.close();
    }
  }

//ACA APLICAMOS EL PATRON SINGELTON.

  private Conexion() {}
  public static Conexion getInstance(){
    if (instancia == null){
      instancia = new Conexion();
    }
    return instancia;
  }

}
