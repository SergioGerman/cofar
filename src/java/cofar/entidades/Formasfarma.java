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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "formasfarma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formasfarma.findAll", query = "SELECT f FROM Formasfarma f")
    , @NamedQuery(name = "Formasfarma.findByCodFf", query = "SELECT f FROM Formasfarma f WHERE f.codFf = :codFf")
    , @NamedQuery(name = "Formasfarma.findByNombreFf", query = "SELECT f FROM Formasfarma f WHERE f.nombreFf = :nombreFf")})
public class Formasfarma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ff")
    private Integer codFf;
    @Size(max = 60)
    @Column(name = "nombre_ff")
    private String nombreFf;
    @JoinColumn(name = "cod_ma", referencedColumnName = "cod_ma")
    @ManyToOne
    private Materialesapoyos codMa;
    @OneToMany(mappedBy = "codFf")
    private List<Muestrasmedicas> muestrasmedicasList;

    public Formasfarma() {
    }

    public Formasfarma(Integer codFf) {
        this.codFf = codFf;
    }

    public Integer getCodFf() {
        return codFf;
    }

    public void setCodFf(Integer codFf) {
        this.codFf = codFf;
    }

    public String getNombreFf() {
        return nombreFf;
    }

    public void setNombreFf(String nombreFf) {
        this.nombreFf = nombreFf;
    }

    public Materialesapoyos getCodMa() {
        return codMa;
    }

    public void setCodMa(Materialesapoyos codMa) {
        this.codMa = codMa;
    }

    @XmlTransient
    public List<Muestrasmedicas> getMuestrasmedicasList() {
        return muestrasmedicasList;
    }

    public void setMuestrasmedicasList(List<Muestrasmedicas> muestrasmedicasList) {
        this.muestrasmedicasList = muestrasmedicasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFf != null ? codFf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formasfarma)) {
            return false;
        }
        Formasfarma other = (Formasfarma) object;
        if ((this.codFf == null && other.codFf != null) || (this.codFf != null && !this.codFf.equals(other.codFf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Formasfarma[ codFf=" + codFf + " ]";
    }
    
}
