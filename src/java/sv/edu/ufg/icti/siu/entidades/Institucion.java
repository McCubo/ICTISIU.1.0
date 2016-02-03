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
@Table(name = "institucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i"),
    @NamedQuery(name = "Institucion.findByIdinstitucion", query = "SELECT i FROM Institucion i WHERE i.idinstitucion = :idinstitucion"),
    @NamedQuery(name = "Institucion.findByNombre", query = "SELECT i FROM Institucion i WHERE i.nombre = :nombre")})
public class Institucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinstitucion")
    private Integer idinstitucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinstitucion")
    private List<Evidencia> evidenciaList;
    @JoinColumn(name = "idinsticat", referencedColumnName = "idinsticat")
    @ManyToOne(optional = false)
    private Institucioncat idinsticat;

    public Institucion() {
    }

    public Institucion(Integer idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    public Institucion(Integer idinstitucion, String nombre) {
        this.idinstitucion = idinstitucion;
        this.nombre = nombre;
    }

    public Integer getIdinstitucion() {
        return idinstitucion;
    }

    public void setIdinstitucion(Integer idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    public Institucioncat getIdinsticat() {
        return idinsticat;
    }

    public void setIdinsticat(Institucioncat idinsticat) {
        this.idinsticat = idinsticat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstitucion != null ? idinstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.idinstitucion == null && other.idinstitucion != null) || (this.idinstitucion != null && !this.idinstitucion.equals(other.idinstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Institucion[ idinstitucion=" + idinstitucion + " ]";
    }
    
}
