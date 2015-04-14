/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejercicio1.relacion.unoauno;

import edu.co.sena.ejemplo1.relaciones.unoauno.Estudiante1;
import edu.co.sena.ejemplo1.relaciones.unoauno.Materia1;
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
public class unoauno1 {
  
  
   
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
    public void insertar() {

        Estudiante1 e11 = new Estudiante1();

        e11.setIdEstudiante("5041");
        e11.setNombre("Johana camayo");
        e11.setTipoDocumento("C.C");
        e11.setNumeroDocumento("1023006468");
        e11.setCorreoElectronico("jpcamayo@misena.edu.co");
        e11.setTelefono("3125124832");
        e11.setDireccion("Calle 69 B # 3-40 sur");
        

        Materia1 m1 = new Materia1();
        m1.setIdMateria("011");
        m1.setNombreMateria("Matematicas");
        m1.setDescripcion("veran todas los ejercicios del algebra de baldor");

        e11.setMateria(m1);
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("com.mycompany_Ejercicio1_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();
        em1.merge(e11);
        em1.getTransaction().commit();
        em1.close();
        emf1.close();    
    }
    
    @Test
    public void consulta(){
    
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("com.mycompany_Ejercicio1_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();

        Estudiante1 et = em1.find(Materia1.class, "011").getEstudiante();
        Materia1 mt = em1.find(Estudiante1.class, "5041").getMateria();        

        em1.getTransaction().commit();
        em1.close();
        emf1.close();  
        System.out.println(et.toString());
        System.out.println(mt.toString());
    }
}
