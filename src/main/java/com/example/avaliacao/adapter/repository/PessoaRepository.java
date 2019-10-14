package com.example.avaliacao.adapter.repository;

import com.example.avaliacao.application.domain.Pessoa;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    @Override
    Iterable<Pessoa> findAllById(Iterable<Long> longs);

    @Override
    Iterable<Pessoa> findAll();
}
