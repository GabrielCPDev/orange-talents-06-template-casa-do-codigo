package br.com.zupacademy.gabriel.casadocodigo.resources;

import java.net.URI;
import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.gabriel.casadocodigo.dtos.AutorDTO;
import br.com.zupacademy.gabriel.casadocodigo.dtos.CategoriaDTO;
import br.com.zupacademy.gabriel.casadocodigo.entities.Autor;
import br.com.zupacademy.gabriel.casadocodigo.entities.Categoria;
import br.com.zupacademy.gabriel.casadocodigo.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AutorDTO> insert(@Valid @RequestBody CategoriaDTO categoriaDTO) throws MethodArgumentNotValidException{
		Categoria obj = categoriaDTO.toEntity(categoriaDTO);
		var cat = categoriaRepository.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
