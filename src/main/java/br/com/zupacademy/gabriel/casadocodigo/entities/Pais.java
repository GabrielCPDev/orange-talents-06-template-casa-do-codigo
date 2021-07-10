package br.com.zupacademy.gabriel.casadocodigo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.zupacademy.gabriel.casadocodigo.dtos.PaisDTO;

@Entity
@Table(name = "tb_paises")
public class Pais implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	@Column(unique = true)
	private String nome;
	@JsonIgnore
	@OneToMany(mappedBy = "pais")
	private Set<Estado> estados = new HashSet<>();
	
	public Pais () {
		
	}

	public Pais(Long id, @NotBlank(message = "Campo Obrigatório") String nome) {
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

	public Set<Estado> getEstados() {
		return estados;
	}

	public void setEstados(Set<Estado> estados) {
		this.estados = estados;
	}
	
}
