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
@Table(name = "almacenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacenes.findAll", query = "SELECT a FROM Almacenes a")
    , @NamedQuery(name = "Almacenes.findByCodAlmacen", query = "SELECT a FROM Almacenes a WHERE a.codAlmacen = :codAlmacen")
    , @NamedQuery(name = "Almacenes.findByRespAlmacen", query = "SELECT a FROM Almacenes a WHERE a.respAlmacen = :respAlmacen")
    , @NamedQuery(name = "Almacenes.findByTipousuario", query = "SELECT a FROM Almacenes a WHERE a.tipousuario = :tipousuario")})
public class Almacenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_almacen")
    private Integer codAlmacen;
    @Size(max = 100)
    @Column(name = "resp_almacen")
    private String respAlmacen;
    @Column(name = "tipousuario")
    private Integer tipousuario;
    @OneToMany(mappedBy = "codAlmacen")
    private List<Ingresos> ingresosList;
    @OneToMany(mappedBy = "codAlmacen")
    private List<Salidas> salidasList;

    public Almacenes() {
    }

    public Almacenes(Integer codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    public Integer getCodAlmacen() {
        return codAlmacen;
    }

    public void setCodAlmacen(Integer codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    public String getRespAlmacen() {
        return respAlmacen;
    }

    public void setRespAlmacen(String respAlmacen) {
        this.respAlmacen = respAlmacen;
    }

    public Integer getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(Integer tipousuario) {
        this.tipousuario = tipousuario;
    }

    @XmlTransient
    public List<Ingresos> getIngresosList() {
        return ingresosList;
    }

    public void setIngresosList(List<Ingresos> ingresosList) {
        this.ingresosList = ingresosList;
    }

    @XmlTransient
    public List<Salidas> getSalidasList() {
        return salidasList;
    }

    public void setSalidasList(List<Salidas> salidasList) {
        this.salidasList = salidasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlmacen != null ? codAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacenes)) {
            return false;
        }
        Almacenes other = (Almacenes) object;
        if ((this.codAlmacen == null && other.codAlmacen != null) || (this.codAlmacen != null && !this.codAlmacen.equals(other.codAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Almacenes[ codAlmacen=" + codAlmacen + " ]";
    }
    
}
