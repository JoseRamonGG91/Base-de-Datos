/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludoteca;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoseRamon
 */
@Entity
@Table(name = "juegos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juegos.findAll", query = "SELECT j FROM Juegos j"),
    @NamedQuery(name = "Juegos.findByJueNum", query = "SELECT j FROM Juegos j WHERE j.jueNum = :jueNum"),
    @NamedQuery(name = "Juegos.findByJueNom", query = "SELECT j FROM Juegos j WHERE j.jueNom = :jueNom"),
    @NamedQuery(name = "Juegos.findByJueFecha", query = "SELECT j FROM Juegos j WHERE j.jueFecha = :jueFecha")})
public class Juegos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jue_num")
    private Integer jueNum;
    @Basic(optional = false)
    @Column(name = "jue_nom")
    private String jueNom;
    @Basic(optional = false)
    @Column(name = "jue_fecha")
    @Temporal(TemporalType.DATE)
    private Date jueFecha;
    @JoinColumn(name = "des_num", referencedColumnName = "des_num")
    @ManyToOne
    private Designer desNum;
    @OneToMany(mappedBy = "jueNum")
    private Collection<Ventas> ventasCollection;

    public Juegos() {
    }

    public Juegos(Integer jueNum) {
        this.jueNum = jueNum;
    }

    public Juegos(Integer jueNum, String jueNom) {
        this.jueNum = jueNum;
        this.jueNom = jueNom;
    }
    
    public Juegos(Integer jueNum, String jueNom, Date jueFecha) {
        this.jueNum = jueNum;
        this.jueNom = jueNom;
        this.jueFecha = jueFecha;
    }

    public Integer getJueNum() {
        return jueNum;
    }

    public void setJueNum(Integer jueNum) {
        this.jueNum = jueNum;
    }

    public String getJueNom() {
        return jueNom;
    }

    public void setJueNom(String jueNom) {
        this.jueNom = jueNom;
    }

    public Date getJueFecha() {
        return jueFecha;
    }

    public void setJueFecha(Date jueFecha) {
        this.jueFecha = jueFecha;
    }

    public Designer getDesNum() {
        return desNum;
    }

    public void setDesNum(Designer desNum) {
        this.desNum = desNum;
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
        hash += (jueNum != null ? jueNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juegos)) {
            return false;
        }
        Juegos other = (Juegos) object;
        if ((this.jueNum == null && other.jueNum != null) || (this.jueNum != null && !this.jueNum.equals(other.jueNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ludoteca.Juegos[ jueNum=" + jueNum + " ]";
    }
    
}
