package com.rodrigo.editora.config;

import com.rodrigo.editora.model.Editora;
import com.rodrigo.editora.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EditaraInit implements ApplicationRunner {

    @Autowired
    private EditoraRepository editoraRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Editora autor1 = Editora.builder().nome("Panini").build();
        Editora autor2 = Editora.builder().nome("Pipoca e Naquim").build();
        editoraRepository.save(autor1);
        editoraRepository.save(autor2);
    }
}
