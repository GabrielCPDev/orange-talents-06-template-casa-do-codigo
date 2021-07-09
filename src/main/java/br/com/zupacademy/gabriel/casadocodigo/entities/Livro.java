package br.com.zupacademy.gabriel.casadocodigo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_livros")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@JsonIgnore
	@ManyToOne
	private Categoria categoria;
	@JsonIgnore
	@NotNull(message = "Campo obrigatório!")
	@ManyToOne
	private Autor autor;

	public Livro() {

	}

	public Livro(Long id, String titulo, String resumo, String sumario, Double preco, Integer numeroDePaginas,
			Long isbn, LocalDate lancamento, Categoria categoria, Autor autor) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
