package com.example.avaliacao.application.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class Pessoa {
	@Id
	@Getter
	long cpf;

	@Setter
	@Getter
    @Transient
	private Account account;

	@Getter
	String nome;
	@Getter
	String sobrenome;

	@Getter
	@Setter
	@Transient
	Endereco endereco;

	public static Pessoa gerarNovaPessoa(String nome, String sobrenome, long cpf, String cep, String logradouro, String bairro, String municipio, String estado, String pais) {
		Endereco endereco= Endereco.gerarNovoEndereco(cep, logradouro, bairro, municipio, estado, pais);
		Account account= null;
		return new Pessoa(cpf, account, nome, sobrenome, endereco);
	}

	public static Pessoa gerarNovaPessoa(String nome, String sobrenome, long cpf, Endereco endereco) {
		Account account= null;
		return new Pessoa(cpf, account, nome, sobrenome, endereco);
	}
}

