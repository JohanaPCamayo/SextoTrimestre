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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByFacturaidFactura", query = "SELECT p FROM Pedido p WHERE p.facturaidFactura = :facturaidFactura"),
    @NamedQuery(name = "Pedido.findByTotal", query = "SELECT p FROM Pedido p WHERE p.total = :total"),
    @NamedQuery(name = "Pedido.findBySubtotal", query = "SELECT p FROM Pedido p WHERE p.subtotal = :subtotal"),
    @NamedQuery(name = "Pedido.findByImpuestos", query = "SELECT p FROM Pedido p WHERE p.impuestos = :impuestos")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Factura_idFactura")
    private Integer facturaidFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private float subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "impuestos")
    private float impuestos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Collection<Item> itemCollection;
    @JoinColumn(name = "Factura_idFactura", referencedColumnName = "idFactura", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Factura factura;

    public Pedido() {
    }

    public Pedido(Integer facturaidFactura) {
        this.facturaidFactura = facturaidFactura;
    }

    public Pedido(Integer facturaidFactura, float total, float subtotal, float impuestos) {
        this.facturaidFactura = facturaidFactura;
        this.total = total;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
    }

    public Integer getFacturaidFactura() {
        return facturaidFactura;
    }

    public void setFacturaidFactura(Integer facturaidFactura) {
        this.facturaidFactura = facturaidFactura;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaidFactura != null ? facturaidFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.facturaidFactura == null && other.facturaidFactura != null) || (this.facturaidFactura != null && !this.facturaidFactura.equals(other.facturaidFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.Pedido[ facturaidFactura=" + facturaidFactura + " ]";
    }
    
}
