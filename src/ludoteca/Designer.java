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
@Table(name = "designer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Designer.findAll", query = "SELECT d FROM Designer d"),
    @NamedQuery(name = "Designer.findByDesNum", query = "SELECT d FROM Designer d WHERE d.desNum = :desNum"),
    @NamedQuery(name = "Designer.findByDesNom", query = "SELECT d FROM Designer d WHERE d.desNom = :desNom"),
    @NamedQuery(name = "Designer.findByDesPais", query = "SELECT d FROM Designer d WHERE d.desPais = :desPais")})
public class Designer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "des_num")
    private Integer desNum;
    @Column(name = "des_nom")
    private String desNom;
    @Column(name = "des_pais")
    private String desPais;
    @OneToMany(mappedBy = "desNum")
    private Collection<Juegos> juegosCollection;

    public Designer() {
    }

    public Designer(Integer desNum) {
        this.desNum = desNum;
    }

    public Integer getDesNum() {
        return desNum;
    }

    public void setDesNum(Integer desNum) {
        this.desNum = desNum;
    }

    public String getDesNom() {
        return desNom;
    }

    public void setDesNom(String desNom) {
        this.desNom = desNom;
    }

    public String getDesPais() {
        return desPais;
    }

    public void setDesPais(String desPais) {
        this.desPais = desPais;
    }

    @XmlTransient
    public Collection<Juegos> getJuegosCollection() {
        return juegosCollection;
    }

    public void setJuegosCollection(Collection<Juegos> juegosCollection) {
        this.juegosCollection = juegosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desNum != null ? desNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Designer)) {
            return false;
        }
        Designer other = (Designer) object;
        if ((this.desNum == null && other.desNum != null) || (this.desNum != null && !this.desNum.equals(other.desNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ludoteca.Designer[ desNum=" + desNum + " ]";
    }
    
}
