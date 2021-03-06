/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.ejemplo1.relaciones.unoauno;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ColsutecR
 */

@Entity
@Table(name = "materia1")

public class Materia1 implements Serializable{
    
    @Id
    @Column(name = "IDMATERIA",length = 50, nullable = false)
    private String idMateria;
    
    @Column(name = "NOMBREMATERIA",length = 50, nullable = false)
    private String nombreMateria;
  
    @Column(name = "DESCRIPCION",length = 500, nullable = false)
    private String descripcion;
    
    @OneToOne(mappedBy = "materia")
    private Estudiante1 estudiante;
    
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

    public Estudiante1 getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante1 estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Materia1{" + "idMateria=" + idMateria + ", nombreMateria=" + nombreMateria + ", descripcion=" + descripcion + ", estudiante=" + estudiante.getIdEstudiante() + '}';
    }

  
}
