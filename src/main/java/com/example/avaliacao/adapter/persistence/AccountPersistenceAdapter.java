package com.example.avaliacao.adapter.persistence;
import com.example.avaliacao.adapter.repository.AccountRepository;
import com.example.avaliacao.application.domain.Account;
import com.example.avaliacao.application.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Component
@Service
public class AccountPersistenceAdapter implements LoadAccountPort {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account loadAccount(long accountId) {
		return (Account) accountRepository.findById(accountId).orElseThrow(EntityNotFoundException::new);
	}

}
