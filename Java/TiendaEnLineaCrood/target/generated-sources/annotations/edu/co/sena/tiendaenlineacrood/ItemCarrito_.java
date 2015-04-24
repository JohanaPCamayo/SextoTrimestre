package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.Carritodecompras;
import edu.co.sena.tiendaenlineacrood.ItemCarritoPK;
import edu.co.sena.tiendaenlineacrood.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(ItemCarrito.class)
public class ItemCarrito_ { 

    public static volatile SingularAttribute<ItemCarrito, Carritodecompras> carritodecompras;
    public static volatile SingularAttribute<ItemCarrito, Float> costoTotal;
    public static volatile SingularAttribute<ItemCarrito, ItemCarritoPK> itemCarritoPK;
    public static volatile SingularAttribute<ItemCarrito, Integer> cantidad;
    public static volatile SingularAttribute<ItemCarrito, Producto> producto;
    public static volatile SingularAttribute<ItemCarrito, Float> costoUnitario;

}