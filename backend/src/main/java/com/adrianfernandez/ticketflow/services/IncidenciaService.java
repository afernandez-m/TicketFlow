package com.adrianfernandez.ticketflow.service;

import com.adrianfernandez.ticketflow.entity.Estado;
import com.adrianfernandez.ticketflow.entity.Incidencia;
import com.adrianfernandez.ticketflow.repository.IncidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaService {

    private final IncidenciaRepository incidenciaRepository;

    public IncidenciaService(IncidenciaRepository incidenciaRepository) {
        this.incidenciaRepository = incidenciaRepository;
    }

    
    public List<Incidencia> listarTodas() {
        return incidenciaRepository.findAll();
    }


    public Incidencia crear(Incidencia incidencia) {
        return incidenciaRepository.save(Incidencia);
    }


    public Incidencia buscarPorId(Long id) {
        return incidenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));
    }


    public List<Incidencia> listarPorEstado(Estado estado) {
        return incidenciaRepository.findByEstado(estado);
    }


    public Incidencia cambiarEstado(Long id, Estado nuevoEstado) {
        Incidencia incidencia = buscarPorId(id);
        if (incidencia.getEstado() == Estado.CERRADA) {
            throw new RuntimeException("No se puede modificar el estado de una incidencia cerrada");
        }
        incidencia.setEstado(nuevoEstado);
        return incidenciaRepository.save(incidencia);
    }


    public void eliminar(Long id) {
        Incidencia incidencia = buscarPorId(id);
        incidenciaRepository.delete(incidencia);
    }
