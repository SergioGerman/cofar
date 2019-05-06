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
@Table(name = "boletas_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoletasDetalle.findAll", query = "SELECT b FROM BoletasDetalle b")
    , @NamedQuery(name = "BoletasDetalle.findByCodBoletadetalle", query = "SELECT b FROM BoletasDetalle b WHERE b.codBoletadetalle = :codBoletadetalle")
    , @NamedQuery(name = "BoletasDetalle.findByObservacion", query = "SELECT b FROM BoletasDetalle b WHERE b.observacion = :observacion")
    , @NamedQuery(name = "BoletasDetalle.findByCantidad", query = "SELECT b FROM BoletasDetalle b WHERE b.cantidad = :cantidad")
    , @NamedQuery(name = "BoletasDetalle.findByFechaEntrega", query = "SELECT b FROM BoletasDetalle b WHERE b.fechaEntrega = :fechaEntrega")})
public class BoletasDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_boletadetalle")
    private Integer codBoletadetalle;
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @JoinColumn(name = "cod_medico", referencedColumnName = "cod_medico")
    @ManyToOne
    private Medicos codMedico;
    @JoinColumn(name = "cod_mm", referencedColumnName = "cod_mm")
    @ManyToOne
    private Muestrasmedicas codMm;
    @JoinColumn(name = "cod_vm", referencedColumnName = "cod_vm")
    @ManyToOne
    private Visitadoresmedicos codVm;

    public BoletasDetalle() {
    }

    public BoletasDetalle(Integer codBoletadetalle) {
        this.codBoletadetalle = codBoletadetalle;
    }

    public Integer getCodBoletadetalle() {
        return codBoletadetalle;
    }

    public void setCodBoletadetalle(Integer codBoletadetalle) {
        this.codBoletadetalle = codBoletadetalle;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Medicos getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(Medicos codMedico) {
        this.codMedico = codMedico;
    }

    public Muestrasmedicas getCodMm() {
        return codMm;
    }

    public void setCodMm(Muestrasmedicas codMm) {
        this.codMm = codMm;
    }

    public Visitadoresmedicos getCodVm() {
        return codVm;
    }

    public void setCodVm(Visitadoresmedicos codVm) {
        this.codVm = codVm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBoletadetalle != null ? codBoletadetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BoletasDetalle)) {
            return false;
        }
        BoletasDetalle other = (BoletasDetalle) object;
        if ((this.codBoletadetalle == null && other.codBoletadetalle != null) || (this.codBoletadetalle != null && !this.codBoletadetalle.equals(other.codBoletadetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.BoletasDetalle[ codBoletadetalle=" + codBoletadetalle + " ]";
    }
    
}
