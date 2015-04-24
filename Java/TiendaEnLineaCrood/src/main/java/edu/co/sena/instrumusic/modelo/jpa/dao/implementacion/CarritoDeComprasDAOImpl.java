/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.CarritoDeComprasDAO;
import edu.co.sena.instrumusiccrood.Carritodecompras;
import java.util.List;
import edu.co.sena.instrumusic.integracion.jpa.util.EntityManagerHelper;
import javax.persistence.EntityManager;

/**
 *
 * @author ColsutecR
 */
public class CarritoDeComprasDAOImpl implements CarritoDeComprasDAO {

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Carritodecompras entity) {
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
    public void update(Carritodecompras entity) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Carritodecompras entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carritodecompras findByIdCarrito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carritodecompras> findByAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carritodecompras> findByTotal(Object total) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carritodecompras> findBySubtotal(Object subtotal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carritodecompras> findByImpuestos(Object impuesto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
