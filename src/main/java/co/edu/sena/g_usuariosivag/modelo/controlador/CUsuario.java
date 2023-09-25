package co.edu.sena.g_usuariosivag.modelo.controlador;

import co.edu.sena.g_usuariosivag.modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import co.edu.sena.g_usuariosivag.modelo.controlador.conexion;
import javax.swing.JTable;

public class CUsuario {

       
    
    public void insertarUsuario (Usuario e) {
        try {
            Statement st = conexion.getConect().createStatement();
            st.execute("insert into usuario values ( '"+e.getIdusuario()+"','"+e.getNombre()+"','"+e.getApellido()+"','"+e.getCedula()+"','"+e.getTelefono()+"','"+e.getDireccion()+"','"+e.getEmail()+"')");
            JOptionPane.showMessageDialog(null,"Usuario Insertado");
        }
        catch (SQLException ex) {
            Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null,"problemas");
            
        }
      
            
    }
    
    public ResultSet consultarUsuarios() {
    ResultSet rs = null;

    try {
        Statement st = conexion.getConect().createStatement();
        rs = st.executeQuery("SELECT * FROM usuario");
    } catch (SQLException ex) {
        Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
}

public void actualizarUsuario(Usuario e) {
    try {
        Statement st = conexion.getConect().createStatement();
        String sql = "UPDATE usuario SET nombre='" + e.getNombre() + "', apellido='" + e.getApellido() + "', cedula='" + e.getCedula() + "', telefono='" + e.getTelefono() + "', direccion='" + e.getDireccion() + "', email='" + e.getEmail() + "' WHERE idusuario='" + e.getIdusuario() + "'";
        st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Usuario Actualizado");
    } catch (SQLException ex) {
        Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Problemas, no se actualizó el usuario");
    }
}

public void eliminarUsuario(int idusuario) {
    try {
        Statement st = conexion.getConect().createStatement();
        st.execute("DELETE FROM usuario WHERE idusuario='" + idusuario + "'");
        JOptionPane.showMessageDialog(null, "Usuario Eliminado");
    } catch (SQLException ex) {
        Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Problemas, no se eliminó el usuario");
    }
}



    public void pintarTabla(JTable tabla, ResultSet rs) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Idusuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cedula");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        modelo.addColumn("Email");

        try {
            while (rs.next()) {
                String[] fila = {
                    rs.getString("Idusuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("cedula"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("email")
                };
                modelo.addRow(fila);
            }

            tabla.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

