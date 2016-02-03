/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByIdeva", query = "SELECT e FROM Evaluacion e WHERE e.ideva = :ideva"),
    @NamedQuery(name = "Evaluacion.findByPuntaje", query = "SELECT e FROM Evaluacion e WHERE e.puntaje = :puntaje"),
    @NamedQuery(name = "Evaluacion.findByFecha", query = "SELECT e FROM Evaluacion e WHERE FUNC('YEAR', e.fecha) = :fecha And e.puntaje>18")})
public class Evaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideva")
    private Integer ideva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje")
    private int puntaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idinvestigador", referencedColumnName = "idinvestigador")
    @ManyToOne(optional = false)
    private Investigador idinvestigador;
    @JoinColumn(name = "idcal", referencedColumnName = "idcal")
    @ManyToOne(optional = false)
    private Calificacion idcal;

    public Evaluacion() {
    }

    public Evaluacion(Integer ideva) {
        this.ideva = ideva;
    }

    public Evaluacion(Integer ideva, int puntaje, Date fecha) {
        this.ideva = ideva;
        this.puntaje = puntaje;
        this.fecha = fecha;
    }

    public Integer getIdeva() {
        return ideva;
    }

    public void setIdeva(Integer ideva) {
        this.ideva = ideva;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Investigador getIdinvestigador() {
        return idinvestigador;
    }

    public void setIdinvestigador(Investigador idinvestigador) {
        this.idinvestigador = idinvestigador;
    }

    public Calificacion getIdcal() {
        return idcal;
    }

    public void setIdcal(Calificacion idcal) {
        this.idcal = idcal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideva != null ? ideva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.ideva == null && other.ideva != null) || (this.ideva != null && !this.ideva.equals(other.ideva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Evaluacion[ ideva=" + ideva + " ]";
    }
    
}
