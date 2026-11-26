package com.adrianfernandez.ticketflow.repository;

import com.adrianfernandez.ticketflow.entity.Estado;
import com.adrianfernandez.ticketflow.entity.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {

    List<Incidencia> findByEstado(Estado estado);


}
