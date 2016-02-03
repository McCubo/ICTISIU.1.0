package sv.edu.ufg.icti.siu.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.ufg.icti.siu.entidades.Evaluacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-02T22:16:33")
@StaticMetamodel(Calificacion.class)
public class Calificacion_ { 

    public static volatile SingularAttribute<Calificacion, String> descripcion;
    public static volatile SingularAttribute<Calificacion, Integer> bono;
    public static volatile SingularAttribute<Calificacion, Integer> puntajemax;
    public static volatile SingularAttribute<Calificacion, Integer> idcal;
    public static volatile ListAttribute<Calificacion, Evaluacion> evaluacionList;
    public static volatile SingularAttribute<Calificacion, Integer> puntajemin;
    public static volatile SingularAttribute<Calificacion, Character> nombre;

}