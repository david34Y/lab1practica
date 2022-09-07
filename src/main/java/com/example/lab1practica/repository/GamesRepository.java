package com.example.lab1practica.repository;

import com.example.lab1practica.entity.Distribuidora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<Distribuidora,Integer> {
}
