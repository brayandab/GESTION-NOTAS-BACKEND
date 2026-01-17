package com.bdba.gestion_notas.repository;

import com.bdba.gestion_notas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {

}
