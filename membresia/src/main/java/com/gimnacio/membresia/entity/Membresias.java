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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juanh
 */
@Entity
@Table(name = "membresias")
@NamedQueries({
    @NamedQuery(name = "Membresias.findAll", query = "SELECT m FROM Membresias m")})
public class Membresias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_membresia")
    private Integer idMembresia;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "id_miembro", referencedColumnName = "id_miembro")
    @ManyToOne(optional = false)
    private Miembros idMiembro;
    @JoinColumn(name = "id_plan", referencedColumnName = "id_plan")
    @ManyToOne(optional = false)
    private Planes idPlan;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membresias")
    private List<Pagos> pagosList;

    public Membresias() {
    }

    public Membresias(Integer idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Membresias(Integer idMembresia, Date fechaInicio, Date fechaFin, boolean estado) {
        this.idMembresia = idMembresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Integer getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(Integer idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Miembros getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(Miembros idMiembro) {
        this.idMiembro = idMiembro;
    }

    public Planes getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Planes idPlan) {
        this.idPlan = idPlan;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembresia != null ? idMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membresias)) {
            return false;
        }
        Membresias other = (Membresias) object;
        if ((this.idMembresia == null && other.idMembresia != null) || (this.idMembresia != null && !this.idMembresia.equals(other.idMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gimnacio.membresia.entity.Membresias[ idMembresia=" + idMembresia + " ]";
    }
    
}
