package sv.edu.ufg.icti.siu.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.ufg.icti.siu.entidades.Evidencia;
import sv.edu.ufg.icti.siu.entidades.Institucioncat;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-02T22:16:33")
@StaticMetamodel(Institucion.class)
public class Institucion_ { 

    public static volatile ListAttribute<Institucion, Evidencia> evidenciaList;
    public static volatile SingularAttribute<Institucion, Integer> idinstitucion;
    public static volatile SingularAttribute<Institucion, Institucioncat> idinsticat;
    public static volatile SingularAttribute<Institucion, String> nombre;

}