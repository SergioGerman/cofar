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
@Table(name = "empaques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empaques.findAll", query = "SELECT e FROM Empaques e")
    , @NamedQuery(name = "Empaques.findByCodEmpaque", query = "SELECT e FROM Empaques e WHERE e.codEmpaque = :codEmpaque")
    , @NamedQuery(name = "Empaques.findByNombreEmpaque", query = "SELECT e FROM Empaques e WHERE e.nombreEmpaque = :nombreEmpaque")})
public class Empaques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_empaque")
    private Integer codEmpaque;
    @Size(max = 55)
    @Column(name = "nombre_empaque")
    private String nombreEmpaque;
    @OneToMany(mappedBy = "codEmpaque")
    private List<Muestrasmedicas> muestrasmedicasList;

    public Empaques() {
    }

    public Empaques(Integer codEmpaque) {
        this.codEmpaque = codEmpaque;
    }

    public Integer getCodEmpaque() {
        return codEmpaque;
    }

    public void setCodEmpaque(Integer codEmpaque) {
        this.codEmpaque = codEmpaque;
    }

    public String getNombreEmpaque() {
        return nombreEmpaque;
    }

    public void setNombreEmpaque(String nombreEmpaque) {
        this.nombreEmpaque = nombreEmpaque;
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
        hash += (codEmpaque != null ? codEmpaque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empaques)) {
            return false;
        }
        Empaques other = (Empaques) object;
        if ((this.codEmpaque == null && other.codEmpaque != null) || (this.codEmpaque != null && !this.codEmpaque.equals(other.codEmpaque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Empaques[ codEmpaque=" + codEmpaque + " ]";
    }
    
}
