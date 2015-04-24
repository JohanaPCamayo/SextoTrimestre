package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, Factura> factura;
    public static volatile SingularAttribute<Pago, String> numTarCredito;
    public static volatile SingularAttribute<Pago, String> tipoCuentaTar;
    public static volatile SingularAttribute<Pago, Integer> facturaidFactura;
    public static volatile SingularAttribute<Pago, String> banco;
    public static volatile SingularAttribute<Pago, String> tipoTransaccion;

}