package br.com.zupacademy.gabriel.casadocodigo.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabriel.casadocodigo.entities.Estado;
import br.com.zupacademy.gabriel.casadocodigo.entities.Pais;

public class PaisDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String nome;
	private Set<EstadoDTO> estados = new HashSet<>();
	
	public PaisDTO () {
		
	}

	public PaisDTO(Long id, @NotBlank(message = "Campo Obrigatório") String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public PaisDTO (Pais entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}
	
	public PaisDTO (Pais entity, List<EstadoDTO> estados) {

		this.id = id;
		this.nome = nome;
		this.estados = estados.stream().map(x -> new EstadoDTO(x.toEntity(x))).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<EstadoDTO> getEstados() {
		return estados;
	}

	public void setEstados(Set<EstadoDTO> estados) {
		this.estados = estados;
	}

	public Pais toEntity (PaisDTO dto) {
	 var obj = new Pais(dto.getId(), dto.getNome());
	 return obj;
	}
}
