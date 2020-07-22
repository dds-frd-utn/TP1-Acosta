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
@Table(name = "bonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonos.findAll", query = "SELECT b FROM Bonos b"),
    @NamedQuery(name = "Bonos.findById", query = "SELECT b FROM Bonos b WHERE b.id = :id"),
    @NamedQuery(name = "Bonos.findByNombre", query = "SELECT b FROM Bonos b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Bonos.findByPrecioCompra", query = "SELECT b FROM Bonos b WHERE b.precioCompra = :precioCompra"),
    @NamedQuery(name = "Bonos.findByVencimiento", query = "SELECT b FROM Bonos b WHERE b.vencimiento = :vencimiento"),
    @NamedQuery(name = "Bonos.findByPrecioPago", query = "SELECT b FROM Bonos b WHERE b.precioPago = :precioPago")})
public class Bonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_compra")
    private long precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vencimiento")
    @Temporal(TemporalType.DATE)
    private Date vencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_pago")
    private long precioPago;

    public Bonos() {
    }

    public Bonos(Integer id) {
        this.id = id;
    }

    public Bonos(Integer id, String nombre, long precioCompra, Date vencimiento, long precioPago) {
        this.id = id;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.vencimiento = vencimiento;
        this.precioPago = precioPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(long precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public long getPrecioPago() {
        return precioPago;
    }

    public void setPrecioPago(long precioPago) {
        this.precioPago = precioPago;
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
        if (!(object instanceof Bonos)) {
            return false;
        }
        Bonos other = (Bonos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.acosta.entity.Bonos[ id=" + id + " ]";
    }
    
}
