package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.DomicilioProveedor;
import edu.co.sena.tiendaenlineacrood.Inventario;
import edu.co.sena.tiendaenlineacrood.ProveedorPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, ProveedorPK> proveedorPK;
    public static volatile SingularAttribute<Proveedor, DomicilioProveedor> domicilioProveedor;
    public static volatile ListAttribute<Proveedor, Inventario> inventarioList;
    public static volatile SingularAttribute<Proveedor, String> telefono;
    public static volatile SingularAttribute<Proveedor, String> nombre;
    public static volatile SingularAttribute<Proveedor, String> email;

}