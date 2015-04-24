package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.ItemCarrito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Carritodecompras.class)
public class Carritodecompras_ { 

    public static volatile ListAttribute<Carritodecompras, ItemCarrito> itemCarritoList;
    public static volatile SingularAttribute<Carritodecompras, Float> subtotal;
    public static volatile SingularAttribute<Carritodecompras, Float> impuestos;
    public static volatile SingularAttribute<Carritodecompras, Float> precioTotal;
    public static volatile SingularAttribute<Carritodecompras, String> idCarritoDeCompras;

}