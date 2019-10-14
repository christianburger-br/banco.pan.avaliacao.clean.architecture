package com.example.avaliacao.application.service;

import com.example.avaliacao.application.port.in.Command;
import com.example.avaliacao.application.port.in.ConsultarClienteUseCase;
import com.example.avaliacao.application.port.in.ConsultarEstadosUseCase;

public class ConsultarEstadosService implements ConsultarEstadosUseCase {
    @Override
    public boolean execute(Command command) throws Exception {
        return false;
    }
}
