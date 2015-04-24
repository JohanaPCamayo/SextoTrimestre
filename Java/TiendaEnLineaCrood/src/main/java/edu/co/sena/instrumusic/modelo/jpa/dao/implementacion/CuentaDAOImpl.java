/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import static edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper.getEntityManager;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.CuentaDAO;
import edu.co.sena.instrumusiccrood.Cuenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
public class CuentaDAOImpl implements CuentaDAO{
    
    public static final String PRIMERNOMBRE= "primerNombre";
    public static final String SEGUNDONOMBRE = "segundoNombre";
    public static final String PRIMERAPELLIDO = "primerApellido";
    public static final String SEGUNDOAPELLIDO= "segundoApellido";

    @Override
    public void insert(Cuenta entity) {
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
    public void update(Cuenta entity) {
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
    public void delete(Cuenta entity) {
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
    public List<Cuenta> findByAll() {
       EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findAll");
        try {
           cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }

    @Override
    public List<Cuenta> findByPrimerNombre(Object primerNombre) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;

        try {
            Query query = em.createNamedQuery("Cuenta.findByPrimerNombre");
            query.setParameter(CuentaDAOImpl.PRIMERNOMBRE, primerNombre);
            cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }

    @Override
    public List<Cuenta> findBySegundoNombre(Object segundoNombre) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;

        try {
            Query query = em.createNamedQuery("Cuenta.findBySegundoNombre");
            query.setParameter(CuentaDAOImpl.SEGUNDONOMBRE, segundoNombre);
            cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }

    @Override
    public List<Cuenta> findByPrimerApellido(Object primerApellido) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;

        try {
            Query query = em.createNamedQuery("Cuenta.findByPrimerApellido");
            query.setParameter(CuentaDAOImpl.PRIMERAPELLIDO, primerApellido);
            cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }

    @Override
    public List<Cuenta> findBySegundoApellido(Object segundoApellido) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;

        try {
            Query query = em.createNamedQuery("Cuenta.findBySegundoApellido");
            query.setParameter(CuentaDAOImpl.SEGUNDOAPELLIDO, segundoApellido);
            cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }
}
