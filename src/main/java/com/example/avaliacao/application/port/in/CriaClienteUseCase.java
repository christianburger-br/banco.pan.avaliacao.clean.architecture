package com.example.avaliacao.application.port.in;

public interface CriaClienteUseCase extends UseCase {
	@Override
	boolean execute(Command command) throws Exception;
}
