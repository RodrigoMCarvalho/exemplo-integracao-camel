package com.rodrigo.orch.repository.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutorResponse {

    private Long id;
    private String nome;
    private String email;
    private List<LivroResponse> livros;
}
