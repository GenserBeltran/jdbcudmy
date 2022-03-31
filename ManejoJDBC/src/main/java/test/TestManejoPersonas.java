package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        Persona personaNueva = new Persona("Carlos", "Esparza", "carspa@gail.com", "2534213");
        personaDao.insertar(personaNueva);

        List<Persona> personas = personaDao.seleccionar();
        for (Persona persona : personas) {
            System.out.println("Personas: " + persona);
        }
    }
}
