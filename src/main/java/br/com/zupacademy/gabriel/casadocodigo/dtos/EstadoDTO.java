package br.com.zupacademy.gabriel.casadocodigo.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.casadocodigo.entities.Estado;
import br.com.zupacademy.gabriel.casadocodigo.entities.Pais;

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Campo obrigatório")
	@Column(unique = true)
	private String nome;
	@NotNull
	private Pais pais;

	public EstadoDTO() {

	}

	public EstadoDTO(Estado entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.pais = entity.getPais();
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado toEntity(EstadoDTO dto) {
		var obj = new Estado(dto.getId(), dto.getNome(), dto.getPais());
		return obj;
	}
}
