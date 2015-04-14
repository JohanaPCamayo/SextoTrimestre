/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejercicio2Anotacion;

import edu.co.sena.ejercicio1.anotaciones.Estudiante;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ColsutecR
 */
public class EstudianteApp {

    public EstudianteApp() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    
    @Test
    public void insertarEstudiante() {

        Estudiante e1 = new Estudiante();
        e1.setIdEstudiante("5014");
        e1.setNombre("Johana camayo");
        e1.setTipoDocumento("C.C");
        e1.setNumeroDocumento("1023006468");
        e1.setCorreoElectronico("jpcamayo@misena.edu.co");
        e1.setDireccion("Calle 69 B # 3-40 sur");
        e1.setTelefono("3125124832");

        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("com.mycompany_Ejercicio1_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();
        em1.merge(e1);
        em1.getTransaction().commit();
        em1.close();
        emf1.close();
    }
}
