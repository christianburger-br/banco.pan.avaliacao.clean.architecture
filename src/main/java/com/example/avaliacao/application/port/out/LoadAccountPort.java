package com.example.avaliacao.application.port.out;

import com.example.avaliacao.application.domain.Account;

import java.math.BigInteger;
import java.time.LocalDateTime;

public interface LoadAccountPort {
	Account loadAccount(long accountId);
}
