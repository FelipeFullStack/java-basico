package br.com.confidencecambio.javabasico.service.impl;

import br.com.confidencecambio.javabasico.model.Robo;
import br.com.confidencecambio.javabasico.repository.RoboRepository;
import br.com.confidencecambio.javabasico.service.RoboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.confidencecambio.javabasico.utils.StringUtil.*;
import static org.springframework.util.StringUtils.isEmpty;

@Service
public class RoboServiceImpl implements RoboService {

    @Autowired
    private RoboRepository roboRepository;

    @Override
    public void salvar(Robo robo) throws Exception {
        robo.setNome(removerEspacos(robo.getNome()));
        if (isEmpty(robo.getNome())){
            throw new Exception("Nome do Robo não pode ser nulo ou vazio");
        }
        roboRepository.save(robo);
    }

    @Override
    public String retornaPrimeiroNomeRobo(String nomeRoboCompleto) {
        return getPrimeiroNome(nomeRoboCompleto);
    }

    @Override
    public String retornaUltimoRobo(String nomeRoboCompleto) {
        return getUltimoNome(nomeRoboCompleto);
    }

    @Override
    public String retornaNomeMaiusculo(String nomeRoboCompleto) {
        return converterMaiusculas(nomeRoboCompleto);
    }

    @Override
    public String retornaNomeAbreviado(String nomeRoboCompleto) {
        return abreviaNome(nomeRoboCompleto);
    }
}
