package com.rodrigo.autor.config;

import com.rodrigo.autor.model.Autor;
import com.rodrigo.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AutorInit implements ApplicationRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Autor autor1 = Autor.builder().nome("Neil Gaiman").email("email1@gmail.com").build();
        Autor autor2 = Autor.builder().nome("Frank Miller").email("email2@gmail.com").build();
        autorRepository.save(autor1);
        autorRepository.save(autor2);
    }
}
