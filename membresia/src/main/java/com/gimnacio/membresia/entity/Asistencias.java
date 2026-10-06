package com.gimnacio.membresia.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "asistencias")
public class Asistencias implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer idAsistencia;

    @JoinColumn(name = "id_miembro", referencedColumnName = "id_miembro", nullable = false)
    @ManyToOne(optional = false)
    private Miembros idMiembro;

    @Column(name = "fecha_asistencia", nullable = false)
    private LocalDateTime fechaAsistencia;

    public Asistencias() {
        this.fechaAsistencia = LocalDateTime.now();
    }

    public Integer getIdAsistencia() { return idAsistencia; }
    public void setIdAsistencia(Integer idAsistencia) { this.idAsistencia = idAsistencia; }

    public Miembros getIdMiembro() { return idMiembro; }
    public void setIdMiembro(Miembros idMiembro) { this.idMiembro = idMiembro; }

    public LocalDateTime getFechaAsistencia() { return fechaAsistencia; }
    public void setFechaAsistencia(LocalDateTime fechaAsistencia) { this.fechaAsistencia = fechaAsistencia; }
}