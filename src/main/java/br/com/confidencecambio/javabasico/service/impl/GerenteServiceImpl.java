package br.com.confidencecambio.javabasico.service.impl;

import br.com.confidencecambio.javabasico.model.Gerente;
import br.com.confidencecambio.javabasico.repository.GerenteRepository;
import br.com.confidencecambio.javabasico.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.confidencecambio.javabasico.utils.StringUtil.*;


@Service
public class GerenteServiceImpl implements GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    @Override
    public void salvar(Gerente gerente) throws Exception {
        gerente.setNome(removerEspacos(gerente.getNome()));
        if (isEmpty(gerente.getNome())){
            throw new Exception("Nome do Gerente não pode ser nulo ou vazio");
        }
        gerenteRepository.save(gerente);

    }

    @Override
    public String retornaPrimeiroNomeGerente(String gerenteNomeCompleto) {
        return getPrimeiroNome(gerenteNomeCompleto);
    }

    @Override
    public String retornaUltimoNomeGerente(String gerenteNomeCompleto) {
        return getUltimoNome(gerenteNomeCompleto);
    }

    @Override
    public String retornaNomeMaiusculo(String gerenteNomeCompleto) {
        return converterMaiusculas(gerenteNomeCompleto);
    }

    @Override
    public String retornaNomeAbreviado(String gerenteNomeCompleto) {
        return abreviaNome(gerenteNomeCompleto);
    }
}
