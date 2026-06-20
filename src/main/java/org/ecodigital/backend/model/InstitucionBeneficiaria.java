package org.ecodigital.backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "instituciones_beneficiarias")
public class InstitucionBeneficiaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer institucionId;

    @Column(name = "nombre_colegio", length = 255, nullable = false)
    private String nombreColegio;

    @Column(length = 255)
    private String director;

    @Column(length = 255)
    private String direccion;

    @Column(length = 50)
    private String ugel;

    @Column(name = "telefono_contacto", length = 20)
    private String telefonoContacto;

    @Column(name = "fecha_registro", insertable = false, updatable = false)
    private Date fechaRegistro;

    public InstitucionBeneficiaria() {
    }

    // --- GETTERS Y SETTERS ---
    public Integer getInstitucionId() {
        return institucionId;
    }

    public void setInstitucionId(Integer institucionId) {
        this.institucionId = institucionId;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUgel() {
        return ugel;
    }

    public void setUgel(String ugel) {
        this.ugel = ugel;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}