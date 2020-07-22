/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.acosta.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "inversiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inversiones.findAll", query = "SELECT i FROM Inversiones i"),
    @NamedQuery(name = "Inversiones.findById", query = "SELECT i FROM Inversiones i WHERE i.id = :id"),
    @NamedQuery(name = "Inversiones.findByFechaCreacion", query = "SELECT i FROM Inversiones i WHERE i.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Inversiones.findByIdCuenta", query = "SELECT i FROM Inversiones i WHERE i.idCuenta = :idCuenta"),
    @NamedQuery(name = "Inversiones.findByIdBono", query = "SELECT i FROM Inversiones i WHERE i.idBono = :idBono")})
public class Inversiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuenta")
    private int idCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_bono")
    private int idBono;

    public Inversiones() {
    }

    public Inversiones(Integer id) {
        this.id = id;
    }

    public Inversiones(Integer id, Date fechaCreacion, int idCuenta, int idBono) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.idCuenta = idCuenta;
        this.idBono = idBono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdBono() {
        return idBono;
    }

    public void setIdBono(int idBono) {
        this.idBono = idBono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inversiones)) {
            return false;
        }
        Inversiones other = (Inversiones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.acosta.entity.Inversiones[ id=" + id + " ]";
    }
    
}
