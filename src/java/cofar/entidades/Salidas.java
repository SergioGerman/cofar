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
@Table(name = "salidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salidas.findAll", query = "SELECT s FROM Salidas s")
    , @NamedQuery(name = "Salidas.findByCodSalida", query = "SELECT s FROM Salidas s WHERE s.codSalida = :codSalida")
    , @NamedQuery(name = "Salidas.findByAnioSalida", query = "SELECT s FROM Salidas s WHERE s.anioSalida = :anioSalida")
    , @NamedQuery(name = "Salidas.findByMesSalida", query = "SELECT s FROM Salidas s WHERE s.mesSalida = :mesSalida")})
public class Salidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_salida")
    private Integer codSalida;
    @Size(max = 55)
    @Column(name = "anio_salida")
    private String anioSalida;
    @Size(max = 55)
    @Column(name = "mes_salida")
    private String mesSalida;
    @OneToMany(mappedBy = "codSalida")
    private List<SalidasDetalle> salidasDetalleList;
    @JoinColumn(name = "cod_almacen", referencedColumnName = "cod_almacen")
    @ManyToOne
    private Almacenes codAlmacen;

    public Salidas() {
    }

    public Salidas(Integer codSalida) {
        this.codSalida = codSalida;
    }

    public Integer getCodSalida() {
        return codSalida;
    }

    public void setCodSalida(Integer codSalida) {
        this.codSalida = codSalida;
    }

    public String getAnioSalida() {
        return anioSalida;
    }

    public void setAnioSalida(String anioSalida) {
        this.anioSalida = anioSalida;
    }

    public String getMesSalida() {
        return mesSalida;
    }

    public void setMesSalida(String mesSalida) {
        this.mesSalida = mesSalida;
    }

    @XmlTransient
    public List<SalidasDetalle> getSalidasDetalleList() {
        return salidasDetalleList;
    }

    public void setSalidasDetalleList(List<SalidasDetalle> salidasDetalleList) {
        this.salidasDetalleList = salidasDetalleList;
    }

    public Almacenes getCodAlmacen() {
        return codAlmacen;
    }

    public void setCodAlmacen(Almacenes codAlmacen) {
        this.codAlmacen = codAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSalida != null ? codSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salidas)) {
            return false;
        }
        Salidas other = (Salidas) object;
        if ((this.codSalida == null && other.codSalida != null) || (this.codSalida != null && !this.codSalida.equals(other.codSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cofar.entidades.Salidas[ codSalida=" + codSalida + " ]";
    }
    
}
