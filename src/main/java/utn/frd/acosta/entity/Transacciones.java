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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t"),
    @NamedQuery(name = "Transacciones.findById", query = "SELECT t FROM Transacciones t WHERE t.id = :id"),
    @NamedQuery(name = "Transacciones.findByMonto", query = "SELECT t FROM Transacciones t WHERE t.monto = :monto"),
    @NamedQuery(name = "Transacciones.findByFechaRealizacion", query = "SELECT t FROM Transacciones t WHERE t.fechaRealizacion = :fechaRealizacion"),
    @NamedQuery(name = "Transacciones.findByEstadoTransferencia", query = "SELECT t FROM Transacciones t WHERE t.estadoTransferencia = :estadoTransferencia"),
    @NamedQuery(name = "Transacciones.findByIdEmisor", query = "SELECT t FROM Transacciones t WHERE t.idEmisor = :idEmisor"),
    @NamedQuery(name = "Transacciones.findByIdReceptor", query = "SELECT t FROM Transacciones t WHERE t.idReceptor = :idReceptor")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private long monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_realizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaRealizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estado_transferencia")
    private String estadoTransferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_emisor")
    private int idEmisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_receptor")
    private int idReceptor;

    public Transacciones() {
    }

    public Transacciones(Integer id) {
        this.id = id;
    }

    public Transacciones(Integer id, long monto, Date fechaRealizacion, String estadoTransferencia, int idEmisor, int idReceptor) {
        this.id = id;
        this.monto = monto;
        this.fechaRealizacion = fechaRealizacion;
        this.estadoTransferencia = estadoTransferencia;
        this.idEmisor = idEmisor;
        this.idReceptor = idReceptor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getEstadoTransferencia() {
        return estadoTransferencia;
    }

    public void setEstadoTransferencia(String estadoTransferencia) {
        this.estadoTransferencia = estadoTransferencia;
    }

    public int getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(int idEmisor) {
        this.idEmisor = idEmisor;
    }

    public int getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(int idReceptor) {
        this.idReceptor = idReceptor;
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
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.acosta.entity.Transacciones[ id=" + id + " ]";
    }
    
}
