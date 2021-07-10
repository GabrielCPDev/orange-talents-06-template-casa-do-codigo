package br.com.zupacademy.gabriel.casadocodigo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.gabriel.casadocodigo.dtos.EstadoDTO;
import br.com.zupacademy.gabriel.casadocodigo.entities.Estado;
import br.com.zupacademy.gabriel.casadocodigo.repositories.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	public ResponseEntity<EstadoDTO> insert(@Valid @RequestBody EstadoDTO estadoDTO){
		Estado obj = estadoDTO.toEntity(estadoDTO);
		estadoRepository.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
