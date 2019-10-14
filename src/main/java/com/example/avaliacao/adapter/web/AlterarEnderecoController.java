package com.example.avaliacao.adapter.web;

import com.example.avaliacao.application.domain.Account;
import com.example.avaliacao.application.domain.Endereco;
import com.example.avaliacao.application.domain.Pessoa;
import com.example.avaliacao.application.port.in.AlterarEnderecoUseCase;
import com.example.avaliacao.application.port.in.CriaClienteUseCase;
import com.example.avaliacao.application.port.in.UseCase;
import com.example.avaliacao.application.service.AlterarEnderecoService;
import com.example.avaliacao.application.service.CriaClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Component
@Slf4j
public class AlterarEnderecoController {

	private Account account=null;

	@PostMapping(path = "/clientes/novoCliente" , produces = MediaType.APPLICATION_JSON_VALUE)
	String criarCliente(@RequestBody Pessoa pessoaJSON) throws Exception {
		log.info(String.format(Locale.getDefault(), "AlterarEnderecoController:novoCliente: nome: %s", pessoaJSON.getNome ()));
		log.info(String.format(Locale.getDefault(), "AlterarEnderecoController:novoCliente: sobrenome: %s", pessoaJSON.getSobrenome()));
		log.info(String.format(Locale.getDefault(), "AlterarEnderecoController:novoCliente: cpf: %s", pessoaJSON.getCpf()));

		CriaClienteService.CriaClienteCommand command= new CriaClienteService.CriaClienteCommand(pessoaJSON);
		UseCase useCase= new CriaClienteService();
		useCase.execute(command);

		return String.valueOf(pessoaJSON.getCpf());
	}

	@GetMapping(path = "/contas/newAccount")
	String newRandomAccount() {
		this.account= Account.gerarNovaConta();
		log.info(String.format(Locale.getDefault(), "AlterarEnderecoController:newAccount: %s", account.toString()));
		return String.valueOf(account.getAccountID());
	}

	@PostMapping(path = "/contas/newAccount" , produces = MediaType.APPLICATION_JSON_VALUE)
	String newAccount(@RequestBody Pessoa pessoaJSON) {
		log.info(String.format(Locale.getDefault(), "AlterarEnderecoController:newAccount: pessoaJSON: %s", pessoaJSON.toString()));
		//Pessoa pessoa= parsePessoa(pessoaJSON);
		this.account= Account.gerarNovaConta(pessoaJSON);
		log.info(String.format(Locale.getDefault(), "AlterarEnderecoController:newAccount: %s", account.getPessoa().getNome()));
		return String.valueOf(account.getAccountID());
	}

	@PostMapping(path = "/contas/alterarEndereco/{targetAccountId}", produces = MediaType.APPLICATION_JSON_VALUE)
	String alterarEndereco(@PathVariable("targetAccountId") long targetAccountId, @RequestBody Endereco enderecoJSON) throws Exception {
		log.info(String.format(Locale.getDefault(), "AlterarEnderecoController:alterarEndereco: enderecoJSON: %s", enderecoJSON.toString()));
		log.info(String.format(Locale.getDefault(), "AlterarEnderecoController:alterarEndereco: %s", targetAccountId ));
		JSONObject result= new JSONObject();
		result.put("resultado", false);

		if (account!=null && account.getAccountID() == targetAccountId) {
			//Endereco endereco = parseEndereco(enderecoJSON);
			AlterarEnderecoService.AlterarEnderecoCommand command= new AlterarEnderecoService.AlterarEnderecoCommand(account, enderecoJSON);
			UseCase useCase = new AlterarEnderecoService();
			useCase.execute(command);
			result.put("resultado", true);
			result.put("mensagem", "Endereco Alterado");
		} else {
			result.put("mensagem", "Nro. da conta Errado");
		}
		return result.toString();
	}

}
