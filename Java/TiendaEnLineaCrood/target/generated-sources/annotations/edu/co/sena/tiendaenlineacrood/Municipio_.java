package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.Departamento;
import edu.co.sena.tiendaenlineacrood.DomicilioCuenta;
import edu.co.sena.tiendaenlineacrood.DomicilioProveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile SingularAttribute<Municipio, String> idMunicipio;
    public static volatile ListAttribute<Municipio, DomicilioProveedor> domicilioProveedorList;
    public static volatile SingularAttribute<Municipio, String> nombre;
    public static volatile ListAttribute<Municipio, DomicilioCuenta> domicilioCuentaList;
    public static volatile SingularAttribute<Municipio, Departamento> departamentoidDepartamento;

}