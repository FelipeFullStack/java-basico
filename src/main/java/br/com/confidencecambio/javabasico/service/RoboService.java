package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.model.Cliente;
import br.com.confidencecambio.javabasico.model.Robo;

public interface RoboService {

    void salvar(Robo robo) throws Exception;

    String retornaPrimeiroNomeRobo(String nomeRoboCompleto);

    String retornaUltimoRobo(String nomeRoboCompleto);

    String retornaNomeMaiusculo(String nomeRoboCompleto);

    String retornaNomeAbreviado(String nomeRoboCompleto);

}
