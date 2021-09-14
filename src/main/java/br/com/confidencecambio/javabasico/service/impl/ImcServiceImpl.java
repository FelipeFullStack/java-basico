package br.com.confidencecambio.javabasico.service.impl;

import br.com.confidencecambio.javabasico.service.ImcService;
import org.springframework.stereotype.Service;

@Service
public class ImcServiceImpl implements ImcService {

    @Override
    public double calculaImc(Double peso, Double altura) {
        return peso/(Math.pow(altura, 2));
    }
}
