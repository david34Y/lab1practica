package com.example.lab1practica.controller;

import com.example.lab1practica.entity.Juego;
import com.example.lab1practica.repository.GamesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lab1practica.entity.Distribuidora;
import com.example.lab1practica.repository.DistribuidoraRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("juego")
public class GamesController {


    @Autowired
    GamesRepository gamesRepository;
    @GetMapping(value = {"","/lista"})
    public String listaJuegos (Model model){
        List<Juego> gamesList = gamesRepository.findByOrderByNombre();
        model.addAttribute("gamesList", gamesList);
        return "/juegos/lista";
    };
    @GetMapping(value = {"/guardar"})
    public String guardarJuegos(Juego juego){
        gamesRepository.save(juego);
        return "redirect:/juegos/lista";

    };
    @GetMapping(value = {"/editar"})
    public String editarJuegos(@RequestParam("id") int id,
                               Model model){
        Optional<Juego> optionalGamers = gamesRepository.findById(id);
        if(optionalGamers.isPresent()){
            Juego juego = optionalGamers.get();
            model.addAttribute("juego",juego);
            return "/juegos/editar";
        }else{
            return "redirect:/juegos/lista";
        }
    };

};


