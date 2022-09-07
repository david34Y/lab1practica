package com.example.lab1practica.repository;

import com.example.lab1practica.entity.Distribuidora;
import com.example.lab1practica.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Juego,Integer> {
    List<Juego> findByOrderByNombre();
}
