package com.rodrigo.usuario.config;

import com.rodrigo.usuario.model.Usuario;
import com.rodrigo.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInit implements ApplicationRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario usuario1 = Usuario.builder().nome("Rodrigo").email("email1@gmail.com").build();
        Usuario usuario2 = Usuario.builder().nome("Gustavo").email("email2@gmail.com").build();
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }
}
