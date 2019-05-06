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
@Table(name = "accionesterapeuticas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accionesterapeuticas.findAll", query = "SELECT a FROM Accionesterapeuticas a")
    , @NamedQuery(name = "Accionesterapeuticas.findByCodAt", query = "SELECT a FROM Accionesterapeuticas a WHERE a.codAt = :codAt")
    , @NamedQuery(name = "Accionesterapeuticas.findByNombreAt", query = "SELECT a FROM Accionesterapeuticas a WHERE a.nombreAt = :nombreAt")})
public class Accionesterapeuticas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_at")
    private Integer codAt;
    @Size(max = 55)
    @Column(name = "nombre_at")
    private String nombreAt;
    @OneToMany(mappedBy = "codAt")
    private List<Muestrasmedicas> muestrasmedicasList;

    public Accionesterapeuticas() {
    }

    public Accionesterapeuticas(Integer codAt) {
        this.codAt = codAt;
    }

    public Integer getCodAt() {
        return codAt;
    }

    public void setCodAt(Integer codAt) {
        this.codAt = codAt;
    }

    public String getNombreAt() {
        return nombreAt;
    }

    public void setNombreAt(String nombreAt) {
        this.nombreAt = nombreAt;
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
        hash += (codAt != null ? codAt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accionesterapeuticas)) {
            return false;
        }
        Accionesterapeuticas other = (Accionesterapeuticas) object;
        if ((this.codAt == null && other.codAt != null) || (this.codAt != null && !this.codAt.equals(other.codAt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Accionesterapeuticas[ codAt=" + codAt + " ]";
    }
    
}
