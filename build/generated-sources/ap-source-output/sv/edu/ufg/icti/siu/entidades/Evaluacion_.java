package sv.edu.ufg.icti.siu.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.ufg.icti.siu.entidades.Calificacion;
import sv.edu.ufg.icti.siu.entidades.Investigador;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-02T22:16:33")
@StaticMetamodel(Evaluacion.class)
public class Evaluacion_ { 

    public static volatile SingularAttribute<Evaluacion, Date> fecha;
    public static volatile SingularAttribute<Evaluacion, Integer> ideva;
    public static volatile SingularAttribute<Evaluacion, Integer> puntaje;
    public static volatile SingularAttribute<Evaluacion, Investigador> idinvestigador;
    public static volatile SingularAttribute<Evaluacion, Calificacion> idcal;

}