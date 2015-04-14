/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejercici1.unoamuchos;


import edu.co.sena.ejemplo1.relaciones.unoauno.*;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ColsutecR
 */

@Entity
@Table(name = "materia3")

public class Materia3 implements Serializable{
    
    @Id
    @Column(name = "IDMATERIA",length = 50, nullable = false)
    private String idMateria;
    
    @Column(name = "NOMBREMATERIA",length = 50, nullable = false)
    private String nombreMateria;
  
    @Column(name = "DESCRIPCION",length = 500, nullable = false)
    private String descripcion;
    
    @OneToMany(mappedBy = "materia")
    private Collection<Estudiante3> estudiante;
    
    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }    

 
    @Override
    public String toString() {
        return "Materia1{" + "idMateria=" + idMateria + ", nombreMateria=" + nombreMateria + ", descripcion=" + descripcion + '}';
    }

    public Collection<Estudiante3> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Collection<Estudiante3> estudiante) {
        this.estudiante = estudiante;
    }

  
}
