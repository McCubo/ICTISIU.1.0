/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Entity
@Table(name = "gradoacademico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gradoacademico.findAll", query = "SELECT g FROM Gradoacademico g"),
    @NamedQuery(name = "Gradoacademico.findByIdgrado", query = "SELECT g FROM Gradoacademico g WHERE g.idgrado = :idgrado"),
    @NamedQuery(name = "Gradoacademico.findByNombre", query = "SELECT g FROM Gradoacademico g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Gradoacademico.findByDescripcion", query = "SELECT g FROM Gradoacademico g WHERE g.descripcion = :descripcion")})
public class Gradoacademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrado")
    private Integer idgrado;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "gradoacademicoList")
    private List<Investigador> investigadorList;

    public Gradoacademico() {
    }

    public Gradoacademico(Integer idgrado) {
        this.idgrado = idgrado;
    }

    public Integer getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(Integer idgrado) {
        this.idgrado = idgrado;
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
        hash += (idgrado != null ? idgrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gradoacademico)) {
            return false;
        }
        Gradoacademico other = (Gradoacademico) object;
        if ((this.idgrado == null && other.idgrado != null) || (this.idgrado != null && !this.idgrado.equals(other.idgrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Gradoacademico[ idgrado=" + idgrado + " ]";
    }
    
}
