/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusiccrood.Municipio;
import java.util.List;

/**
 *
 * @author admin
 */
public interface MunicipioDAO {
    
    
     public void insert(Municipio entity);

    public void update(Municipio entity);

    public void delete(Municipio entity);

    public Municipio findByIdMunicipio();

    public List<Municipio> findByAll();
    public List<Municipio> findByNombre(Object nombre);

}
