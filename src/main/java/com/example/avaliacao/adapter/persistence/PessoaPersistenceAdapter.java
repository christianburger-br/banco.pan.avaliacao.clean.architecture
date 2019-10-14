package com.example.avaliacao.adapter.persistence;
import com.example.avaliacao.adapter.repository.PessoaRepository;
import com.example.avaliacao.application.domain.Pessoa;
import com.example.avaliacao.application.port.out.LoadPessoaPort;
import com.example.avaliacao.application.port.out.SavePessoaPort;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Component
@Service
@Slf4j
public class PessoaPersistenceAdapter implements LoadPessoaPort, SavePessoaPort {

	private
	PessoaRepository pessoaRepository;

	PessoaPersistenceAdapter(PessoaRepository pessoaRepository) {
		this.pessoaRepository= pessoaRepository;
	}

	@Override
	public Optional<Pessoa> loadPessoa(long cpf) {
		return pessoaRepository.findById(cpf);
		//return pessoaRepository.findById(cpf).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public Pessoa savePessoa(Pessoa pessoa) {
		if (pessoaRepository == null  ) {
			log.info(String.format(Locale.getDefault(), "PessoaPersistenceAdapter: pessoaRepository == null: %s", pessoaRepository == null));
			log.info(String.format(Locale.getDefault(), "PessoaPersistenceAdapter: pessoa.getCPF(): %s", pessoa.getCpf()));
			return null;
		}
		return pessoaRepository.save(pessoa);
	}
}
