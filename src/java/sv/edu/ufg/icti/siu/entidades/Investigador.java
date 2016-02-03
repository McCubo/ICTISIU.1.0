/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Entity
@Table(name = "investigador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investigador.findAll", query = "SELECT i FROM Investigador i"),
    @NamedQuery(name = "Investigador.findByIdinvestigador", query = "SELECT i FROM Investigador i WHERE i.idinvestigador = :idinvestigador"),
    @NamedQuery(name = "Investigador.findByNia", query = "SELECT i FROM Investigador i WHERE i.nia = :nia"),
    @NamedQuery(name = "Investigador.findByNombres", query = "SELECT i FROM Investigador i WHERE i.nombres = :nombres"),
    @NamedQuery(name = "Investigador.findByApellidos", query = "SELECT i FROM Investigador i WHERE i.apellidos = :apellidos"),
    @NamedQuery(name = "Investigador.findByEspecialidad", query = "SELECT i FROM Investigador i WHERE i.especialidad = :especialidad"),
    @NamedQuery(name = "Investigador.findByTelefono", query = "SELECT i FROM Investigador i WHERE i.telefono = :telefono"),
    @NamedQuery(name = "Investigador.findByEmail", query = "SELECT i FROM Investigador i WHERE i.email = :email"),
    @NamedQuery(name = "Investigador.findByUnidadAcademica", query = "SELECT i FROM Investigador i WHERE i.unidadAcademica = :unidadAcademica"),
    @NamedQuery(name = "Investigador.findByUAsiglas", query = "SELECT i FROM Investigador i WHERE i.uAsiglas = :uAsiglas"),
    @NamedQuery(name = "Investigador.findByNombreJefeInmediato", query = "SELECT i FROM Investigador i WHERE i.nombreJefeInmediato = :nombreJefeInmediato"),
    @NamedQuery(name = "Investigador.findByOtrostipocontra", query = "SELECT i FROM Investigador i WHERE i.otrostipocontra = :otrostipocontra"),
    @NamedQuery(name = "Investigador.findByFechaIngreso", query = "SELECT i FROM Investigador i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Investigador.findByPuntajeInicial", query = "SELECT i FROM Investigador i WHERE i.puntajeInicial = :puntajeInicial"),
    @NamedQuery(name = "Investigador.findByEstado", query = "SELECT i FROM Investigador i WHERE i.estado = :estado"),
    @NamedQuery(name = "Investigador.findByTipoInvestigador", query = "SELECT i FROM Investigador i WHERE i.tipoInvestigador = :tipoInvestigador"),
    @NamedQuery(name = "Investigador.findByIngreso", query = "SELECT i FROM Investigador i WHERE i.ingreso = :ingreso")})
public class Investigador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinvestigador")
    private Integer idinvestigador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "nia")
    private String nia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 100)
    @Column(name = "especialidad")
    private String especialidad;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "unidadAcademica")
    private String unidadAcademica;
    @Size(max = 20)
    @Column(name = "UAsiglas")
    private String uAsiglas;
    @Size(max = 50)
    @Column(name = "nombreJefeInmediato")
    private String nombreJefeInmediato;
    @Size(max = 20)
    @Column(name = "otrostipocontra")
    private String otrostipocontra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntajeInicial")
    private int puntajeInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "estado")
    private String estado;
    @Size(max = 50)
    @Column(name = "tipoInvestigador")
    private String tipoInvestigador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ingreso")
    private String ingreso;
    @JoinTable(name = "invesgrados", joinColumns = {
        @JoinColumn(name = "idinvestigador", referencedColumnName = "idinvestigador")}, inverseJoinColumns = {
        @JoinColumn(name = "idgrados", referencedColumnName = "idgrado")})
    @ManyToMany
    private List<Gradoacademico> gradoacademicoList;
    @JoinColumn(name = "idtipocontra", referencedColumnName = "idtipocontra")
    @ManyToOne(optional = false)
    private Tipocontratacion idtipocontra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinvestigador")
    private List<Evidencia> evidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinvestigador")
    private List<Evaluacion> evaluacionList;

    public Investigador() {
    }

    public Investigador(Integer idinvestigador) {
        this.idinvestigador = idinvestigador;
    }

    public Investigador(Integer idinvestigador, String nia, String nombres, String apellidos, Date fechaIngreso, int puntajeInicial, String estado, String ingreso) {
        this.idinvestigador = idinvestigador;
        this.nia = nia;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.puntajeInicial = puntajeInicial;
        this.estado = estado;
        this.ingreso = ingreso;
    }

    public Integer getIdinvestigador() {
        return idinvestigador;
    }

    public void setIdinvestigador(Integer idinvestigador) {
        this.idinvestigador = idinvestigador;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(String unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public String getUAsiglas() {
        return uAsiglas;
    }

    public void setUAsiglas(String uAsiglas) {
        this.uAsiglas = uAsiglas;
    }

    public String getNombreJefeInmediato() {
        return nombreJefeInmediato;
    }

    public void setNombreJefeInmediato(String nombreJefeInmediato) {
        this.nombreJefeInmediato = nombreJefeInmediato;
    }

    public String getOtrostipocontra() {
        return otrostipocontra;
    }

    public void setOtrostipocontra(String otrostipocontra) {
        this.otrostipocontra = otrostipocontra;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getPuntajeInicial() {
        return puntajeInicial;
    }

    public void setPuntajeInicial(int puntajeInicial) {
        this.puntajeInicial = puntajeInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoInvestigador() {
        return tipoInvestigador;
    }

    public void setTipoInvestigador(String tipoInvestigador) {
        this.tipoInvestigador = tipoInvestigador;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    @XmlTransient
    public List<Gradoacademico> getGradoacademicoList() {
        return gradoacademicoList;
    }

    public void setGradoacademicoList(List<Gradoacademico> gradoacademicoList) {
        this.gradoacademicoList = gradoacademicoList;
    }

    public Tipocontratacion getIdtipocontra() {
        return idtipocontra;
    }

    public void setIdtipocontra(Tipocontratacion idtipocontra) {
        this.idtipocontra = idtipocontra;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinvestigador != null ? idinvestigador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investigador)) {
            return false;
        }
        Investigador other = (Investigador) object;
        if ((this.idinvestigador == null && other.idinvestigador != null) || (this.idinvestigador != null && !this.idinvestigador.equals(other.idinvestigador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Investigador[ idinvestigador=" + idinvestigador + " ]";
    }
    
}
