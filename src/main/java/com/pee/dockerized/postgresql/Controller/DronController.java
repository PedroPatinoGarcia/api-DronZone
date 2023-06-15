package com.pee.dockerized.postgresql.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pee.dockerized.postgresql.Model.Dron;
import com.pee.dockerized.postgresql.Services.DronService;
import com.pee.dockerized.postgresql.Services.TipoDronService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/dron")
public class DronController {
    @Autowired
    public DronService dronService;
    @Autowired
    public TipoDronService tipoDronService;

    @GetMapping({ "/", "" ,"/list"})
    public String showList(Model model) {
        model.addAttribute("listaDron", dronService.findAll());
        model.addAttribute("listaTipoDron", tipoDronService.findAll());
        model.addAttribute("tipoDronSeleccionada", "Todos");
        return "dronView";
    }

    @GetMapping("/list/{idCat}")
    public String showListInCategory(@PathVariable long idCat, Model model) {
        model.addAttribute("listaDrones", dronService.findByTipoDron(tipoDronService.findById(idCat)));
        model.addAttribute("listaTipoDron", tipoDronService.findAll());
        model.addAttribute("tipoDronSeleccionada", tipoDronService.findById(idCat).getModelo()); 
    return "dronView";
    } 
   
    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("dronForm", new Dron());
        model.addAttribute("listaTipoDron", tipoDronService.findAll());
        return "newDron";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("dronForm") Dron nuevoDron,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newProducto";
            dronService.add(nuevoDron);
        return "redirect:/dron/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Dron dron = dronService.findById(id);
        if (dron != null) {
            model.addAttribute("dronForm", dron);
            model.addAttribute("listaTipoDrones", tipoDronService.findAll());
            return "editDron";
        }
        return "redirect:/dron";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        dronService.delete(id);
        return "redirect:/dron";
    }

}
