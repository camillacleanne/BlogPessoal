package org.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //entidade do jpa hibernate
@Table(name="tb_tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Campo não pode ser nulo ou vazio")
	private String descricao;
	
	@OneToMany(mappedBy ="tema", cascade = CascadeType.ALL) // cascated all e fomos alterar alguma coisa referente a esse tema todas postagens serao alteradas
	@JsonIgnoreProperties("tema")
	private List<PostagemModel> postagemModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PostagemModel> getPostagemModel() {
		return postagemModel;
	}

	public void setPostagemModel(List<PostagemModel> postagemModel) {
		this.postagemModel = postagemModel;
	}
	
	
	
}
