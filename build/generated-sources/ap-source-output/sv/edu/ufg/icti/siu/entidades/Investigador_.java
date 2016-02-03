package sv.edu.ufg.icti.siu.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.ufg.icti.siu.entidades.Evaluacion;
import sv.edu.ufg.icti.siu.entidades.Evidencia;
import sv.edu.ufg.icti.siu.entidades.Gradoacademico;
import sv.edu.ufg.icti.siu.entidades.Tipocontratacion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-02T22:16:33")
@StaticMetamodel(Investigador.class)
public class Investigador_ { 

    public static volatile SingularAttribute<Investigador, String> apellidos;
    public static volatile SingularAttribute<Investigador, String> estado;
    public static volatile SingularAttribute<Investigador, String> unidadAcademica;
    public static volatile ListAttribute<Investigador, Evaluacion> evaluacionList;
    public static volatile SingularAttribute<Investigador, String> nia;
    public static volatile ListAttribute<Investigador, Evidencia> evidenciaList;
    public static volatile SingularAttribute<Investigador, String> otrostipocontra;
    public static volatile SingularAttribute<Investigador, String> nombreJefeInmediato;
    public static volatile SingularAttribute<Investigador, String> uAsiglas;
    public static volatile SingularAttribute<Investigador, String> especialidad;
    public static volatile SingularAttribute<Investigador, String> nombres;
    public static volatile ListAttribute<Investigador, Gradoacademico> gradoacademicoList;
    public static volatile SingularAttribute<Investigador, Date> fechaIngreso;
    public static volatile SingularAttribute<Investigador, Tipocontratacion> idtipocontra;
    public static volatile SingularAttribute<Investigador, Integer> idinvestigador;
    public static volatile SingularAttribute<Investigador, String> ingreso;
    public static volatile SingularAttribute<Investigador, Integer> puntajeInicial;
    public static volatile SingularAttribute<Investigador, String> tipoInvestigador;
    public static volatile SingularAttribute<Investigador, String> telefono;
    public static volatile SingularAttribute<Investigador, String> email;

}