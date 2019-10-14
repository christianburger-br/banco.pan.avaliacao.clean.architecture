package com.example.avaliacao.adapter.repository;

import com.example.avaliacao.application.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Override
    Optional<Account> findById(Long aLong);

    @Override
    Iterable<Account> findAll();
}
