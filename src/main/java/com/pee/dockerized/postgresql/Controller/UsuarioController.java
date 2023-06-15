package com.pee.dockerized.postgresql.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pee.dockerized.postgresql.Model.Usuario;
import com.pee.dockerized.postgresql.Services.UsuarioService;

@RestController
@RequestMapping("/login")
public class UsuarioController {
    @Autowired
    public UsuarioService usuarioService;

    @GetMapping({ "/", "/list" ,"" ,"/list/"})
    public String showList(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.findAll());
        return "/usuario/listUserView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("usuarioForm", new Usuario());
        return "/usuario/newUserView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("usuarioForm") Usuario usuario,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/usuario/newUserView";
        }
        usuarioService.add(usuario);
        return "redirect:/usuario/list/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        usuarioService.delete(usuarioService.findById(id));
        return "redirect:/usuario/list";
    }
}

