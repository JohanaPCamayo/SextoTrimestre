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
public class ItemCarritoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Producto_idProducto")
    private String productoidProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CarritoDeCompras_idCarritoDeCompras")
    private String carritoDeComprasidCarritoDeCompras;

    public ItemCarritoPK() {
    }

    public ItemCarritoPK(String productoidProducto, String carritoDeComprasidCarritoDeCompras) {
        this.productoidProducto = productoidProducto;
        this.carritoDeComprasidCarritoDeCompras = carritoDeComprasidCarritoDeCompras;
    }

    public String getProductoidProducto() {
        return productoidProducto;
    }

    public void setProductoidProducto(String productoidProducto) {
        this.productoidProducto = productoidProducto;
    }

    public String getCarritoDeComprasidCarritoDeCompras() {
        return carritoDeComprasidCarritoDeCompras;
    }

    public void setCarritoDeComprasidCarritoDeCompras(String carritoDeComprasidCarritoDeCompras) {
        this.carritoDeComprasidCarritoDeCompras = carritoDeComprasidCarritoDeCompras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoidProducto != null ? productoidProducto.hashCode() : 0);
        hash += (carritoDeComprasidCarritoDeCompras != null ? carritoDeComprasidCarritoDeCompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCarritoPK)) {
            return false;
        }
        ItemCarritoPK other = (ItemCarritoPK) object;
        if ((this.productoidProducto == null && other.productoidProducto != null) || (this.productoidProducto != null && !this.productoidProducto.equals(other.productoidProducto))) {
            return false;
        }
        if ((this.carritoDeComprasidCarritoDeCompras == null && other.carritoDeComprasidCarritoDeCompras != null) || (this.carritoDeComprasidCarritoDeCompras != null && !this.carritoDeComprasidCarritoDeCompras.equals(other.carritoDeComprasidCarritoDeCompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.tiendaenlineacrood.ItemCarritoPK[ productoidProducto=" + productoidProducto + ", carritoDeComprasidCarritoDeCompras=" + carritoDeComprasidCarritoDeCompras + " ]";
    }
    
}
