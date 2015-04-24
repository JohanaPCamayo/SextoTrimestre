/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;
//

import java.util.List;
import edu.co.sena.instrumusiccrood.Carritodecompras;
/**
 *
 * @author ColsutecR
 */
public interface CarritoDeComprasDAO {

    public void insert(Carritodecompras entity);

    public void update(Carritodecompras entity);

    public void delete(Carritodecompras entity);

    public Carritodecompras findByIdCarrito();

    public List<Carritodecompras> findByAll();
    public List<Carritodecompras> findByTotal(Object total);
    public List<Carritodecompras> findBySubtotal(Object subtotal);
    public List<Carritodecompras> findByImpuestos(Object impuesto);

}
