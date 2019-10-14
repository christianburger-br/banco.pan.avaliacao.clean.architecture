package com.example.avaliacao.application.port.in;

public interface ConsultarMunicipiosUseCase extends UseCase {
    @Override
    boolean execute(Command command) throws Exception;
}
