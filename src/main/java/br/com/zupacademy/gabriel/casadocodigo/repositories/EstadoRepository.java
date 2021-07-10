package br.com.zupacademy.gabriel.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.gabriel.casadocodigo.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
