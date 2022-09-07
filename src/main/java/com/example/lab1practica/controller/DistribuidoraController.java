package com.example.lab1practica.controller;

import com.example.lab1practica.entity.Distribuidora;
import com.example.lab1practica.repository.DistribuidoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("distribuidoras")
public class DistribuidoraController {
    @Autowired
    DistribuidoraRepository distributorsRepository;

    @GetMapping(value={"","/lista"})
    public String listaDistribuidoras (Model model){
        List<Distribuidora> distribuidoraList = distributorsRepository.findByOrderByNombre();
        model.addAttribute("distribuidoraList", distribuidoraList);
        return "lista";
    }

    @GetMapping(value={"/nuevo"})
    public String nuevaDistribuidoras(){
        return "nuevo";
    }

    @PostMapping(value = {"/guardar"})
    public String guardarDistribuidoras(Distribuidora distribuidora){
        distributorsRepository.save(distribuidora);
        return "redirect:lista";
    }

    @GetMapping(value = {"/editar"})
    public String editarDistribuidoras(@RequestParam("id") int id,
                                       Model model){
        Optional<Distribuidora> optionalDistributors = distributorsRepository.findById(id);
        if(optionalDistributors.isPresent()){
            Distribuidora distribuidora = optionalDistributors.get();
            model.addAttribute("distribuidora",distribuidora);
            return "editar";
        }else{
            return "redirect:lista";
        }
    }

    @GetMapping(value = {"/borrar"})
    public String eliminarDistribuidoras(@RequestParam("id") int id){
        Optional<Distribuidora> optionalDistributors = distributorsRepository.findById(id);
        if(optionalDistributors.isPresent()){
            distributorsRepository.deleteById(id);
        }
        return "redirect:lista";
    }
}
