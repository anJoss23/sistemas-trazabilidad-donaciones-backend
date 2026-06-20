package org.ecodigital.backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial_cambios_estado") // Mapeado exactamente a tu DB
public class HistorialCambioEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historial_id")
    private Integer historialId;

    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "estado_anterior_id")
    private EstadoEquipo estadoAnterior;

    @ManyToOne
    @JoinColumn(name = "estado_nuevo_id", nullable = false)
    private EstadoEquipo estadoNuevo;

    @Column(name = "fecha_cambio", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambio = new Date(); // Registra la fecha actual automáticamente

    @ManyToOne
    @JoinColumn(name = "usuario_id_responsable", nullable = false)
    private Usuario usuarioResponsable;

    private String observaciones;

    // Getters y Setters
    public Integer getHistorialId() {
        return historialId;
    }

    public void setHistorialId(Integer historialId) {
        this.historialId = historialId;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public EstadoEquipo getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(EstadoEquipo estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public EstadoEquipo getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(EstadoEquipo estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Usuario getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(Usuario usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}