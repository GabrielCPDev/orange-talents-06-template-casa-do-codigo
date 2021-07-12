package br.com.zupacademy.gabriel.casadocodigo.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.gabriel.casadocodigo.entities.Cliente;
import br.com.zupacademy.gabriel.casadocodigo.entities.Endereco;


public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Campo Obrigatório!")
	private String nome;
	@NotEmpty(message = "Campo Obrigatório!")
	private String sobrenome;
	@Column(unique = true)
	@NotEmpty(message = "Campo Obrigatório!")
	private String email;
	@NotEmpty(message = "Campo Obrigatório!")
	@Column(unique = true)
	private String cpfOuCnpj;
	@ManyToOne
	@NotEmpty(message = "Campo Obrigatório!")
	private Endereco endereco;
	@NotEmpty(message = "Campo Obrigatório!")
	private Integer telefone;

	public ClienteDTO () {
		
	}
	public ClienteDTO(Integer id, String nome, String sobrenome, String email, String cpfOuCnpj, Endereco endereco, Integer telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public ClienteDTO(Cliente entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.cpfOuCnpj = entity.getCpfOuCnpj();
		this.endereco = entity.getEndereco();
		this.telefone = entity.getTelefone();
		this.sobrenome = entity.getSobrenome();
		this.nome = entity.getNome();
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
	public Cliente toEntity(ClienteDTO dto) {
		var obj = new Cliente(dto.getId(),dto.getNome(), dto.getSobrenome(), dto.getEmail(), dto.getCpfOuCnpj(), dto.getEndereco(),dto.getTelefone());
		return obj;
	}
}
