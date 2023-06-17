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

import com.pee.dockerized.postgresql.Model.TipoDron;
import com.pee.dockerized.postgresql.Services.TipoDronService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tipoDron")
public class TipoDronController {

    @Autowired
    private TipoDronService tipoDronService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping({ "/", "" })
    public String showList(Model model) {
        model.addAttribute("listaTipoDron", tipoDronService.findAll());
        return "";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("") TipoDron nuevoTipoDron,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "";
            tipoDronService.add(nuevoTipoDron);
        return "";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        tipoDronService.delete(id);
        return "";
    }

}
