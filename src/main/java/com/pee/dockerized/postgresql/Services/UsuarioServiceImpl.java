package com.pee.dockerized.postgresql.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import com.pee.dockerized.postgresql.Model.Usuario;
import com.pee.dockerized.postgresql.Repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Usuario add (Usuario usuario) {
        if (usuarioRepository.findByUsername(usuario.getUsername()) != null)
        return null; //ya existe ese nombre de usuario
        String passCrypted =    passwordEncoder.encode(usuario.getPassword());
        
        usuario.setPassword(passCrypted);
        usuarioRepository.save(usuario);
        return usuario;
    }


    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public void delete(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    public Usuario findByUsername(String nombre){
        return usuarioRepository.findByUsername(nombre);
    }
}