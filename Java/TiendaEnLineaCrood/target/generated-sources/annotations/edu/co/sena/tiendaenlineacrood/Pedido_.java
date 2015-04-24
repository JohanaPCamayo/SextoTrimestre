package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.Factura;
import edu.co.sena.tiendaenlineacrood.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Float> total;
    public static volatile SingularAttribute<Pedido, Factura> factura;
    public static volatile SingularAttribute<Pedido, Float> subtotal;
    public static volatile SingularAttribute<Pedido, Float> impuestos;
    public static volatile SingularAttribute<Pedido, Integer> facturaidFactura;
    public static volatile ListAttribute<Pedido, Item> itemList;

}