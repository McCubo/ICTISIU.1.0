package sv.edu.ufg.icti.siu.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.ufg.icti.siu.entidades.Investigador;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-02T22:16:33")
@StaticMetamodel(Tipocontratacion.class)
public class Tipocontratacion_ { 

    public static volatile SingularAttribute<Tipocontratacion, String> descripcion;
    public static volatile SingularAttribute<Tipocontratacion, Integer> idtipocontra;
    public static volatile ListAttribute<Tipocontratacion, Investigador> investigadorList;
    public static volatile SingularAttribute<Tipocontratacion, String> nombre;

}