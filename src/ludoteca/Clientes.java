/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludoteca;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoseRamon
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByCliNum", query = "SELECT c FROM Clientes c WHERE c.cliNum = :cliNum"),
    @NamedQuery(name = "Clientes.findByCliNom", query = "SELECT c FROM Clientes c WHERE c.cliNom = :cliNom"),
    @NamedQuery(name = "Clientes.findByCliTlf", query = "SELECT c FROM Clientes c WHERE c.cliTlf = :cliTlf"),
    @NamedQuery(name = "Clientes.findByCastigado", query = "SELECT c FROM Clientes c WHERE c.castigado = :castigado")})
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cli_num")
    private Integer cliNum;
    @Column(name = "cli_nom")
    private String cliNom;
    @Column(name = "cli_tlf")
    private String cliTlf;
    @Column(name = "castigado")
    private Boolean castigado;
    @OneToMany(mappedBy = "cliNum")
    private Collection<Ventas> ventasCollection;

    public Clientes() {
    }

    public Clientes(Integer cliNum) {
        this.cliNum = cliNum;
    }

    public Clientes(Integer cliNum, String cliNom) {
        this.cliNum = cliNum;
        this.cliNom = cliNom;
    }

    public Integer getCliNum() {
        return cliNum;
    }

    public void setCliNum(Integer cliNum) {
        this.cliNum = cliNum;
    }

    public String getCliNom() {
        return cliNom;
    }

    public void setCliNom(String cliNom) {
        this.cliNom = cliNom;
    }

    public String getCliTlf() {
        return cliTlf;
    }

    public void setCliTlf(String cliTlf) {
        this.cliTlf = cliTlf;
    }

    public Boolean getCastigado() {
        return castigado;
    }

    public void setCastigado(Boolean castigado) {
        this.castigado = castigado;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliNum != null ? cliNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.cliNum == null && other.cliNum != null) || (this.cliNum != null && !this.cliNum.equals(other.cliNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ludoteca.Clientes[ cliNum=" + cliNum + " ]";
    }
    
}
