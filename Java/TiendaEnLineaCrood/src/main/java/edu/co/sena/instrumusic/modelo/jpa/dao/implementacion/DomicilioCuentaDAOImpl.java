/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import static edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper.getEntityManager;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.DomicilioCuentaDAO;
import edu.co.sena.instrumusiccrood.DomicilioCuenta;
import edu.co.sena.instrumusiccrood.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
public class DomicilioCuentaDAOImpl implements DomicilioCuentaDAO{
    
    public static final String TELEFONO = "telefono";
    public static final String DIRECCION = "direccion";
    public static final String BARRIO = "barrio";
    public static final String LOCALIDAD = "localidad";

    @Override
    public void insert(DomicilioCuentaDAO entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        }
    }

    @Override
    public void update(DomicilioCuentaDAO entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        }
    }

    @Override
    public void delete(DomicilioCuentaDAO entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        }
    }

   
    @Override
    public List<DomicilioCuenta> findByAll() {
        EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;
        Query  query = em.createNamedQuery("DomicilioCuenta.findAll");
        try {
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }

    @Override
    public List<DomicilioCuenta> findByTelefono(Object telefono) {
         EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;

        try {
            Query query = em.createNamedQuery("DomicilioCuenta.findByTelefono");
            query.setParameter(DomicilioCuentaDAOImpl.TELEFONO, telefono);
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }

    @Override
    public List<DomicilioCuenta> findByDireccion(Object direccion) {
         EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;

        try {
            Query query = em.createNamedQuery("DomicilioCuenta.findByDireccion");
            query.setParameter(DomicilioCuentaDAOImpl.DIRECCION, direccion);
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }

    @Override
    public List<DomicilioCuenta> findByBario(Object barrio) {
         EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;

        try {
            Query query = em.createNamedQuery("DomicilioCuenta.findByBarrio");
            query.setParameter(DomicilioCuentaDAOImpl.BARRIO, barrio);
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }

    @Override
    public List<DomicilioCuenta> findByLocalidad(Object localidad) {
        EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;

        try {
            Query query = em.createNamedQuery("DomicilioCuenta.findByLocalidad");
            query.setParameter(DomicilioCuentaDAOImpl.LOCALIDAD, localidad);
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }    
}
