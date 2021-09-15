package com.rodrigo.orch.repository.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponse {

    private Long id;
    private String titulo;
    private Long autorId;
}
