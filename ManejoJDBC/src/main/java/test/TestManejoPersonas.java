package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

//        Persona personaNueva = new Persona("Carlos", "Esparza", "carspa@gail.com", "2534213");
//        personaDao.insertar(personaNueva);

           //Modificando un objeto de la persona existente
           Persona personaModificar = new Persona(5, "Juan Carlos", "Esparxa", "JuanExpa@gmail.com", "454841");
           personaDao.actualizar(personaModificar);
           
        List<Persona> personas = personaDao.seleccionar();
        for (Persona persona : personas) {
            System.out.println("Personas: " + persona);
        }
    }
}
