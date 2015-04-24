package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> idDepartamento;
    public static volatile ListAttribute<Departamento, Municipio> municipioList;
    public static volatile SingularAttribute<Departamento, String> nombre;

}