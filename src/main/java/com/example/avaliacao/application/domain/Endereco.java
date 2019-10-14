package com.example.avaliacao.application.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	long id;

	@Getter
	String cep;
	@Getter
	String logradouro;
	@Getter
	String bairro;
	@Getter
	String municipio;
	@Getter
	String estado;
	@Getter
	String pais;

	public static Endereco gerarNovoEndereco(String cep, String logradouro, String bairro, String municipio, String estado, String pais) {
		return new Endereco(0, cep, logradouro, bairro, municipio, estado, pais);
	}
}

