package br.com.zupacademy.gabriel.casadocodigo.resources;

import java.net.URI;
import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.gabriel.casadocodigo.dtos.AutorDTO;
import br.com.zupacademy.gabriel.casadocodigo.dtos.LivroDTO;
import br.com.zupacademy.gabriel.casadocodigo.entities.Autor;
import br.com.zupacademy.gabriel.casadocodigo.entities.Livro;
import br.com.zupacademy.gabriel.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.gabriel.casadocodigo.repositories.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	@Autowired
	private LivroRepository livroRepository;
	
	@PostMapping
	public ResponseEntity<LivroDTO> insert(@Valid @RequestBody LivroDTO livroDTO){
		Livro obj = livroDTO.toEntity(livroDTO);
		var result = livroRepository.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
