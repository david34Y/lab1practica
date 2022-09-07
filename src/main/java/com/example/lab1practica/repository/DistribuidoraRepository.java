package com.example.lab1practica.repository;

import com.example.lab1practica.entity.Distribuidora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistribuidoraRepository extends JpaRepository<Distribuidora,Integer> {
    List<Distribuidora> findByOrderByNombre();
}
