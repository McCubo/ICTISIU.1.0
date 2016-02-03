/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Entity
@Table(name = "calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c"),
    @NamedQuery(name = "Calificacion.findByIdcal", query = "SELECT c FROM Calificacion c WHERE c.idcal = :idcal"),
    @NamedQuery(name = "Calificacion.findByNombre", query = "SELECT c FROM Calificacion c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Calificacion.findByDescripcion", query = "SELECT c FROM Calificacion c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Calificacion.findByBono", query = "SELECT c FROM Calificacion c WHERE c.bono = :bono"),
    @NamedQuery(name = "Calificacion.findByPuntajemin", query = "SELECT c FROM Calificacion c WHERE c.puntajemin = :puntajemin"),
    @NamedQuery(name = "Calificacion.findByPuntajemax", query = "SELECT c FROM Calificacion c WHERE c.puntajemax = :puntajemax")})
public class Calificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcal")
    private Integer idcal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private Character nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bono")
    private int bono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntajemin")
    private int puntajemin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntajemax")
    private int puntajemax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcal")
    private List<Evaluacion> evaluacionList;

    public Calificacion() {
    }

    public Calificacion(Integer idcal) {
        this.idcal = idcal;
    }

    public Calificacion(Integer idcal, Character nombre, String descripcion, int bono, int puntajemin, int puntajemax) {
        this.idcal = idcal;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.bono = bono;
        this.puntajemin = puntajemin;
        this.puntajemax = puntajemax;
    }

    public Integer getIdcal() {
        return idcal;
    }

    public void setIdcal(Integer idcal) {
        this.idcal = idcal;
    }

    public Character getNombre() {
        return nombre;
    }

    public void setNombre(Character nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getBono() {
        return bono;
    }

    public void setBono(int bono) {
        this.bono = bono;
    }

    public int getPuntajemin() {
        return puntajemin;
    }

    public void setPuntajemin(int puntajemin) {
        this.puntajemin = puntajemin;
    }

    public int getPuntajemax() {
        return puntajemax;
    }

    public void setPuntajemax(int puntajemax) {
        this.puntajemax = puntajemax;
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
        hash += (idcal != null ? idcal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idcal == null && other.idcal != null) || (this.idcal != null && !this.idcal.equals(other.idcal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Calificacion[ idcal=" + idcal + " ]";
    }
    
}
