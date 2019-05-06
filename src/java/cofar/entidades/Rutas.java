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
@Table(name = "rutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r")
    , @NamedQuery(name = "Rutas.findByCodRuta", query = "SELECT r FROM Rutas r WHERE r.codRuta = :codRuta")
    , @NamedQuery(name = "Rutas.findByAnioPlan", query = "SELECT r FROM Rutas r WHERE r.anioPlan = :anioPlan")
    , @NamedQuery(name = "Rutas.findByMesPlan", query = "SELECT r FROM Rutas r WHERE r.mesPlan = :mesPlan")
    , @NamedQuery(name = "Rutas.findByFechaRegistro", query = "SELECT r FROM Rutas r WHERE r.fechaRegistro = :fechaRegistro")})
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ruta")
    private Integer codRuta;
    @Size(max = 5)
    @Column(name = "anio_plan")
    private String anioPlan;
    @Size(max = 14)
    @Column(name = "mes_plan")
    private String mesPlan;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "cod_vm", referencedColumnName = "cod_vm")
    @ManyToOne
    private Visitadoresmedicos codVm;
    @OneToMany(mappedBy = "codRuta")
    private List<RutasDetalle> rutasDetalleList;

    public Rutas() {
    }

    public Rutas(Integer codRuta) {
        this.codRuta = codRuta;
    }

    public Integer getCodRuta() {
        return codRuta;
    }

    public void setCodRuta(Integer codRuta) {
        this.codRuta = codRuta;
    }

    public String getAnioPlan() {
        return anioPlan;
    }

    public void setAnioPlan(String anioPlan) {
        this.anioPlan = anioPlan;
    }

    public String getMesPlan() {
        return mesPlan;
    }

    public void setMesPlan(String mesPlan) {
        this.mesPlan = mesPlan;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Visitadoresmedicos getCodVm() {
        return codVm;
    }

    public void setCodVm(Visitadoresmedicos codVm) {
        this.codVm = codVm;
    }

    @XmlTransient
    public List<RutasDetalle> getRutasDetalleList() {
        return rutasDetalleList;
    }

    public void setRutasDetalleList(List<RutasDetalle> rutasDetalleList) {
        this.rutasDetalleList = rutasDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRuta != null ? codRuta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.codRuta == null && other.codRuta != null) || (this.codRuta != null && !this.codRuta.equals(other.codRuta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Rutas[ codRuta=" + codRuta + " ]";
    }
    
}
