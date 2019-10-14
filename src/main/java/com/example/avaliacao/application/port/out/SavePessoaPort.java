package com.example.avaliacao.application.port.out;
import com.example.avaliacao.application.domain.Pessoa;

public interface SavePessoaPort {
    Pessoa savePessoa(Pessoa pessoa);
}
