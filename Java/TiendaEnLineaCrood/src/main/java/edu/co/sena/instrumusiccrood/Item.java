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
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByProductoidProducto", query = "SELECT i FROM Item i WHERE i.itemPK.productoidProducto = :productoidProducto"),
    @NamedQuery(name = "Item.findByPedidoFacturaidFactura", query = "SELECT i FROM Item i WHERE i.itemPK.pedidoFacturaidFactura = :pedidoFacturaidFactura"),
    @NamedQuery(name = "Item.findByCantidad", query = "SELECT i FROM Item i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Item.findByCostoUnitario", query = "SELECT i FROM Item i WHERE i.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "Item.findByCostoTotal", query = "SELECT i FROM Item i WHERE i.costoTotal = :costoTotal")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemPK itemPK;
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
    @JoinColumn(name = "Pedido_Factura_idFactura", referencedColumnName = "Factura_idFactura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido;

    public Item() {
    }

    public Item(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public Item(ItemPK itemPK, int cantidad, float costoUnitario, float costoTotal) {
        this.itemPK = itemPK;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.costoTotal = costoTotal;
    }

    public Item(String productoidProducto, int pedidoFacturaidFactura) {
        this.itemPK = new ItemPK(productoidProducto, pedidoFacturaidFactura);
    }

    public ItemPK getItemPK() {
        return itemPK;
    }

    public void setItemPK(ItemPK itemPK) {
        this.itemPK = itemPK;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemPK != null ? itemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemPK == null && other.itemPK != null) || (this.itemPK != null && !this.itemPK.equals(other.itemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.Item[ itemPK=" + itemPK + " ]";
    }
    
}
