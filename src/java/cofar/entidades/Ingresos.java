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
@Table(name = "ingresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingresos.findAll", query = "SELECT i FROM Ingresos i")
    , @NamedQuery(name = "Ingresos.findByCodIngreso", query = "SELECT i FROM Ingresos i WHERE i.codIngreso = :codIngreso")
    , @NamedQuery(name = "Ingresos.findByAnioIngreso", query = "SELECT i FROM Ingresos i WHERE i.anioIngreso = :anioIngreso")
    , @NamedQuery(name = "Ingresos.findByMesIngreso", query = "SELECT i FROM Ingresos i WHERE i.mesIngreso = :mesIngreso")})
public class Ingresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ingreso")
    private Integer codIngreso;
    @Size(max = 55)
    @Column(name = "anio_ingreso")
    private String anioIngreso;
    @Size(max = 55)
    @Column(name = "mes_ingreso")
    private String mesIngreso;
    @JoinColumn(name = "cod_almacen", referencedColumnName = "cod_almacen")
    @ManyToOne
    private Almacenes codAlmacen;
    @OneToMany(mappedBy = "codIngreso")
    private List<SalidasDetalle> salidasDetalleList;
    @OneToMany(mappedBy = "codIngreso")
    private List<IngresosDetalle> ingresosDetalleList;

    public Ingresos() {
    }

    public Ingresos(Integer codIngreso) {
        this.codIngreso = codIngreso;
    }

    public Integer getCodIngreso() {
        return codIngreso;
    }

    public void setCodIngreso(Integer codIngreso) {
        this.codIngreso = codIngreso;
    }

    public String getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(String anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String getMesIngreso() {
        return mesIngreso;
    }

    public void setMesIngreso(String mesIngreso) {
        this.mesIngreso = mesIngreso;
    }

    public Almacenes getCodAlmacen() {
        return codAlmacen;
    }

    public void setCodAlmacen(Almacenes codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    @XmlTransient
    public List<SalidasDetalle> getSalidasDetalleList() {
        return salidasDetalleList;
    }

    public void setSalidasDetalleList(List<SalidasDetalle> salidasDetalleList) {
        this.salidasDetalleList = salidasDetalleList;
    }

    @XmlTransient
    public List<IngresosDetalle> getIngresosDetalleList() {
        return ingresosDetalleList;
    }

    public void setIngresosDetalleList(List<IngresosDetalle> ingresosDetalleList) {
        this.ingresosDetalleList = ingresosDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIngreso != null ? codIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresos)) {
            return false;
        }
        Ingresos other = (Ingresos) object;
        if ((this.codIngreso == null && other.codIngreso != null) || (this.codIngreso != null && !this.codIngreso.equals(other.codIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Ingresos[ codIngreso=" + codIngreso + " ]";
    }
    
}
