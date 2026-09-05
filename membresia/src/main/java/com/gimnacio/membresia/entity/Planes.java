/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gimnacio.membresia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author juanh
 */
@Entity
@Table(name = "planes")
@NamedQueries({
    @NamedQuery(name = "Planes.findAll", query = "SELECT p FROM Planes p")})
public class Planes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plan")
    private Integer idPlan;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "duracion_meses")
    private int duracionMeses;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlan")
    private List<Membresias> membresiasList;

    public Planes() {
    }

    public Planes(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Planes(Integer idPlan, String nombre, int duracionMeses, BigDecimal precio, boolean estado) {
        this.idPlan = idPlan;
        this.nombre = nombre;
        this.duracionMeses = duracionMeses;
        this.precio = precio;
        this.estado = estado;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Membresias> getMembresiasList() {
        return membresiasList;
    }

    public void setMembresiasList(List<Membresias> membresiasList) {
        this.membresiasList = membresiasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planes)) {
            return false;
        }
        Planes other = (Planes) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gimnacio.membresia.entity.Planes[ idPlan=" + idPlan + " ]";
    }
    
}
