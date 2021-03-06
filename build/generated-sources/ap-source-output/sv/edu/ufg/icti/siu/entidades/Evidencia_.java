package sv.edu.ufg.icti.siu.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.ufg.icti.siu.entidades.Archivo;
import sv.edu.ufg.icti.siu.entidades.Institucion;
import sv.edu.ufg.icti.siu.entidades.Investigador;
import sv.edu.ufg.icti.siu.entidades.Medicion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-02T22:16:33")
@StaticMetamodel(Evidencia.class)
public class Evidencia_ { 

    public static volatile SingularAttribute<Evidencia, Date> fecha;
    public static volatile SingularAttribute<Evidencia, String> estado;
    public static volatile SingularAttribute<Evidencia, String> archivo;
    public static volatile SingularAttribute<Evidencia, Investigador> idinvestigador;
    public static volatile SingularAttribute<Evidencia, Integer> idevidencia;
    public static volatile SingularAttribute<Evidencia, Medicion> idmedicion;
    public static volatile SingularAttribute<Evidencia, String> detalles;
    public static volatile SingularAttribute<Evidencia, Institucion> idinstitucion;
    public static volatile SingularAttribute<Evidencia, Integer> puntos;
    public static volatile ListAttribute<Evidencia, Archivo> archivoList;

}