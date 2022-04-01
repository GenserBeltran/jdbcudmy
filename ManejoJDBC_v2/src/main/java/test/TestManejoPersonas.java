package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoPersonas {

    public static void main(String[] args) {

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            PersonaDAO personaDao = new PersonaDAO();

            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(2);
            cambioPersona.setNombre("Juanjo");
            cambioPersona.setApellido("porta");
            cambioPersona.setEmail("jua@gmail.com");
            cambioPersona.setTelefono("994854");
            personaDao.actualizar(cambioPersona);

            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            nuevaPersona.setApellido("Ramirez");
            personaDao.insertar(nuevaPersona);

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
