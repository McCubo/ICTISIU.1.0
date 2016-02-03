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
@Table(name = "institucioncat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucioncat.findAll", query = "SELECT i FROM Institucioncat i"),
    @NamedQuery(name = "Institucioncat.findByIdinsticat", query = "SELECT i FROM Institucioncat i WHERE i.idinsticat = :idinsticat"),
    @NamedQuery(name = "Institucioncat.findByNombre", query = "SELECT i FROM Institucioncat i WHERE i.nombre = :nombre")})
public class Institucioncat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinsticat")
    private Integer idinsticat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinsticat")
    private List<Institucion> institucionList;

    public Institucioncat() {
    }

    public Institucioncat(Integer idinsticat) {
        this.idinsticat = idinsticat;
    }

    public Institucioncat(Integer idinsticat, String nombre) {
        this.idinsticat = idinsticat;
        this.nombre = nombre;
    }

    public Integer getIdinsticat() {
        return idinsticat;
    }

    public void setIdinsticat(Integer idinsticat) {
        this.idinsticat = idinsticat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Institucion> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<Institucion> institucionList) {
        this.institucionList = institucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinsticat != null ? idinsticat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucioncat)) {
            return false;
        }
        Institucioncat other = (Institucioncat) object;
        if ((this.idinsticat == null && other.idinsticat != null) || (this.idinsticat != null && !this.idinsticat.equals(other.idinsticat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Institucioncat[ idinsticat=" + idinsticat + " ]";
    }
    
}
