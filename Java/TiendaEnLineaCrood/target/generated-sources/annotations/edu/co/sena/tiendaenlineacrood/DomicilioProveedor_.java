package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.DomicilioProveedorPK;
import edu.co.sena.tiendaenlineacrood.Municipio;
import edu.co.sena.tiendaenlineacrood.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(DomicilioProveedor.class)
public class DomicilioProveedor_ { 

    public static volatile SingularAttribute<DomicilioProveedor, DomicilioProveedorPK> domicilioProveedorPK;
    public static volatile SingularAttribute<DomicilioProveedor, String> barrio;
    public static volatile SingularAttribute<DomicilioProveedor, Municipio> municipioidMunicipio;
    public static volatile SingularAttribute<DomicilioProveedor, String> direccion;
    public static volatile SingularAttribute<DomicilioProveedor, String> localidad;
    public static volatile SingularAttribute<DomicilioProveedor, Proveedor> proveedor;
    public static volatile SingularAttribute<DomicilioProveedor, String> telefono;

}