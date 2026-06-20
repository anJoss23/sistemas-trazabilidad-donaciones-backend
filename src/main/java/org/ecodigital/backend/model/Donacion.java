package org.ecodigital.backend.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "donacion")
public class Donacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donacion_id")
    private Integer donacionId;

    @ManyToOne
    @JoinColumn(name = "institucion_id", nullable = false)
    private InstitucionBeneficiaria institucion;

    @ManyToOne
    @JoinColumn(name = "usuario_id_responsable", nullable = false)
    private Usuario usuarioResponsable;

    @Column(name = "fecha_envio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;

    @Column(name = "numero_guia_remision", unique = true)
    private String numeroGuiaRemision;

    @Column(name = "documento_referencia_guia")
    private String documentoReferenciaGuia;

    // MAGIA DE SPRING BOOT: Maneja la tabla intermedia 'detalle_donacion'
    // automáticamente
    @ManyToMany
    @JoinTable(name = "detalle_donacion", joinColumns = @JoinColumn(name = "donacion_id"), inverseJoinColumns = @JoinColumn(name = "equipo_id"))
    private List<Equipo> equipos;

    // Getters y Setters
    public Integer getDonacionId() {
        return donacionId;
    }

    public void setDonacionId(Integer donacionId) {
        this.donacionId = donacionId;
    }

    public InstitucionBeneficiaria getInstitucion() {
        return institucion;
    }

    public void setInstitucion(InstitucionBeneficiaria institucion) {
        this.institucion = institucion;
    }

    public Usuario getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(Usuario usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getNumeroGuiaRemision() {
        return numeroGuiaRemision;
    }

    public void setNumeroGuiaRemision(String numeroGuiaRemision) {
        this.numeroGuiaRemision = numeroGuiaRemision;
    }

    public String getDocumentoReferenciaGuia() {
        return documentoReferenciaGuia;
    }

    public void setDocumentoReferenciaGuia(String documentoReferenciaGuia) {
        this.documentoReferenciaGuia = documentoReferenciaGuia;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}