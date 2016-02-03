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
@Table(name = "evidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evidencia.findAll", query = "SELECT e FROM Evidencia e"),
    @NamedQuery(name = "Evidencia.findByIdevidencia", query = "SELECT e FROM Evidencia e WHERE e.idevidencia = :idevidencia"),
    //@NamedQuery(name = "Evidencia.findByFecha", query = "SELECT e FROM Evidencia e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Evidencia.findByDetalles", query = "SELECT e FROM Evidencia e WHERE e.detalles = :detalles"),
    @NamedQuery(name = "Evidencia.findByEstado", query = "SELECT e FROM Evidencia e WHERE e.estado = :estado"),
    @NamedQuery(name = "Evidencia.findByPuntos", query = "SELECT e FROM Evidencia e WHERE e.puntos = :puntos"),
    @NamedQuery(name = "Evidencia.findByFecha", query = "SELECT e FROM Evidencia e WHERE e.idinvestigador = :investigador AND FUNC('YEAR', e.fecha) BETWEEN :ano1 AND :ano2"),
    @NamedQuery(name = "Evidencia.findByArchivo", query = "SELECT e FROM Evidencia e WHERE e.archivo = :archivo")})
public class Evidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevidencia")
    private Integer idevidencia;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 150)
    @Column(name = "detalles")
    private String detalles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private int puntos;
    @Size(max = 200)
    @Column(name = "archivo")
    private String archivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idevidencia")
    private List<Archivo> archivoList;
    @JoinColumn(name = "idinvestigador", referencedColumnName = "idinvestigador")
    @ManyToOne(optional = false)
    private Investigador idinvestigador;
    @JoinColumn(name = "idmedicion", referencedColumnName = "idmedicion")
    @ManyToOne(optional = false)
    private Medicion idmedicion;
    @JoinColumn(name = "idinstitucion", referencedColumnName = "idinstitucion")
    @ManyToOne(optional = false)
    private Institucion idinstitucion;

    public Evidencia() {
    }

    public Evidencia(Integer idevidencia) {
        this.idevidencia = idevidencia;
    }

    public Evidencia(Integer idevidencia, String estado, int puntos) {
        this.idevidencia = idevidencia;
        this.estado = estado;
        this.puntos = puntos;
    }

    public Integer getIdevidencia() {
        return idevidencia;
    }

    public void setIdevidencia(Integer idevidencia) {
        this.idevidencia = idevidencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @XmlTransient
    public List<Archivo> getArchivoList() {
        return archivoList;
    }

    public void setArchivoList(List<Archivo> archivoList) {
        this.archivoList = archivoList;
    }

    public Investigador getIdinvestigador() {
        return idinvestigador;
    }

    public void setIdinvestigador(Investigador idinvestigador) {
        this.idinvestigador = idinvestigador;
    }

    public Medicion getIdmedicion() {
        return idmedicion;
    }

    public void setIdmedicion(Medicion idmedicion) {
        this.idmedicion = idmedicion;
    }

    public Institucion getIdinstitucion() {
        return idinstitucion;
    }

    public void setIdinstitucion(Institucion idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevidencia != null ? idevidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evidencia)) {
            return false;
        }
        Evidencia other = (Evidencia) object;
        if ((this.idevidencia == null && other.idevidencia != null) || (this.idevidencia != null && !this.idevidencia.equals(other.idevidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Evidencia[ idevidencia=" + idevidencia + " ]";
    }
    
}
