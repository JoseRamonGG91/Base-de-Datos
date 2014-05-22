/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludoteca;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoseRamon
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findByVntNum", query = "SELECT v FROM Ventas v WHERE v.vntNum = :vntNum"),
    @NamedQuery(name = "Ventas.findByFechaCompra", query = "SELECT v FROM Ventas v WHERE v.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "Ventas.findBySegundaMano", query = "SELECT v FROM Ventas v WHERE v.segundaMano = :segundaMano"),
    @NamedQuery(name = "Ventas.findByCantidad", query = "SELECT v FROM Ventas v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "Ventas.findByImporteCompra", query = "SELECT v FROM Ventas v WHERE v.importeCompra = :importeCompra"),
    @NamedQuery(name = "Ventas.findByIva", query = "SELECT v FROM Ventas v WHERE v.iva = :iva"),
    @NamedQuery(name = "Ventas.findByDescuento", query = "SELECT v FROM Ventas v WHERE v.descuento = :descuento")})
public class Ventas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vnt_num")
    private Integer vntNum;
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Column(name = "segunda_mano")
    private Boolean segundaMano;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe_compra")
    private BigDecimal importeCompra;
    @Column(name = "IVA")
    private BigDecimal iva;
    @Column(name = "descuento")
    private BigDecimal descuento;
    @JoinColumn(name = "cli_num", referencedColumnName = "cli_num")
    @ManyToOne
    private Clientes cliNum;
    @JoinColumn(name = "jue_num", referencedColumnName = "jue_num")
    @ManyToOne
    private Juegos jueNum;

    public Ventas() {
    }

    public Ventas(Integer vntNum) {
        this.vntNum = vntNum;
    }

    public Ventas(Integer vntNum, Date fechaCompra, Boolean segundaMano, Clientes cliNum, Juegos jueNum) {
        this.vntNum = vntNum;
        this.fechaCompra = fechaCompra;
        this.segundaMano = segundaMano;
        this.cliNum = cliNum;
        this.jueNum = jueNum;
    }

    public Ventas(Integer vntNum, Clientes cliNum, Juegos jueNum) {
        this.vntNum = vntNum;
        this.cliNum = cliNum;
        this.jueNum = jueNum;
    }

    public Integer getVntNum() {
        return vntNum;
    }

    public void setVntNum(Integer vntNum) {
        this.vntNum = vntNum;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Boolean getSegundaMano() {
        return segundaMano;
    }

    public void setSegundaMano(Boolean segundaMano) {
        this.segundaMano = segundaMano;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getImporteCompra() {
        return importeCompra;
    }

    public void setImporteCompra(BigDecimal importeCompra) {
        this.importeCompra = importeCompra;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Clientes getCliNum() {
        return cliNum;
    }

    public void setCliNum(Clientes cliNum) {
        this.cliNum = cliNum;
    }

    public Juegos getJueNum() {
        return jueNum;
    }

    public void setJueNum(Juegos jueNum) {
        this.jueNum = jueNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vntNum != null ? vntNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.vntNum == null && other.vntNum != null) || (this.vntNum != null && !this.vntNum.equals(other.vntNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ludoteca.Ventas[ vntNum=" + vntNum + " ]";
    }
    
}
