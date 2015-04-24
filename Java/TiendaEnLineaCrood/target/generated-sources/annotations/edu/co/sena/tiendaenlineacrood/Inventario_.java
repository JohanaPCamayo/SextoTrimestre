package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.InventarioPK;
import edu.co.sena.tiendaenlineacrood.Producto;
import edu.co.sena.tiendaenlineacrood.Proveedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, InventarioPK> inventarioPK;
    public static volatile SingularAttribute<Inventario, Date> fecha;
    public static volatile SingularAttribute<Inventario, Proveedor> proveedor;
    public static volatile SingularAttribute<Inventario, Integer> cantidad;
    public static volatile SingularAttribute<Inventario, Producto> producto;

}