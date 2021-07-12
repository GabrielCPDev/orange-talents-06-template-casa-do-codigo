package br.com.zupacademy.gabriel.casadocodigo.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.gabriel.casadocodigo.dtos.ClienteDTO;
import br.com.zupacademy.gabriel.casadocodigo.entities.Cliente;
import br.com.zupacademy.gabriel.casadocodigo.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteDTO clienteDTO) throws MethodArgumentNotValidException{
		Cliente obj = clienteDTO.toEntity(clienteDTO);
		var cat = clienteRepository.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
