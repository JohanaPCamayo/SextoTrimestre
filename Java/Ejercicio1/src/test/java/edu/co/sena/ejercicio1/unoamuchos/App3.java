/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejercicio1.unoamuchos;

import edu.co.sena.ejemplo1.relaciones.unoauno.Estudiante1;
import edu.co.sena.ejemplo1.relaciones.unoauno.Materia1;
import edu.co.sena.ejercici1.unoamuchos.Estudiante3;
import edu.co.sena.ejercici1.unoamuchos.Materia3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author ColsutecR
 */
public class App3 {
    @Test
    public void insertar() {

        Estudiante3 e11 = new Estudiante3();

        e11.setIdEstudiante("5041");
        e11.setNombre("Johana camayo");
        e11.setTipoDocumento("C.C");
        e11.setNumeroDocumento("1023006468");
        e11.setCorreoElectronico("jpcamayo@misena.edu.co");
        e11.setTelefono("3125124832");
        e11.setDireccion("Calle 69 B # 3-40 sur");
                
        Estudiante3 e1 = new Estudiante3();

        e1.setIdEstudiante("5");
        e1.setNombre("Maicol Chunza");
        e1.setTipoDocumento("C.C");
        e1.setNumeroDocumento("1023006468");
        e1.setCorreoElectronico("jpcamayo@misena.edu.co");
        e1.setTelefono("3125124832");
        e1.setDireccion("Calle 69 B # 3-40 sur");
        
        

        Materia3 m1 = new Materia3();
        m1.setIdMateria("011");
        m1.setNombreMateria("Matematicas");
        m1.setDescripcion("veran todas los ejercicios del algebra de baldor");

        List<Estudiante3> m = new ArrayList<>();
        m.add(e11);
        m.add(e1);
        m1.setEstudiante(m);
        
      
        e11.setMateria(m1);
        e1.setMateria(m1);
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("com.mycompany_Ejercicio1_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();
        em1.merge(m1);
        em1.getTransaction().commit();
        em1.close();
        emf1.close();    
    }
    
    @Test
    public void consulta(){
    
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("com.mycompany_Ejercicio1_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();

        
        Materia3 mt = em1.find(Estudiante3.class, "5041").getMateria();        

        em1.getTransaction().commit();
        em1.close();
        emf1.close();  
        System.out.println(mt.toString());
        for (Estudiante3 et1 : mt.getEstudiante()) {
            System.out.println(et1.toString());
        }
        
    }
}
