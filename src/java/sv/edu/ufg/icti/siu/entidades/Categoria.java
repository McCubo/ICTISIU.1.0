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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdcate", query = "SELECT c FROM Categoria c WHERE c.idcate = :idcate"),
    @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.nombre = :nombre")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcate")
    private Integer idcate;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcate")
    private List<Medicion> medicionList;

    public Categoria() {
    }

    public Categoria(Integer idcate) {
        this.idcate = idcate;
    }

    public Integer getIdcate() {
        return idcate;
    }

    public void setIdcate(Integer idcate) {
        this.idcate = idcate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Medicion> getMedicionList() {
        return medicionList;
    }

    public void setMedicionList(List<Medicion> medicionList) {
        this.medicionList = medicionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcate != null ? idcate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idcate == null && other.idcate != null) || (this.idcate != null && !this.idcate.equals(other.idcate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Categoria[ idcate=" + idcate + " ]";
    }
    
}
