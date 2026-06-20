package org.ecodigital.backend.model;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;

    @Column(length = 255, nullable = false)
    private String nombre;

    @Column(length = 255, nullable = false, unique = true)
    private String correo;

    // Nota: Más adelante usaremos BCrypt para encriptar esto
    // El JSON desde Angular vendrá como "contrasena"
    // Pero Java lo mapeará a este campo "contraseña"
    @JsonProperty("contrasena")
    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private Date fechaCreacion;

    // Aquí está la magia de la Llave Foránea
    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private RolUsuario rol;

    // Constructor vacío
    public Usuario() {
    }

    // --- GETTERS Y SETTERS ---
    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
}