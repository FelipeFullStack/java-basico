package br.com.confidencecambio.javabasico.controller;


import br.com.confidencecambio.javabasico.model.Robo;
import br.com.confidencecambio.javabasico.service.RoboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/robo")
public class RoboController {
    @Autowired
    private RoboService roboService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Robo robo) throws Exception {
        roboService.salvar(robo);
        return new ResponseEntity(String.format("Robo salvo com sucesso! ID = %d", robo.getId()), HttpStatus.OK);
    }

    @GetMapping(value = "/primeiro-nome/{nome}")
    public ResponseEntity<String> getPrimeiroNomRobo(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome completo: %s | Primeiro nome: %s", nome, roboService.retornaPrimeiroNomeRobo(nome)), HttpStatus.OK);

    }

    @GetMapping(value = "/ultimo-nome/{nome}")
    public ResponseEntity<String> getUltimoNome(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome completo: %s | Ultimo nome: %s", nome, roboService.retornaUltimoRobo(nome)), HttpStatus.OK);

    }

    @GetMapping(value = "/nome-maiusculo/{nome}")
    public ResponseEntity<String> getNomeMaiusculo(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome completo: %s | Nome Maiusculo: %s", nome, roboService.retornaNomeMaiusculo(nome)), HttpStatus.OK);

    }


    @GetMapping(value = "/nome-abreviado/{nome}")
    public ResponseEntity<String> getNomeAbreviado(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome completo: %s | Nome Abreviado: %s", nome, roboService.retornaNomeAbreviado(nome)), HttpStatus.OK);

    }
}
