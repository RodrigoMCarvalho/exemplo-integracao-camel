package com.rodrigo.imovel.repository;

import com.rodrigo.imovel.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
