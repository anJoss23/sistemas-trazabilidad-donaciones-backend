package org.ecodigital.backend.service;

import org.ecodigital.backend.model.Usuario;
import org.ecodigital.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; // Necesario para buscarPorId

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    // AÑADIDO: Método para buscar por ID (útil para editar en el frontend)
    public Usuario buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario guardar(Usuario usuario) {
        // Solo encriptamos si es un usuario nuevo o si se cambió la contraseña
        // Si la contraseña no empieza con el hash de bcrypt ($2a$), la encriptamos
        if (usuario.getContraseña() != null && !usuario.getContraseña().startsWith("$2a$")) {
            String contraseñaEncriptada = passwordEncoder.encode(usuario.getContraseña());
            usuario.setContraseña(contraseñaEncriptada);
        }
        return repository.save(usuario);
    }

    // AÑADIDO: Método para eliminar
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    public List<Usuario> listarTecnicos() {
        // Aquí llamamos al repositorio que modificamos hace un momento
        return repository.findByRolNombreRol("Técnico");
    }
}