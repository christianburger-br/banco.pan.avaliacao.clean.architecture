package com.example.avaliacao.application.service;
import com.example.avaliacao.adapter.persistence.AccountPersistenceAdapter;
import com.example.avaliacao.application.domain.Account;
import com.example.avaliacao.application.domain.Endereco;
import com.example.avaliacao.application.port.in.AlterarEnderecoUseCase;
import com.example.avaliacao.application.port.in.Command;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.Locale;

@Slf4j
public class AlterarEnderecoService implements AlterarEnderecoUseCase {

	private AccountPersistenceAdapter accountPersistenceAdapter;

	@Override
	public boolean execute(Command command) throws Exception {

		boolean result= false;
		if (command instanceof AlterarEnderecoCommand) {
			long cpf= ((AlterarEnderecoCommand) command).getTargetAccountId().getAccountID();
			Account storedAccount= accountPersistenceAdapter.loadAccount(cpf);
			/*
			if (((AlterarEnderecoCommand) command).getTargetAccountId()!=null && account.getAccountID() == targetAccountId) {
            }
			*/
			// details for this UseCase
            Endereco endereco= ((AlterarEnderecoCommand) command).getEndereco();
            log.info(String.format(Locale.getDefault(), "AlterarEnderecoUseCase: execute: command.getEndereco: %s", endereco));

		} else {
	    	throw new Exception("Acao Inconsistente com UseCase");
		}
		return result;
	}

	@Value
	@EqualsAndHashCode(callSuper = false)
	public static class AlterarEnderecoCommand implements Command {

		@NotNull
        @Autowired
		@Getter
		private final Account targetAccountId;
		@Getter
		private final Endereco endereco;

		public AlterarEnderecoCommand( Account targetAccountId, Endereco endereco ) {
		    this.targetAccountId= targetAccountId;
		    this.endereco= endereco;
		}
	}

}
