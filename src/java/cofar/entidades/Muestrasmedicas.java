/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofar.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergio German
 */
@Entity
@Table(name = "muestrasmedicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Muestrasmedicas.findAll", query = "SELECT m FROM Muestrasmedicas m")
    , @NamedQuery(name = "Muestrasmedicas.findByCodMm", query = "SELECT m FROM Muestrasmedicas m WHERE m.codMm = :codMm")
    , @NamedQuery(name = "Muestrasmedicas.findByNombreMm", query = "SELECT m FROM Muestrasmedicas m WHERE m.nombreMm = :nombreMm")
    , @NamedQuery(name = "Muestrasmedicas.findByFechaCaducidad", query = "SELECT m FROM Muestrasmedicas m WHERE m.fechaCaducidad = :fechaCaducidad")
    , @NamedQuery(name = "Muestrasmedicas.findByLote", query = "SELECT m FROM Muestrasmedicas m WHERE m.lote = :lote")})
public class Muestrasmedicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_mm")
    private Integer codMm;
    @Size(max = 55)
    @Column(name = "nombre_mm")
    private String nombreMm;
    @Column(name = "fecha_caducidad")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;
    @Size(max = 15)
    @Column(name = "lote")
    private String lote;
    @OneToMany(mappedBy = "codMm")
    private List<SalidasDetalle> salidasDetalleList;
    @JoinColumn(name = "cod_at", referencedColumnName = "cod_at")
    @ManyToOne
    private Accionesterapeuticas codAt;
    @JoinColumn(name = "cod_empaque", referencedColumnName = "cod_empaque")
    @ManyToOne
    private Empaques codEmpaque;
    @JoinColumn(name = "cod_ff", referencedColumnName = "cod_ff")
    @ManyToOne
    private Formasfarma codFf;
    @OneToMany(mappedBy = "codMm")
    private List<BoletasDetalle> boletasDetalleList;
    @OneToMany(mappedBy = "codMm")
    private List<IngresosDetalle> ingresosDetalleList;

    public Muestrasmedicas() {
    }

    public Muestrasmedicas(Integer codMm) {
        this.codMm = codMm;
    }

    public Integer getCodMm() {
        return codMm;
    }

    public void setCodMm(Integer codMm) {
        this.codMm = codMm;
    }

    public String getNombreMm() {
        return nombreMm;
    }

    public void setNombreMm(String nombreMm) {
        this.nombreMm = nombreMm;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    @XmlTransient
    public List<SalidasDetalle> getSalidasDetalleList() {
        return salidasDetalleList;
    }

    public void setSalidasDetalleList(List<SalidasDetalle> salidasDetalleList) {
        this.salidasDetalleList = salidasDetalleList;
    }

    public Accionesterapeuticas getCodAt() {
        return codAt;
    }

    public void setCodAt(Accionesterapeuticas codAt) {
        this.codAt = codAt;
    }

    public Empaques getCodEmpaque() {
        return codEmpaque;
    }

    public void setCodEmpaque(Empaques codEmpaque) {
        this.codEmpaque = codEmpaque;
    }

    public Formasfarma getCodFf() {
        return codFf;
    }

    public void setCodFf(Formasfarma codFf) {
        this.codFf = codFf;
    }

    @XmlTransient
    public List<BoletasDetalle> getBoletasDetalleList() {
        return boletasDetalleList;
    }

    public void setBoletasDetalleList(List<BoletasDetalle> boletasDetalleList) {
        this.boletasDetalleList = boletasDetalleList;
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
        hash += (codMm != null ? codMm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Muestrasmedicas)) {
            return false;
        }
        Muestrasmedicas other = (Muestrasmedicas) object;
        if ((this.codMm == null && other.codMm != null) || (this.codMm != null && !this.codMm.equals(other.codMm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Muestrasmedicas[ codMm=" + codMm + " ]";
    }
    
}
