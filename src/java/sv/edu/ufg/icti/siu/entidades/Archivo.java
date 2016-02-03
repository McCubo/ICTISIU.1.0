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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Melvin Caceres macrsys@gmail.com
 */
@Entity
@Table(name = "archivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a"),
    @NamedQuery(name = "Archivo.findByIdarchivo", query = "SELECT a FROM Archivo a WHERE a.idarchivo = :idarchivo"),
    @NamedQuery(name = "Archivo.findByRuta", query = "SELECT a FROM Archivo a WHERE a.ruta = :ruta")})
public class Archivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarchivo")
    private Integer idarchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ruta")
    private String ruta;
    @JoinColumn(name = "idevidencia", referencedColumnName = "idevidencia")
    @ManyToOne(optional = false)
    private Evidencia idevidencia;

    public Archivo() {
    }

    public Archivo(Integer idarchivo) {
        this.idarchivo = idarchivo;
    }

    public Archivo(Integer idarchivo, String ruta) {
        this.idarchivo = idarchivo;
        this.ruta = ruta;
    }

    public Integer getIdarchivo() {
        return idarchivo;
    }

    public void setIdarchivo(Integer idarchivo) {
        this.idarchivo = idarchivo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Evidencia getIdevidencia() {
        return idevidencia;
    }

    public void setIdevidencia(Evidencia idevidencia) {
        this.idevidencia = idevidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarchivo != null ? idarchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.idarchivo == null && other.idarchivo != null) || (this.idarchivo != null && !this.idarchivo.equals(other.idarchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ufg.icti.siu.entidades.Archivo[ idarchivo=" + idarchivo + " ]";
    }
    
}
