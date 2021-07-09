package br.com.zupacademy.gabriel.casadocodigo.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabriel.casadocodigo.entities.Categoria;
import br.com.zupacademy.gabriel.casadocodigo.resources.validation.CategoriaInsert;

@CategoriaInsert
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Campo nome é obrigatório")
	@Column(unique = true)
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}

	public CategoriaDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	public Categoria toEntity(CategoriaDTO dto) {
		Categoria obj = new Categoria(dto.getId(), dto.getNome());
		return obj;
	}
	
	
}
