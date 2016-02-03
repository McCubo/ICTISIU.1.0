package sv.edu.ufg.icti.siu.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.ufg.icti.siu.entidades.Medicion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-02T22:16:33")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Integer> idcate;
    public static volatile SingularAttribute<Categoria, String> nombre;
    public static volatile ListAttribute<Categoria, Medicion> medicionList;

}