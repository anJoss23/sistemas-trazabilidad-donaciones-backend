package org.ecodigital.backend.controller;

import org.ecodigital.backend.model.Usuario;
import org.ecodigital.backend.repository.UsuarioRepository;
import org.ecodigital.backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        String correo = credenciales.get("correo");
        String contraseña = credenciales.get("contraseña");

        // Buscamos al usuario en la BD
        Usuario usuario = usuarioRepository.findByCorreo(correo);

        // Verificamos si existe y si la contraseña encriptada coincide
        if (usuario != null && passwordEncoder.matches(contraseña, usuario.getContraseña())) {
            // Fabricamos el "pase de abordar"
            String token = jwtUtil.generarToken(correo);

            // Retornamos el token y los datos del usuario a Angular
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("usuario", usuario);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}