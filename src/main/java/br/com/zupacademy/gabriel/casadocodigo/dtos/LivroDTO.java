package br.com.zupacademy.gabriel.casadocodigo.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import br.com.zupacademy.gabriel.casadocodigo.entities.Autor;
import br.com.zupacademy.gabriel.casadocodigo.entities.Categoria;
import br.com.zupacademy.gabriel.casadocodigo.entities.Livro;

public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "O título do livro é obrigatório!")
	@Column(unique = true)
	private String titulo;
	@NotBlank(message = "Campo obrigatório!")
	@Length(max = 500, message = "O tamanho deve ter no máximo 500 caracteres!")
	private String resumo;
	@NotBlank(message = "Campo obrigatório!")
	private String sumario;
	@NotNull(message = "Campo obrigatório!")
	@Range(min = 20, message = "Preço mínimo é de R$ 20.0")
	private Double preco;
	@NotNull(message = "Campo obrigatório!")
	@Range(min = 100, message = "O livro deve conter no mínimo 100 páginas!")
	private Integer numeroDePaginas;
	@NotNull(message = "Campo obrigatório!")
	@Column(unique = true)
	private Long isbn;
	@FutureOrPresent(message = "Não é possível inserir uma data passada!")
	private LocalDate lancamento;
	@NotNull(message = "Campo obrigatório!")
	private Categoria categoria;
	@NotNull(message = "Campo obrigatório!")
	private Autor autor;
	
	public LivroDTO() {
		
	}

	public LivroDTO(Long id,String titulo, String resumo, String sumario, Double preco, Integer numeroDePaginas, Long isbn, LocalDate lancamento, Categoria categoria, Autor autor) {
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.lancamento = lancamento;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public LivroDTO (Livro entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.sumario = entity.getSumario();
		this.resumo = entity.getResumo();
		this.preco = entity.getPreco();
		this.numeroDePaginas = entity.getNumeroDePaginas();
		this.isbn = entity.getIsbn();
		this.autor = entity.getAutor();
		this.categoria = entity.getCategoria();
		this.lancamento = entity.getLancamento();
		}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(Integer numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public LocalDate getLancamento() {
		return lancamento;
	}

	public void setLancamento(LocalDate lancamento) {
		this.lancamento = lancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	public Livro toEntity(LivroDTO dto) {
		var obj = new Livro(dto.getId(),dto.getTitulo(),dto.getResumo(),dto.getSumario(),dto.getPreco(),dto.getNumeroDePaginas(),dto.getIsbn(),dto.getLancamento(),dto.getCategoria(),dto.getAutor());
		
		return obj;
	}

}
