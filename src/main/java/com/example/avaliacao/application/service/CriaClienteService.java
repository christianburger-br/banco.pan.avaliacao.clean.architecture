package com.example.avaliacao.application.service;
import com.example.avaliacao.adapter.persistence.AccountPersistenceAdapter;
import com.example.avaliacao.adapter.persistence.PessoaPersistenceAdapter;
import com.example.avaliacao.adapter.repository.PessoaRepository;
import com.example.avaliacao.application.domain.Account;
import com.example.avaliacao.application.domain.Endereco;
import com.example.avaliacao.application.domain.Pessoa;
import com.example.avaliacao.application.port.in.AlterarEnderecoUseCase;
import com.example.avaliacao.application.port.in.Command;
import com.example.avaliacao.application.port.in.CriaClienteUseCase;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Locale;

@Slf4j
@Service
public class CriaClienteService implements CriaClienteUseCase {

    @Autowired
	private PessoaPersistenceAdapter pessoaPersistenceAdapter;

	@Override
	public boolean execute(Command command) throws Exception {

		boolean result= false;
		if (command instanceof CriaClienteCommand) {
			long cpf= ((CriaClienteCommand) command).getPessoa().getCpf();

			Pessoa pessoa= ((CriaClienteCommand) command).getPessoa();
			Endereco endereco= ((CriaClienteCommand) command).getPessoa().getEndereco();
			log.info(String.format(Locale.getDefault(), "CriaClienteService: execute: nome: %s", pessoa.getNome()));
			log.info(String.format(Locale.getDefault(), "CriaClienteService: execute: sobrenome: %s", pessoa.getSobrenome()));
			log.info(String.format(Locale.getDefault(), "CriaClienteService: execute: cpf: %s", pessoa.getCpf()));
			log.info(String.format(Locale.getDefault(), "CriaClienteService: execute: endereco: %s", pessoa.getEndereco()));
			log.info(String.format(Locale.getDefault(), "CriaClienteService: execute: logradouro: %s", endereco.getLogradouro()));

			if (pessoaPersistenceAdapter== null ) {
			    pessoaPersistenceAdapter= new PessoaPersistenceAdapter();
				log.info(String.format(Locale.getDefault(), "CriaClienteService: execute: pessoaRepository == null: %s", pessoaPersistenceAdapter==null));
			}
			//Pessoa pessoaDB= pessoaPersistenceAdapter.savePessoa(pessoa);
			Pessoa pessoaDB= pessoaPersistenceAdapter.savePessoa(pessoa);
			log.info(String.format(Locale.getDefault(), "CriaClienteService: execute: pessoaDB: cpf: %s", pessoaDB.getCpf()));
			/*
			if (((AlterarEnderecoCommand) command).getTargetAccountId()!=null && account.getAccountID() == targetAccountId) {
            }
			*/
			// details for this UseCase

		} else {
	    	throw new Exception("Acao Inconsistente com UseCase");
		}
		return result;
	}

	@Value
	@EqualsAndHashCode(callSuper = false)
	public static class CriaClienteCommand implements Command {
		@Getter
		private Pessoa pessoa;

		public CriaClienteCommand( Pessoa pessoa) {
		    this.pessoa= pessoa;
		}
	}

}
