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
import br.com.zupacademy.gabriel.casadocodigo.dtos.PaisDTO;
import br.com.zupacademy.gabriel.casadocodigo.entities.Autor;
import br.com.zupacademy.gabriel.casadocodigo.entities.Pais;
import br.com.zupacademy.gabriel.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.gabriel.casadocodigo.repositories.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisResource {

	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<PaisDTO> insert(@Valid @RequestBody PaisDTO paisDTO){
		Pais obj = paisDTO.toEntity(paisDTO);
		paisRepository.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
