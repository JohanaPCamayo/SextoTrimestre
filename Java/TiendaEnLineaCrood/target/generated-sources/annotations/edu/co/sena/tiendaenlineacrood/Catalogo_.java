package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Catalogo.class)
public class Catalogo_ { 

    public static volatile SingularAttribute<Catalogo, Integer> idCatalogo;
    public static volatile SingularAttribute<Catalogo, String> descripcion;
    public static volatile ListAttribute<Catalogo, Producto> productoList;
    public static volatile SingularAttribute<Catalogo, String> nombreCatalogo;

}