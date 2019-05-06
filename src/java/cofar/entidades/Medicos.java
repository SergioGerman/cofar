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
@Table(name = "medicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m")
    , @NamedQuery(name = "Medicos.findByCodMedico", query = "SELECT m FROM Medicos m WHERE m.codMedico = :codMedico")
    , @NamedQuery(name = "Medicos.findByNombre", query = "SELECT m FROM Medicos m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Medicos.findByApellido", query = "SELECT m FROM Medicos m WHERE m.apellido = :apellido")
    , @NamedQuery(name = "Medicos.findByDireccion", query = "SELECT m FROM Medicos m WHERE m.direccion = :direccion")
    , @NamedQuery(name = "Medicos.findByTelefono", query = "SELECT m FROM Medicos m WHERE m.telefono = :telefono")})
public class Medicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_medico")
    private Integer codMedico;
    @Size(max = 55)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 55)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 70)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "codMedico")
    private List<BoletasDetalle> boletasDetalleList;
    @OneToMany(mappedBy = "codMedico")
    private List<RutasDetalle> rutasDetalleList;

    public Medicos() {
    }

    public Medicos(Integer codMedico) {
        this.codMedico = codMedico;
    }

    public Integer getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(Integer codMedico) {
        this.codMedico = codMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<BoletasDetalle> getBoletasDetalleList() {
        return boletasDetalleList;
    }

    public void setBoletasDetalleList(List<BoletasDetalle> boletasDetalleList) {
        this.boletasDetalleList = boletasDetalleList;
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
        hash += (codMedico != null ? codMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.codMedico == null && other.codMedico != null) || (this.codMedico != null && !this.codMedico.equals(other.codMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Medicos[ codMedico=" + codMedico + " ]";
    }
    
}
