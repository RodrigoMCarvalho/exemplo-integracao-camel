package com.rodrigo.livro.config;

import com.rodrigo.livro.model.Livro;
import com.rodrigo.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LivroInit implements ApplicationRunner {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Livro livro1 = Livro.builder().titulo("Sandman").autorId(1L).editoraId(1L).build();
        Livro livro2 = Livro.builder().titulo("Cavaleiro das Trevas").autorId(2L).editoraId(1L).build();
        Livro livro3 = Livro.builder().titulo("Queda de Murdock").autorId(2L).editoraId(1L).build();
        Livro livro4 = Livro.builder().titulo(" Maxwell, o Gato Mágico ").autorId(3L).editoraId(2L).build();
        livroRepository.save(livro1);
        livroRepository.save(livro2);
        livroRepository.save(livro3);
        livroRepository.save(livro4);
    }
}
