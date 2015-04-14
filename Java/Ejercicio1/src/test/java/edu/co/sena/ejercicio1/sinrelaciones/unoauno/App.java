/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejercicio1.sinrelaciones.unoauno;


import edu.co.sena.ejemplo1.sinrelaciones.unoauno.Estudiante2;
import edu.co.sena.ejemplo1.sinrelaciones.unoauno.Materia2;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author ColsutecR
 */
public class App {
    @Test
    public void insertarEstudiante() {

        Estudiante2 e11 = new Estudiante2();
        e11.setIdEstudiante("504");
        e11.setNombre("Johana camayo");
        e11.setTipoDocumento("C.C");
        e11.setNumeroDocumento("1023006468");
        e11.setCorreoElectronico("jpcamayo@misena.edu.co");
        e11.setDireccion("Calle 69 B # 3-40 sur");
        e11.setTelefono("3125124832");

        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("com.mycompany_Ejercicio1_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();
        em1.merge(e11);
        em1.getTransaction().commit();
        em1.close();
        emf1.close();
    }
    
    @Test
    public void insertarMateria() {

        Materia2 m1 = new Materia2();
        m1.setIdMateria("01");
        m1.setNombreMateria("Matematicas");
        m1.setDescripcion("veran todas los ejercicios del algebra de baldor");

        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("com.mycompany_Ejercicio1_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();
        em1.merge(m1);
        em1.getTransaction().commit();
        em1.close();
        emf1.close();
    }
}
