package dataBase;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Registro {
  private JButton conectarABaseDeButton;
  private JPanel panel1;
  private JTextField txtNombre;
  private JTextField txtTelefono;
  private JComboBox comboFacultad;
  private JButton btnRegistrar;

  public Registro() {
    btnRegistrar.addActionListener(e -> {
      try {
// CREAMOS LA VARIABLE CONEXION PARA HACER LA CONEXION
        Connection conexion = conectar.conectar();

// CON PREPAREDSTATEMENT LE DECIMOS QUE VAMOS A INSERTAR CON UNA SENTENCIA SQL(INSERTAR EN EMPLEADOS VALOR)
        PreparedStatement insertar = conexion.prepareStatement("insert into empleados values(?,?,?,?)");


// LLAMAMOS A LA VARIABLE PREPAREDSTATEMENT LLAMADA INSERTAR Y CON .SETSTRING LE PASAMOS EL INDICE DEL
// ELEMENTO Y EL VALOR Y CUANDO TERMINAMOS DE PASAR LOS VALORES LLAMAMOS AL METODO EXECUTEUPDATE
        insertar.setString(1,"0");
        insertar.setString(2,txtNombre.getText().trim());
        insertar.setString(3,txtTelefono.getText().trim());
        insertar.setString(4, comboFacultad.getSelectedItem().toString());
        insertar.executeUpdate();

// ACA LE ENVIAMOS UN MENSAJE INFORMANDO DATOS REGISTRADOS
        JOptionPane.showMessageDialog(null,"Datos registrados");

//CERRAMOS LA CONEXION
        conectar.cerrarConexion();

      }catch (Exception ex){
        JOptionPane.showMessageDialog(null,"error: " + ex);
      }
    });


// LIMPIAMOS LOS CAMPOS DEL FORM
    btnActualizar.addActionListener((e)->{
        txtNombre.setText("");
        txtTelefono.setText("");
        comboFacultad.setSelectedIndex(0);
    });
  }



  private JButton btnActualizar;
  Conexion conectar = Conexion.getInstance();


public static void main(String[] args) {
    JFrame frame = new JFrame("Registro");
    frame.setContentPane(new Registro().panel1);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

}
