package org.ecodigital.backend.controller;

import org.ecodigital.backend.model.Equipo;
import org.ecodigital.backend.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipoController {

    @Autowired
    private EquipoService service;

    @GetMapping
    public List<Equipo> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Equipo registrar(@RequestBody Equipo equipo) {
        return service.guardar(equipo);
    }

    @GetMapping("/{id}")
    public Equipo obtenerUno(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PutMapping
    public Equipo actualizar(@RequestBody Equipo equipo) {
        return service.actualizar(equipo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

}