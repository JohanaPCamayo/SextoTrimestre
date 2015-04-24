/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusiccrood;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ColsutecR
 */
@Embeddable
public class ItemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Producto_idProducto")
    private String productoidProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pedido_Factura_idFactura")
    private int pedidoFacturaidFactura;

    public ItemPK() {
    }

    public ItemPK(String productoidProducto, int pedidoFacturaidFactura) {
        this.productoidProducto = productoidProducto;
        this.pedidoFacturaidFactura = pedidoFacturaidFactura;
    }

    public String getProductoidProducto() {
        return productoidProducto;
    }

    public void setProductoidProducto(String productoidProducto) {
        this.productoidProducto = productoidProducto;
    }

    public int getPedidoFacturaidFactura() {
        return pedidoFacturaidFactura;
    }

    public void setPedidoFacturaidFactura(int pedidoFacturaidFactura) {
        this.pedidoFacturaidFactura = pedidoFacturaidFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoidProducto != null ? productoidProducto.hashCode() : 0);
        hash += (int) pedidoFacturaidFactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPK)) {
            return false;
        }
        ItemPK other = (ItemPK) object;
        if ((this.productoidProducto == null && other.productoidProducto != null) || (this.productoidProducto != null && !this.productoidProducto.equals(other.productoidProducto))) {
            return false;
        }
        if (this.pedidoFacturaidFactura != other.pedidoFacturaidFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.ItemPK[ productoidProducto=" + productoidProducto + ", pedidoFacturaidFactura=" + pedidoFacturaidFactura + " ]";
    }
    
}
