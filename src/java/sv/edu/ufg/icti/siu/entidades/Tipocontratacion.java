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
@Table(name = "tipocontratacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocontratacion.findAll", query = "SELECT t FROM Tipocontratacion t"),
    @NamedQuery(name = "Tipocontratacion.findByIdtipocontra", query = "SELECT t FROM Tipocontratacion t WHERE t.idtipocontra = :idtipocontra"),
    @NamedQuery(name = "Tipocontratacion.findByNombre", query = "SELECT t FROM Tipocontratacion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tipocontratacion.findByDescripcion", query = "SELECT t FROM Tipocontratacion t WHERE t.descripcion = :descripcion")})
public class Tipocontratacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipocontra")
    private Integer idtipocontra;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipocontra")
    private List<Investigador> investigadorList;

    public Tipocontratacion() {
    }

    public Tipocontratacion(Integer idtipocontra) {
        this.idtipocontra = idtipocontra;
    }

    public Integer getIdtipocontra() {
        return idtipocontra;
    }

    public void setIdtipocontra(Integer idtipocontra) {
        this.idtipocontra = idtipocontra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Investigador> getInvestigadorList() {
        return investigadorList;
    }

    public void setInvestigadorList(List<Investigador> investigadorList) {
        this.investigadorList = investigadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipocontra != null ? idtipocontra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocontratacion)) {
            return false;
        }
        Tipocontratacion other = (Tipocontratacion) object;
        if ((this.idtipocontra == null && other.idtipocontra != null) || (this.idtipocontra != null && !this.idtipocontra.equals(other.idtipocontra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Tipocontratacion[ idtipocontra=" + idtipocontra + " ]";
    }
    
}
