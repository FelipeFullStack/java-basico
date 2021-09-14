package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.model.Cliente;

public interface ClienteService {

    void salvar(Cliente cliente) throws Exception;

    String retornaPrimeiroNome(String nomeCompleto);

    String retornaUltimoNome(String nomeCompleto);

    String retornaNomeMaiusculo(String nomeCompleto);

    String retornaNomeAbreviado(String nomeCompleto);


}
