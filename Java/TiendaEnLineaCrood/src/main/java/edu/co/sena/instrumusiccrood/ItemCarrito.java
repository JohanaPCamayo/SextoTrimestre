/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ColsutecR
 */
@Entity
@Table(name = "item_carrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemCarrito.findAll", query = "SELECT i FROM ItemCarrito i"),
    @NamedQuery(name = "ItemCarrito.findByProductoidProducto", query = "SELECT i FROM ItemCarrito i WHERE i.itemCarritoPK.productoidProducto = :productoidProducto"),
    @NamedQuery(name = "ItemCarrito.findByCarritoDeComprasidCarritoDeCompras", query = "SELECT i FROM ItemCarrito i WHERE i.itemCarritoPK.carritoDeComprasidCarritoDeCompras = :carritoDeComprasidCarritoDeCompras"),
    @NamedQuery(name = "ItemCarrito.findByCantidad", query = "SELECT i FROM ItemCarrito i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "ItemCarrito.findByCostoUnitario", query = "SELECT i FROM ItemCarrito i WHERE i.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "ItemCarrito.findByCostoTotal", query = "SELECT i FROM ItemCarrito i WHERE i.costoTotal = :costoTotal")})
public class ItemCarrito implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemCarritoPK itemCarritoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoUnitario")
    private float costoUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoTotal")
    private float costoTotal;
    @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "CarritoDeCompras_idCarritoDeCompras", referencedColumnName = "idCarritoDeCompras", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Carritodecompras carritodecompras;

    public ItemCarrito() {
    }

    public ItemCarrito(ItemCarritoPK itemCarritoPK) {
        this.itemCarritoPK = itemCarritoPK;
    }

    public ItemCarrito(ItemCarritoPK itemCarritoPK, int cantidad, float costoUnitario, float costoTotal) {
        this.itemCarritoPK = itemCarritoPK;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.costoTotal = costoTotal;
    }

    public ItemCarrito(String productoidProducto, String carritoDeComprasidCarritoDeCompras) {
        this.itemCarritoPK = new ItemCarritoPK(productoidProducto, carritoDeComprasidCarritoDeCompras);
    }

    public ItemCarritoPK getItemCarritoPK() {
        return itemCarritoPK;
    }

    public void setItemCarritoPK(ItemCarritoPK itemCarritoPK) {
        this.itemCarritoPK = itemCarritoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Carritodecompras getCarritodecompras() {
        return carritodecompras;
    }

    public void setCarritodecompras(Carritodecompras carritodecompras) {
        this.carritodecompras = carritodecompras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCarritoPK != null ? itemCarritoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCarrito)) {
            return false;
        }
        ItemCarrito other = (ItemCarrito) object;
        if ((this.itemCarritoPK == null && other.itemCarritoPK != null) || (this.itemCarritoPK != null && !this.itemCarritoPK.equals(other.itemCarritoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.ItemCarrito[ itemCarritoPK=" + itemCarritoPK + " ]";
    }
    
}
