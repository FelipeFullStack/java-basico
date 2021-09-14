package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.service.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequestMapping(value = "/imc")
public class imcController {

    @Autowired
    private ImcService imcService;

    @GetMapping(value = "{peso}/{altura}")
    public ResponseEntity<String> calcularIMC(@PathVariable(value = "peso") String peso, @PathVariable(value = "altura") String altura){
        Double pesoD = Double.valueOf(peso.replace(",", "."));
        Double alturaD = Double.valueOf(altura.replace(",", "."));
        double imc = imcService.calculaImc(pesoD, alturaD);
        return new ResponseEntity<String>(format("IMC para os dados informados: %s", imc),HttpStatus.OK);
    }
}
