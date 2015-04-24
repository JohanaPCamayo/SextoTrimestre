package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile ListAttribute<Categoria, Producto> productoList;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile SingularAttribute<Categoria, Boolean> activa;
    public static volatile SingularAttribute<Categoria, Integer> pariente;
    public static volatile SingularAttribute<Categoria, String> nombreCategoria;

}