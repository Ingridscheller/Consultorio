package DAO;

import TO.TOUsuarios;
import db.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOUsuarios {

    private final ConexionDB con;
    private final String nombreTabla;

    public DAOUsuarios() {
        this.nombreTabla = " Usuarios";
        con = new ConexionDB();
        con.getconnection();

    }

    public ArrayList<TOUsuarios> consultarUsuarios() {
        TOUsuarios usuario;
        ArrayList<TOUsuarios> usuarios = new ArrayList<>();
        try {
            ResultSet rs = con.consultar("Usuarios");
            while (rs.next()) {
                usuario = new TOUsuarios();
                usuario.setTipoUsuario(rs.getString("tipoUsuario"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                usuario.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
                usuario.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDirección(rs.getString("direccion"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setGenero(rs.getString("genero"));
                usuario.setIdUsuarios(rs.getInt(0));

                usuarios.add(usuario);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error en DAOUsuaios.consultarUsuarios" + ex.getMessage());
            return null;
        }
    }

    public int insertarUsuarios(TOUsuarios usuario) {
        String[] valores = {usuario.getTipoUsuario(), usuario.getNombres(), usuario.getApellidos(), usuario.getTipoIdentificacion(), usuario.getNumeroIdentificacion(), usuario.getFechaNacimiento().toString(), usuario.getTelefono(), usuario.getDirección(), usuario.getUsuario(), usuario.getContraseña(), usuario.getGenero()};
        try {
           
            return con.insertar(nombreTabla, valores);
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuaios.consultarUsuarios" + ex.getMessage());
            return 0;
        }
    }

    public int modificarUsuarios(TOUsuarios usuario) {
        String[] valores = {usuario.getTipoUsuario(),usuario.getNombres(), usuario.getApellidos(), usuario.getTipoIdentificacion(), usuario.getNumeroIdentificacion(), usuario.getFechaNacimiento().toString(), usuario.getTelefono(), usuario.getDirección(), usuario.getUsuario(), usuario.getContraseña(), usuario.getGenero()};
        
        try {
            return con.actualizar(nombreTabla, valores);
        } catch (Exception ex) {
            System.out.println("Error en DAOUsuaios.consultarUsuarios" + ex.getMessage());
            return 0;
        }
    }

    public boolean eliminarUsuarios(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    
    
    
    
    


