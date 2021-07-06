package br.com.zupacademy.gabriel.casadocodigo.dtos;

import java.time.LocalDateTime;

import br.com.zupacademy.gabriel.casadocodigo.entities.Autor;

public class AutorDTO {

	private Long id;
	private String nome;
	
	private String email;
	private String descricao;
	private LocalDateTime instante;
	
	public AutorDTO () {
		
	}
	
	public AutorDTO(Long id, String nome, String email, String descricao, LocalDateTime instante) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.instante = instante;
	}



	public AutorDTO (Autor entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.descricao = entity.getDescricao();
		this.nome = entity.getNome();
		this.instante = entity.getInstante();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getInstante() {
		return instante;
	}
	
	public Autor toEnity (AutorDTO dto) {
		Autor obj = new Autor(dto.id, dto.getNome(), dto.email, dto.getDescricao(), dto.getInstante());
		return obj;
	}
}
