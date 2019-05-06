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
@Table(name = "cofar.visitadoresmedicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitadoresmedicos.findAll", query = "SELECT v FROM Visitadoresmedicos v")
    , @NamedQuery(name = "Visitadoresmedicos.findByCodVm", query = "SELECT v FROM Visitadoresmedicos v WHERE v.codVm = :codVm")
    , @NamedQuery(name = "Visitadoresmedicos.findByNombre", query = "SELECT v FROM Visitadoresmedicos v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Visitadoresmedicos.findByApellidoPat", query = "SELECT v FROM Visitadoresmedicos v WHERE v.apellidoPat = :apellidoPat")
    , @NamedQuery(name = "Visitadoresmedicos.findByApellidoMat", query = "SELECT v FROM Visitadoresmedicos v WHERE v.apellidoMat = :apellidoMat")
    , @NamedQuery(name = "Visitadoresmedicos.findByTelefono", query = "SELECT v FROM Visitadoresmedicos v WHERE v.telefono = :telefono")
    , @NamedQuery(name = "Visitadoresmedicos.findByEmail", query = "SELECT v FROM Visitadoresmedicos v WHERE v.email = :email")
    , @NamedQuery(name = "Visitadoresmedicos.findByFechaNac", query = "SELECT v FROM Visitadoresmedicos v WHERE v.fechaNac = :fechaNac")
    , @NamedQuery(name = "Visitadoresmedicos.findByCi", query = "SELECT v FROM Visitadoresmedicos v WHERE v.ci = :ci")
    , @NamedQuery(name = "Visitadoresmedicos.findByTipousuario", query = "SELECT v FROM Visitadoresmedicos v WHERE v.tipousuario = :tipousuario")})
public class Visitadoresmedicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_vm")
    private Integer codVm;
    @Size(max = 55)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 55)
    @Column(name = "apellido_pat")
    private String apellidoPat;
    @Size(max = 55)
    @Column(name = "apellido_mat")
    private String apellidoMat;
    @Size(max = 55)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 55)
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "ci")
    private Integer ci;
    @Column(name = "tipousuario")
    private Integer tipousuario;
    @OneToMany(mappedBy = "codVm")
    private List<BoletasDetalle> boletasDetalleList;
    @OneToMany(mappedBy = "codVm")
    private List<Rutas> rutasList;

    public Visitadoresmedicos() {
    }

    public Visitadoresmedicos(Integer codVm) {
        this.codVm = codVm;
    }

    public Integer getCodVm() {
        return codVm;
    }

    public void setCodVm(Integer codVm) {
        this.codVm = codVm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(Integer tipousuario) {
        this.tipousuario = tipousuario;
    }

    @XmlTransient
    public List<BoletasDetalle> getBoletasDetalleList() {
        return boletasDetalleList;
    }

    public void setBoletasDetalleList(List<BoletasDetalle> boletasDetalleList) {
        this.boletasDetalleList = boletasDetalleList;
    }

    @XmlTransient
    public List<Rutas> getRutasList() {
        return rutasList;
    }

    public void setRutasList(List<Rutas> rutasList) {
        this.rutasList = rutasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVm != null ? codVm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitadoresmedicos)) {
            return false;
        }
        Visitadoresmedicos other = (Visitadoresmedicos) object;
        if ((this.codVm == null && other.codVm != null) || (this.codVm != null && !this.codVm.equals(other.codVm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Visitadoresmedicos[ codVm=" + codVm + " ]";
    }
    
}
