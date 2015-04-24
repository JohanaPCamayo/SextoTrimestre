package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.Cuenta;
import edu.co.sena.tiendaenlineacrood.DomicilioCuentaPK;
import edu.co.sena.tiendaenlineacrood.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(DomicilioCuenta.class)
public class DomicilioCuenta_ { 

    public static volatile SingularAttribute<DomicilioCuenta, String> barrio;
    public static volatile SingularAttribute<DomicilioCuenta, Municipio> municipioidMunicipio;
    public static volatile SingularAttribute<DomicilioCuenta, String> direccion;
    public static volatile SingularAttribute<DomicilioCuenta, Cuenta> cuenta;
    public static volatile SingularAttribute<DomicilioCuenta, DomicilioCuentaPK> domicilioCuentaPK;
    public static volatile SingularAttribute<DomicilioCuenta, String> localidad;
    public static volatile SingularAttribute<DomicilioCuenta, String> telefono;

}