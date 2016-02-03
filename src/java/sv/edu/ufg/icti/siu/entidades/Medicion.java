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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "medicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicion.findAll", query = "SELECT m FROM Medicion m"),
    @NamedQuery(name = "Medicion.findByIdmedicion", query = "SELECT m FROM Medicion m WHERE m.idmedicion = :idmedicion"),
    @NamedQuery(name = "Medicion.findByNombre", query = "SELECT m FROM Medicion m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Medicion.findByIndicador", query = "SELECT m FROM Medicion m WHERE m.indicador = :indicador"),
    @NamedQuery(name = "Medicion.findByPuntaje", query = "SELECT m FROM Medicion m WHERE m.puntaje = :puntaje")})
public class Medicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmedicion")
    private Integer idmedicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "indicador")
    private String indicador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntaje")
    private int puntaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedicion")
    private List<Evidencia> evidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedicion")
    private List<Detallemedicion> detallemedicionList;
    @JoinColumn(name = "idcate", referencedColumnName = "idcate")
    @ManyToOne(optional = false)
    private Categoria idcate;

    public Medicion() {
    }

    public Medicion(Integer idmedicion) {
        this.idmedicion = idmedicion;
    }

    public Medicion(Integer idmedicion, String nombre, String indicador, int puntaje) {
        this.idmedicion = idmedicion;
        this.nombre = nombre;
        this.indicador = indicador;
        this.puntaje = puntaje;
    }

    public Integer getIdmedicion() {
        return idmedicion;
    }

    public void setIdmedicion(Integer idmedicion) {
        this.idmedicion = idmedicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    @XmlTransient
    public List<Detallemedicion> getDetallemedicionList() {
        return detallemedicionList;
    }

    public void setDetallemedicionList(List<Detallemedicion> detallemedicionList) {
        this.detallemedicionList = detallemedicionList;
    }

    public Categoria getIdcate() {
        return idcate;
    }

    public void setIdcate(Categoria idcate) {
        this.idcate = idcate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicion != null ? idmedicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicion)) {
            return false;
        }
        Medicion other = (Medicion) object;
        if ((this.idmedicion == null && other.idmedicion != null) || (this.idmedicion != null && !this.idmedicion.equals(other.idmedicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Medicion[ idmedicion=" + idmedicion + " ]";
    }
    
}
