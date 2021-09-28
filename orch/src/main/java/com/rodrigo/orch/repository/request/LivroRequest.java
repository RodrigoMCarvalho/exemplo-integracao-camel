package com.rodrigo.orch.repository.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroRequest {

    private String titulo;
    private Long autorId;
    private Long editoraId;
    private String editora;

}
