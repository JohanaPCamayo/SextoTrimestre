/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "carritodecompras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carritodecompras.findAll", query = "SELECT c FROM Carritodecompras c"),
    @NamedQuery(name = "Carritodecompras.findByIdCarritoDeCompras", query = "SELECT c FROM Carritodecompras c WHERE c.idCarritoDeCompras = :idCarritoDeCompras"),
    @NamedQuery(name = "Carritodecompras.findBySubtotal", query = "SELECT c FROM Carritodecompras c WHERE c.subtotal = :subtotal"),
    @NamedQuery(name = "Carritodecompras.findByPrecioTotal", query = "SELECT c FROM Carritodecompras c WHERE c.precioTotal = :precioTotal"),
    @NamedQuery(name = "Carritodecompras.findByImpuestos", query = "SELECT c FROM Carritodecompras c WHERE c.impuestos = :impuestos")})
public class Carritodecompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idCarritoDeCompras")
    private String idCarritoDeCompras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private float subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioTotal")
    private float precioTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuestos")
    private float impuestos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carritodecompras")
    private Collection<ItemCarrito> itemCarritoCollection;

    public Carritodecompras() {
    }

    public Carritodecompras(String idCarritoDeCompras) {
        this.idCarritoDeCompras = idCarritoDeCompras;
    }

    public Carritodecompras(String idCarritoDeCompras, float subtotal, float precioTotal, float impuestos) {
        this.idCarritoDeCompras = idCarritoDeCompras;
        this.subtotal = subtotal;
        this.precioTotal = precioTotal;
        this.impuestos = impuestos;
    }

    public String getIdCarritoDeCompras() {
        return idCarritoDeCompras;
    }

    public void setIdCarritoDeCompras(String idCarritoDeCompras) {
        this.idCarritoDeCompras = idCarritoDeCompras;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    @XmlTransient
    public Collection<ItemCarrito> getItemCarritoCollection() {
        return itemCarritoCollection;
    }

    public void setItemCarritoCollection(Collection<ItemCarrito> itemCarritoCollection) {
        this.itemCarritoCollection = itemCarritoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarritoDeCompras != null ? idCarritoDeCompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carritodecompras)) {
            return false;
        }
        Carritodecompras other = (Carritodecompras) object;
        if ((this.idCarritoDeCompras == null && other.idCarritoDeCompras != null) || (this.idCarritoDeCompras != null && !this.idCarritoDeCompras.equals(other.idCarritoDeCompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carritodecompras{" + "idCarritoDeCompras=" + idCarritoDeCompras + ", subtotal=" + subtotal + ", precioTotal=" + precioTotal + ", impuestos=" + impuestos + '}';
    }
    
}
