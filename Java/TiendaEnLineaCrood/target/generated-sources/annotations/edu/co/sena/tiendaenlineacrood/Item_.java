package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.ItemPK;
import edu.co.sena.tiendaenlineacrood.Pedido;
import edu.co.sena.tiendaenlineacrood.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, ItemPK> itemPK;
    public static volatile SingularAttribute<Item, Float> costoTotal;
    public static volatile SingularAttribute<Item, Pedido> pedido;
    public static volatile SingularAttribute<Item, Integer> cantidad;
    public static volatile SingularAttribute<Item, Producto> producto;
    public static volatile SingularAttribute<Item, Float> costoUnitario;

}