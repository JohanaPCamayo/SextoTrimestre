package edu.co.sena.tiendaenlineacrood;

import edu.co.sena.tiendaenlineacrood.Catalogo;
import edu.co.sena.tiendaenlineacrood.Categoria;
import edu.co.sena.tiendaenlineacrood.Inventario;
import edu.co.sena.tiendaenlineacrood.Item;
import edu.co.sena.tiendaenlineacrood.ItemCarrito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-26T20:43:16")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Float> precioUnitario;
    public static volatile SingularAttribute<Producto, String> color;
    public static volatile SingularAttribute<Producto, Float> descuento;
    public static volatile SingularAttribute<Producto, Categoria> categoriaidCategoria;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, Catalogo> catalogoidCatalogo;
    public static volatile ListAttribute<Producto, ItemCarrito> itemCarritoList;
    public static volatile SingularAttribute<Producto, String> marca;
    public static volatile SingularAttribute<Producto, String> material;
    public static volatile SingularAttribute<Producto, byte[]> foto;
    public static volatile ListAttribute<Producto, Inventario> inventarioList;
    public static volatile ListAttribute<Producto, Item> itemList;
    public static volatile SingularAttribute<Producto, String> idProducto;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, String> referencia;
    public static volatile SingularAttribute<Producto, Boolean> activo;

}