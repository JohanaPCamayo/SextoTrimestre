package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.CuentaPK;
import edu.co.sena.tiendaenlineacrood.DomicilioCuenta;
import edu.co.sena.tiendaenlineacrood.Factura;
import edu.co.sena.tiendaenlineacrood.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> segundoNombre;
    public static volatile SingularAttribute<Cuenta, String> primerNombre;
    public static volatile SingularAttribute<Cuenta, String> primerApellido;
    public static volatile SingularAttribute<Cuenta, DomicilioCuenta> domicilioCuenta;
    public static volatile SingularAttribute<Cuenta, Usuario> usuarioidUsuario;
    public static volatile SingularAttribute<Cuenta, CuentaPK> cuentaPK;
    public static volatile ListAttribute<Cuenta, Factura> facturaList;
    public static volatile SingularAttribute<Cuenta, String> segundoApellido;
    public static volatile SingularAttribute<Cuenta, String> contrasena;
    public static volatile SingularAttribute<Cuenta, String> email;

}