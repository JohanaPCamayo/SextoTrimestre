/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import static edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper.getEntityManager;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.MunicipioDAO;
import edu.co.sena.instrumusiccrood.Municipio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
public class MunicipioDAOImpl implements MunicipioDAO{
    
      public static final String NOMBRE = "nombre";
    
    @Override
    public void insert(Municipio entity) {
         try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---"+er.getMessage());
        }
    }

    @Override
    public void update(Municipio entity) {
         try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---"+er.getMessage());
        }
    }

    @Override
    public void delete(Municipio entity) {
         try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---"+er.getMessage());
        }
    }

    @Override
    public Municipio findByIdMunicipio() {
        EntityManager em = getEntityManager();
        Municipio munTemporal = null;
        try {
            munTemporal = em.find(Municipio.class, findByIdMunicipio().getIdMunicipio());
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return munTemporal;
    }

    @Override
    public List<Municipio> findByAll() {
        EntityManager em = getEntityManager();
        List<Municipio> munTemporal = null;
        Query query = em.createNamedQuery("Municipio.findAll");
        try {
            munTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return munTemporal;
    }

    @Override
    public List<Municipio> findByNombre(Object nombre) {
        EntityManager em = getEntityManager();
        List<Municipio> munTemporal = null;

        try {
            Query query = em.createNamedQuery("Usuario.findByEstado");
            query.setParameter(MunicipioDAOImpl.NOMBRE, nombre);
            munTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return munTemporal;
    }

   
}
