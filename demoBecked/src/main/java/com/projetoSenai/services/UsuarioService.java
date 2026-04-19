package com.projetoSenai.services;

import org.springframework.stereotype.Service;

import com.projetoSenai.entities.Usuario;
import com.projetoSenai.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository reposiory) {
        this.repository = reposiory;
    }
    public Usuario cadastrar (Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado ");
        }
        return repository.save(usuario);
    }

}
