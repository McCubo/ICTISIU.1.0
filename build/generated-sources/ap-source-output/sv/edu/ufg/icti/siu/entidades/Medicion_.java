package sv.edu.ufg.icti.siu.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.ufg.icti.siu.entidades.Categoria;
import sv.edu.ufg.icti.siu.entidades.Detallemedicion;
import sv.edu.ufg.icti.siu.entidades.Evidencia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-02T22:16:33")
@StaticMetamodel(Medicion.class)
public class Medicion_ { 

    public static volatile SingularAttribute<Medicion, String> indicador;
    public static volatile SingularAttribute<Medicion, Integer> puntaje;
    public static volatile SingularAttribute<Medicion, Integer> idmedicion;
    public static volatile SingularAttribute<Medicion, Categoria> idcate;
    public static volatile ListAttribute<Medicion, Evidencia> evidenciaList;
    public static volatile ListAttribute<Medicion, Detallemedicion> detallemedicionList;
    public static volatile SingularAttribute<Medicion, String> nombre;

}