package test;

import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.*;

public class TestManejoUsuarios {

    public static void main(String[] args) {

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            UsuarioDAO usuarioDao = new UsuarioDAO();

            Usuario cambioUsuario = new Usuario();
            cambioUsuario.setIdUsuario(4);
            cambioUsuario.setUsername("Juanjo");
            cambioUsuario.setPassword("ju541");
            usuarioDao.actualizar(cambioUsuario);

            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsername("Carlos");
            nuevoUsuario.setPassword("Ramirez");
            usuarioDao.insertar(nuevoUsuario);

            conexion.commit();
            System.out.println("Se ha echo commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al Rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
