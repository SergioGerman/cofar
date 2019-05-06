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
@Table(name = "ingresos_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresosDetalle.findAll", query = "SELECT i FROM IngresosDetalle i")
    , @NamedQuery(name = "IngresosDetalle.findByCodId", query = "SELECT i FROM IngresosDetalle i WHERE i.codId = :codId")
    , @NamedQuery(name = "IngresosDetalle.findByCantidad", query = "SELECT i FROM IngresosDetalle i WHERE i.cantidad = :cantidad")
    , @NamedQuery(name = "IngresosDetalle.findByCantidadRestante", query = "SELECT i FROM IngresosDetalle i WHERE i.cantidadRestante = :cantidadRestante")
    , @NamedQuery(name = "IngresosDetalle.findByLote", query = "SELECT i FROM IngresosDetalle i WHERE i.lote = :lote")
    , @NamedQuery(name = "IngresosDetalle.findByFechaRegistro", query = "SELECT i FROM IngresosDetalle i WHERE i.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "IngresosDetalle.findByEstadoIngreso", query = "SELECT i FROM IngresosDetalle i WHERE i.estadoIngreso = :estadoIngreso")
    , @NamedQuery(name = "IngresosDetalle.findByObservacion", query = "SELECT i FROM IngresosDetalle i WHERE i.observacion = :observacion")})
public class IngresosDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_id")
    private Integer codId;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "cantidad_restante")
    private Integer cantidadRestante;
    @Size(max = 55)
    @Column(name = "lote")
    private String lote;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 55)
    @Column(name = "estado_ingreso")
    private String estadoIngreso;
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "cod_ingreso", referencedColumnName = "cod_ingreso")
    @ManyToOne
    private Ingresos codIngreso;
    @JoinColumn(name = "cod_mm", referencedColumnName = "cod_mm")
    @ManyToOne
    private Muestrasmedicas codMm;

    public IngresosDetalle() {
    }

    public IngresosDetalle(Integer codId) {
        this.codId = codId;
    }

    public Integer getCodId() {
        return codId;
    }

    public void setCodId(Integer codId) {
        this.codId = codId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidadRestante() {
        return cantidadRestante;
    }

    public void setCantidadRestante(Integer cantidadRestante) {
        this.cantidadRestante = cantidadRestante;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstadoIngreso() {
        return estadoIngreso;
    }

    public void setEstadoIngreso(String estadoIngreso) {
        this.estadoIngreso = estadoIngreso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codId != null ? codId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresosDetalle)) {
            return false;
        }
        IngresosDetalle other = (IngresosDetalle) object;
        if ((this.codId == null && other.codId != null) || (this.codId != null && !this.codId.equals(other.codId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.IngresosDetalle[ codId=" + codId + " ]";
    }
    
}
