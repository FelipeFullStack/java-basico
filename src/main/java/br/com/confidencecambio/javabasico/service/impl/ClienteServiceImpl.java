package br.com.confidencecambio.javabasico.service.impl;

import br.com.confidencecambio.javabasico.model.Cliente;
import br.com.confidencecambio.javabasico.repository.ClienteRepository;
import br.com.confidencecambio.javabasico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.confidencecambio.javabasico.utils.StringUtil.*;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void salvar(Cliente cliente) throws Exception {
        cliente.setNome(removerEspacos(cliente.getNome()));
        if (isEmpty(cliente.getNome())){
            throw new Exception("Nome não pode ser nulo ou vazio");
        }
        repository.save(cliente);
    }

    @Override
    public String retornaPrimeiroNome(String nomeCompleto) {
        return getPrimeiroNome(nomeCompleto);
    }

    @Override
    public String retornaUltimoNome(String nomeCompleto) {
        return getUltimoNome(nomeCompleto);
    }

    @Override
    public String retornaNomeMaiusculo(String nomeCompleto) {
        return converterMaiusculas(nomeCompleto);
    }

    @Override
    public String retornaNomeAbreviado(String nomeCompleto) {
        return abreviaNome(nomeCompleto);
    }
}
