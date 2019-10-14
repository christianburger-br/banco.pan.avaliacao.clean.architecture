package com.example.avaliacao.application.port.out;
import com.example.avaliacao.application.domain.Pessoa;

import java.util.Optional;

public interface LoadPessoaPort {
    Optional<Pessoa> loadPessoa(long cpf);
}
