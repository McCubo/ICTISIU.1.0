/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.icti.siu.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Entity
@Table(name = "detallemedicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallemedicion.findAll", query = "SELECT d FROM Detallemedicion d"),
    @NamedQuery(name = "Detallemedicion.findByIddetallemed", query = "SELECT d FROM Detallemedicion d WHERE d.iddetallemed = :iddetallemed"),
    @NamedQuery(name = "Detallemedicion.findByIsbn", query = "SELECT d FROM Detallemedicion d WHERE d.isbn = :isbn"),
    @NamedQuery(name = "Detallemedicion.findByDetalles", query = "SELECT d FROM Detallemedicion d WHERE d.detalles = :detalles")})
public class Detallemedicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallemed")
    private Integer iddetallemed;
    @Size(max = 15)
    @Column(name = "isbn")
    private String isbn;
    @Size(max = 100)
    @Column(name = "detalles")
    private String detalles;
    @JoinColumn(name = "idmedicion", referencedColumnName = "idmedicion")
    @ManyToOne(optional = false)
    private Medicion idmedicion;

    public Detallemedicion() {
    }

    public Detallemedicion(Integer iddetallemed) {
        this.iddetallemed = iddetallemed;
    }

    public Integer getIddetallemed() {
        return iddetallemed;
    }

    public void setIddetallemed(Integer iddetallemed) {
        this.iddetallemed = iddetallemed;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Medicion getIdmedicion() {
        return idmedicion;
    }

    public void setIdmedicion(Medicion idmedicion) {
        this.idmedicion = idmedicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallemed != null ? iddetallemed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallemedicion)) {
            return false;
        }
        Detallemedicion other = (Detallemedicion) object;
        if ((this.iddetallemed == null && other.iddetallemed != null) || (this.iddetallemed != null && !this.iddetallemed.equals(other.iddetallemed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Detallemedicion[ iddetallemed=" + iddetallemed + " ]";
    }
    
}
