/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejercicio2Anotacion;

import edu.co.sena.ejercicio1.anotaciones.Estudiante;
import edu.co.sena.ejercicio1.anotaciones.Materia;
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
 * @author admin
 */
public class MateriaApp {
    
     public MateriaApp() {
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
    public void insertarMateria() {

        Materia m1 = new Materia();
        m1.setIdMateria("1");
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
