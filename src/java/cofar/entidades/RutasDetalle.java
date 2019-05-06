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
@Table(name = "rutas_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RutasDetalle.findAll", query = "SELECT r FROM RutasDetalle r")
    , @NamedQuery(name = "RutasDetalle.findByCodRutadetalle", query = "SELECT r FROM RutasDetalle r WHERE r.codRutadetalle = :codRutadetalle")
    , @NamedQuery(name = "RutasDetalle.findByEstadoVisita", query = "SELECT r FROM RutasDetalle r WHERE r.estadoVisita = :estadoVisita")
    , @NamedQuery(name = "RutasDetalle.findByObservacion", query = "SELECT r FROM RutasDetalle r WHERE r.observacion = :observacion")
    , @NamedQuery(name = "RutasDetalle.findByFechaHoraVisita", query = "SELECT r FROM RutasDetalle r WHERE r.fechaHoraVisita = :fechaHoraVisita")})
public class RutasDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_rutadetalle")
    private Integer codRutadetalle;
    @Size(max = 15)
    @Column(name = "estado_visita")
    private String estadoVisita;
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "fecha_hora_visita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraVisita;
    @JoinColumn(name = "cod_medico", referencedColumnName = "cod_medico")
    @ManyToOne
    private Medicos codMedico;
    @JoinColumn(name = "cod_ruta", referencedColumnName = "cod_ruta")
    @ManyToOne
    private Rutas codRuta;

    public RutasDetalle() {
    }

    public RutasDetalle(Integer codRutadetalle) {
        this.codRutadetalle = codRutadetalle;
    }

    public Integer getCodRutadetalle() {
        return codRutadetalle;
    }

    public void setCodRutadetalle(Integer codRutadetalle) {
        this.codRutadetalle = codRutadetalle;
    }

    public String getEstadoVisita() {
        return estadoVisita;
    }

    public void setEstadoVisita(String estadoVisita) {
        this.estadoVisita = estadoVisita;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaHoraVisita() {
        return fechaHoraVisita;
    }

    public void setFechaHoraVisita(Date fechaHoraVisita) {
        this.fechaHoraVisita = fechaHoraVisita;
    }

    public Medicos getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(Medicos codMedico) {
        this.codMedico = codMedico;
    }

    public Rutas getCodRuta() {
        return codRuta;
    }

    public void setCodRuta(Rutas codRuta) {
        this.codRuta = codRuta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRutadetalle != null ? codRutadetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RutasDetalle)) {
            return false;
        }
        RutasDetalle other = (RutasDetalle) object;
        if ((this.codRutadetalle == null && other.codRutadetalle != null) || (this.codRutadetalle != null && !this.codRutadetalle.equals(other.codRutadetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.RutasDetalle[ codRutadetalle=" + codRutadetalle + " ]";
    }
    
}
