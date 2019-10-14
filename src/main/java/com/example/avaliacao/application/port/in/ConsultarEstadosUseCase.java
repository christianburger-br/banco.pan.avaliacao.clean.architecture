package com.example.avaliacao.application.port.in;

public interface ConsultarEstadosUseCase extends UseCase {
    @Override
    public boolean execute(Command command) throws Exception;
}
