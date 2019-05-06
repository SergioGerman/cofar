/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofar.entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergio German
 */
@Entity
@Table(name = "materialesapoyos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materialesapoyos.findAll", query = "SELECT m FROM Materialesapoyos m")
    , @NamedQuery(name = "Materialesapoyos.findByCodMa", query = "SELECT m FROM Materialesapoyos m WHERE m.codMa = :codMa")
    , @NamedQuery(name = "Materialesapoyos.findByDescripcion", query = "SELECT m FROM Materialesapoyos m WHERE m.descripcion = :descripcion")})
public class Materialesapoyos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ma")
    private Integer codMa;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "codMa")
    private List<Formasfarma> formasfarmaList;

    public Materialesapoyos() {
    }

    public Materialesapoyos(Integer codMa) {
        this.codMa = codMa;
    }

    public Integer getCodMa() {
        return codMa;
    }

    public void setCodMa(Integer codMa) {
        this.codMa = codMa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Formasfarma> getFormasfarmaList() {
        return formasfarmaList;
    }

    public void setFormasfarmaList(List<Formasfarma> formasfarmaList) {
        this.formasfarmaList = formasfarmaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMa != null ? codMa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materialesapoyos)) {
            return false;
        }
        Materialesapoyos other = (Materialesapoyos) object;
        if ((this.codMa == null && other.codMa != null) || (this.codMa != null && !this.codMa.equals(other.codMa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Materialesapoyos[ codMa=" + codMa + " ]";
    }
    
}
