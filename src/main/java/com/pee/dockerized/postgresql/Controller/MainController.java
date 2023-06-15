package com.pee.dockerized.postgresql.Controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pee.dockerized.postgresql.dto.FormInfo;


@RestController
@RequestMapping("")
public class MainController {
    
    @GetMapping({"/","/login","/home"})
    public String indiceC(
        Model model,
        @RequestParam Optional <String> n
        ){
            model.addAttribute("nombre", n.orElse(""));
            int anhoActual = LocalDate.now().getYear();
            model.addAttribute("anhoActual", anhoActual);
        return("/api/home");
    }

    @GetMapping("/maps")
    public String contactaC(Model model){
        model.addAttribute("formInfo", new FormInfo());
        return("/api/maps");
    }

    @PostMapping("/maps**")
    public String contactaSubmit(@Valid FormInfo formInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "redirect:/api/maps";
        else {
        return "/api/maps";}
    }
    

    @GetMapping("/coordenadas")
    public String quienesC(){
        return("/api/coordenadas");
    }

}
