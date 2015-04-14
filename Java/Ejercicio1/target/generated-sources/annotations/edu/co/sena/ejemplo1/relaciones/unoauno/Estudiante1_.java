package edu.co.sena.ejemplo1.relaciones.unoauno;

import edu.co.sena.ejemplo1.relaciones.unoauno.Materia1;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-10T17:07:14")
@StaticMetamodel(Estudiante1.class)
public class Estudiante1_ { 

    public static volatile SingularAttribute<Estudiante1, String> nombre;
    public static volatile SingularAttribute<Estudiante1, String> direccion;
    public static volatile SingularAttribute<Estudiante1, String> correoElectronico;
    public static volatile SingularAttribute<Estudiante1, Materia1> materia;
    public static volatile SingularAttribute<Estudiante1, String> idEstudiante;
    public static volatile SingularAttribute<Estudiante1, String> numeroDocumento;
    public static volatile SingularAttribute<Estudiante1, String> telefono;
    public static volatile SingularAttribute<Estudiante1, String> tipoDocumento;

}