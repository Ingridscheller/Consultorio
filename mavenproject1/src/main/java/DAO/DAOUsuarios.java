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
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contraseña"));
                usuario.setGenero(rs.getString("genero"));
                usuario.setIdUsuarios(rs.getInt(0));
                

                usuarios.add(usuario);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error en DAOUsuaios.consultarUsuarios: " + ex.getMessage());
            return null;
        }

    }

    public int insertarUsuarios(TOUsuarios usuario) {
        String[] valores = {usuario.getTipoUsuario(), usuario.getNombres(), usuario.getApellidos(), usuario.getTipoIdentificacion(), usuario.getNumeroIdentificacion(), usuario.getFechaNacimiento().toString(), usuario.getTelefono(), usuario.getDireccion(), usuario.getUsuario(), usuario.getContrasena(), usuario.getGenero()};
        try{
        return con.insertar(nombreTabla, valores);
        }catch(Exception ex){
            System.out.println("Error en DAOUsuarios.insertarUsuarios: " + ex.getMessage());
            return 0;
        }
    }
    
      public boolean modificarUsuarios(TOUsuarios usuario) {
        String[] valores = {usuario.getTipoUsuario(), usuario.getNombres(), usuario.getApellidos(), usuario.getTipoIdentificacion(), usuario.getNumeroIdentificacion(), usuario.getFechaNacimiento().toString(), usuario.getTelefono(), usuario.getDireccion(), usuario.getUsuario(), usuario.getContrasena(), usuario.getGenero()};
        try {
            return con.actualizar(nombreTabla, valores, usuario.getIdUsuarios());
          }catch(Exception ex){
            System.out.println("Error en DAOUsuarios.modificarUsuarios: " + ex.getMessage());
            return false;
        }
      }
        
        public boolean eliminarUsuarios(int id) {
        try {
            return con.eliminar(nombreTabla,id);
          }catch(Exception ex){
            System.out.println("Error en DAOUsuarios.modificarUsuarios: " + ex.getMessage());
            return false;
        }
        }
        
    }
    
    
    



