package test;

import datos.Conexion;
import datos.PersonaDao;
import datos.PersonaDaoJDBC;
import domain.PersonaDTO;
import java.sql.*;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            PersonaDao personaDao = new PersonaDaoJDBC();

            List<PersonaDTO> personas =personaDao.select();
            
            for (PersonaDTO persona : personas) {
                System.out.println("Persona DTO:" + persona);
            }

            conexion.commit();
            System.out.println("Se ha echo commit de la transaccion");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al ROllback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
