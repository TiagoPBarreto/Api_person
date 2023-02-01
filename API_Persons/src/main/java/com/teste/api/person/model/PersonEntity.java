package com.teste.api.person.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;


@Table
@Entity(name = "person_db")
public class PersonEntity implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE,pattern = "dd/MM/yyyy")
	private Date datadeNascimento;
	
	@Column
	private String enderecoPrincipal;
	
	@Column
	private Integer cep;
	
	@Column
	private Integer numero;
	
	@Column
	private String cidade;
	
	@Column
	private String enderecoSubstituto;
	
	@Column
	private Integer cepAux;
	
	@Column
	private Integer numeroAux;
	
	@Column
	private String cidadeAux;

	public PersonEntity() {}

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

	public Date getDatadeNascimento() {
		return datadeNascimento;
	}

	public void setDatadeNascimento(Date datadeNascimento) {
		this.datadeNascimento = datadeNascimento;
	}

	public String getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(String enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEnderecoSubstituto() {
		return enderecoSubstituto;
	}

	public void setEnderecoSubstituto(String enderecoSubstituto) {
		this.enderecoSubstituto = enderecoSubstituto;
	}

	public Integer getCepAux() {
		return cepAux;
	}

	public void setCepAux(Integer cepAux) {
		this.cepAux = cepAux;
	}

	public Integer getNumeroAux() {
		return numeroAux;
	}

	public void setNumeroAux(Integer numeroAux) {
		this.numeroAux = numeroAux;
	}

	public String getCidadeAux() {
		return cidadeAux;
	}

	public void setCidadeAux(String cidadeAux) {
		this.cidadeAux = cidadeAux;
	}

	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", nome=" + nome + ", datadeNascimento=" + datadeNascimento
				+ ", enderecoPrincipal=" + enderecoPrincipal + ", cep=" + cep + ", numero=" + numero + ", cidade="
				+ cidade + ", enderecoSubstituto=" + enderecoSubstituto + ", cepAux=" + cepAux + ", numeroAux="
				+ numeroAux + ", cidadeAux=" + cidadeAux + "]";
	}
}
