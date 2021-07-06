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
import br.com.zupacademy.gabriel.casadocodigo.entities.Autor;
import br.com.zupacademy.gabriel.casadocodigo.repositories.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorResource {

	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<AutorDTO> insert(@Valid @RequestBody AutorDTO autorDTO){
		Autor obj = autorDTO.toEnity(autorDTO);
		obj.setInstante(LocalDateTime.now());
		autorRepository.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
