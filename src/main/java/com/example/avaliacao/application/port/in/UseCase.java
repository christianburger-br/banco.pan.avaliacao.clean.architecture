package com.example.avaliacao.application.port.in;

public interface UseCase {
    boolean execute(Command command) throws Exception;
}
