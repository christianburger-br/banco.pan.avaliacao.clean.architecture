package com.example.avaliacao.application.service;

import com.example.avaliacao.application.domain.Account;
import com.example.avaliacao.application.domain.Endereco;
import com.example.avaliacao.application.port.in.Command;
import com.example.avaliacao.application.port.in.ConsultarClienteUseCase;
import com.example.avaliacao.application.port.in.UseCase;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

public class ConsultarClienteService implements ConsultarClienteUseCase {
    @Override
    public boolean execute(Command command) throws Exception {
        return false;
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    public static class ConsultarClienteCommand implements Command {

        @NotNull
        @Autowired
        @Getter
        private final Account targetAccountId;
        @Getter
        private final Endereco endereco;

        public ConsultarClienteCommand (Account targetAccountId, Endereco endereco ) {
            this.targetAccountId= targetAccountId;
            this.endereco= endereco;
        }
    }
}
