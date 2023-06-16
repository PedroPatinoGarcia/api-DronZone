package com.pee.dockerized.postgresql.Services;

import java.util.List;

import com.pee.dockerized.postgresql.Model.Usuario;

public interface UsuarioService{

    public Usuario add(Usuario e);
    public List<Usuario> findAll();
    public Usuario findById(long id);
    public Usuario findByUsername(String nombre);
    public boolean delete(Long id);
}