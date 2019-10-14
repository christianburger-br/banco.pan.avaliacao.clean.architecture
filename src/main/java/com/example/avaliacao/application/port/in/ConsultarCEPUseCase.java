package com.example.avaliacao.application.port.in;

public interface ConsultarCEPUseCase extends UseCase {
    @Override
    boolean execute(Command command) throws Exception;
}
