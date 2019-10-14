package com.example.avaliacao.application.port.in;

public interface AlterarEnderecoUseCase extends UseCase {
	@Override
	boolean execute(Command command) throws Exception;
}
