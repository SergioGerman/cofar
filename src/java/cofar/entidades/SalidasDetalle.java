/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofar.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergio German
 */
@Entity
@Table(name = "salidas_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidasDetalle.findAll", query = "SELECT s FROM SalidasDetalle s")
    , @NamedQuery(name = "SalidasDetalle.findByCodSd", query = "SELECT s FROM SalidasDetalle s WHERE s.codSd = :codSd")
    , @NamedQuery(name = "SalidasDetalle.findByCantidad", query = "SELECT s FROM SalidasDetalle s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SalidasDetalle.findByEstadoSalida", query = "SELECT s FROM SalidasDetalle s WHERE s.estadoSalida = :estadoSalida")
    , @NamedQuery(name = "SalidasDetalle.findByObservaciones", query = "SELECT s FROM SalidasDetalle s WHERE s.observaciones = :observaciones")
    , @NamedQuery(name = "SalidasDetalle.findByFechaSalida", query = "SELECT s FROM SalidasDetalle s WHERE s.fechaSalida = :fechaSalida")})
public class SalidasDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_sd")
    private Integer codSd;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 55)
    @Column(name = "estado_salida")
    private String estadoSalida;
    @Size(max = 55)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @JoinColumn(name = "cod_ingreso", referencedColumnName = "cod_ingreso")
    @ManyToOne
    private Ingresos codIngreso;
    @JoinColumn(name = "cod_mm", referencedColumnName = "cod_mm")
    @ManyToOne
    private Muestrasmedicas codMm;
    @JoinColumn(name = "cod_salida", referencedColumnName = "cod_salida")
    @ManyToOne
    private Salidas codSalida;

    public SalidasDetalle() {
    }

    public SalidasDetalle(Integer codSd) {
        this.codSd = codSd;
    }

    public Integer getCodSd() {
        return codSd;
    }

    public void setCodSd(Integer codSd) {
        this.codSd = codSd;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstadoSalida() {
        return estadoSalida;
    }

    public void setEstadoSalida(String estadoSalida) {
        this.estadoSalida = estadoSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Ingresos getCodIngreso() {
        return codIngreso;
    }

    public void setCodIngreso(Ingresos codIngreso) {
        this.codIngreso = codIngreso;
    }

    public Muestrasmedicas getCodMm() {
        return codMm;
    }

    public void setCodMm(Muestrasmedicas codMm) {
        this.codMm = codMm;
    }

    public Salidas getCodSalida() {
        return codSalida;
    }

    public void setCodSalida(Salidas codSalida) {
        this.codSalida = codSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSd != null ? codSd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidasDetalle)) {
            return false;
        }
        SalidasDetalle other = (SalidasDetalle) object;
        if ((this.codSd == null && other.codSd != null) || (this.codSd != null && !this.codSd.equals(other.codSd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.SalidasDetalle[ codSd=" + codSd + " ]";
    }
    
}
