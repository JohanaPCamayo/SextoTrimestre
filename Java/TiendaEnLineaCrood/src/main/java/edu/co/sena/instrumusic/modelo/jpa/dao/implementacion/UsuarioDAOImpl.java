/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.UsuarioDAO;
import edu.co.sena.instrumusiccrood.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    public static final String CONTRASENA = "contrasena";
    public static final String ROL = "rol";
    public static final String ESTADO = "estado";
    public static final String EMAIL = "email";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Usuario entity) {
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
    public void update(Usuario entity) {
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
    public void delete(Usuario entity) {
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
    public Usuario findByIdUsuario() {
        EntityManager em = getEntityManager();
        Usuario usuarioTemporal = null;
        try {
            usuarioTemporal = em.find(Usuario.class, findByIdUsuario().getIdUsuario());
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return usuarioTemporal;

    }

    @Override
    public List<Usuario> findByAll() {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;
        Query query = em.createNamedQuery("Usuario.findAll");
        try {
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByContrasena(Object contrasena) {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;

        try {
            Query query = em.createNamedQuery("Usuario.findByContrasena");
            query.setParameter(UsuarioDAOImpl.CONTRASENA, contrasena);
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByRol(Object rol) {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;

        try {
            Query query = em.createNamedQuery("Usuario.findByRol");
            query.setParameter(UsuarioDAOImpl.ROL, rol);
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByEstado(Object estado) {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;

        try {
            Query query = em.createNamedQuery("Usuario.findByEstado");
            query.setParameter(UsuarioDAOImpl.ESTADO, estado);
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByEmail(Object email) {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;
        try {
            Query query = em.createNamedQuery("Usuario.findByEmail");
            query.setParameter(UsuarioDAOImpl.EMAIL, email);
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }
}
