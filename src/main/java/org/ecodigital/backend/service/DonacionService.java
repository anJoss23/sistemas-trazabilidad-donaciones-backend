package org.ecodigital.backend.service;

import org.ecodigital.backend.model.Donacion;
import org.ecodigital.backend.repository.DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DonacionService {

    @Autowired
    private DonacionRepository repository;

    public List<Donacion> listarTodos() {
        return repository.findAll();
    }

    public Donacion guardar(Donacion donacion) {
        return repository.save(donacion);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}