package test;

import datos.Conexion;
import datos.UsuarioDao;
import datos.UsuarioDaoJDBC;
import domain.UsuarioDTO;
import java.sql.*;
import java.util.List;

public class TestManejoUsuarios {

    public static void main(String[] args) {

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            
            UsuarioDao usuarioDao = new UsuarioDaoJDBC();
            
            List<UsuarioDTO> usuarios = usuarioDao.select();
            
            for (UsuarioDTO usuario : usuarios) {
                System.out.println("Usuarios DTO: " + usuario);
            }
           
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
