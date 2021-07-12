package br.com.zupacademy.gabriel.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.gabriel.casadocodigo.entities.Cliente;
import br.com.zupacademy.gabriel.casadocodigo.entities.Endereco;
import br.com.zupacademy.gabriel.casadocodigo.entities.Livro;
import br.com.zupacademy.gabriel.casadocodigo.entities.Pais;

@Repository
public interface EnderecoRepository extends JpaRepository<Cliente, Long>{

}
