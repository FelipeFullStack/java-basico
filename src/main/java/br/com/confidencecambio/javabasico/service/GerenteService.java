package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.model.Cliente;
import br.com.confidencecambio.javabasico.model.Gerente;

public interface GerenteService {

    void salvar(Gerente gerente) throws Exception;

    String retornaPrimeiroNomeGerente(String gerenteNomeCompleto);

    String retornaUltimoNomeGerente(String gerenteNomeCompleto);

    String retornaNomeMaiusculo(String gerenteNomeCompleto);

    String retornaNomeAbreviado(String gerenteNomeCompleto);
}
