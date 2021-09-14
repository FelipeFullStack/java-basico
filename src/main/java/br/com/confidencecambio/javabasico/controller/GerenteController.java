package br.com.confidencecambio.javabasico.controller;


import br.com.confidencecambio.javabasico.model.Cliente;
import br.com.confidencecambio.javabasico.model.Gerente;
import br.com.confidencecambio.javabasico.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/gerente")
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Gerente gerente) throws Exception {
        gerenteService.salvar(gerente);
        return new ResponseEntity(String.format("Nome do Gerente salvo com sucesso! ID = %d", gerente.getId()), HttpStatus.OK);
    }

    @GetMapping(value = "/primeiro-nome/{nome}")
    public ResponseEntity<String> getPrimeiroNomeGerente(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome do Gerente completo: %s | Primeiro nome: %s", nome, gerenteService.retornaPrimeiroNomeGerente(nome)), HttpStatus.OK);
    }

    @GetMapping(value = "/ultimo-nome/{nome}")
    public ResponseEntity<String> getGerenteUltimoNome(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome do Gerente completo: %s | Ultimo nome: %s", nome, gerenteService.retornaUltimoNomeGerente(nome)), HttpStatus.OK);

    }

    @GetMapping(value = "/nome-maiusculo/{nome}")
    public ResponseEntity<String> getNomeGerenteMaiusculo(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome do Gerente completo: %s | Nome Maiusculo: %s", nome, gerenteService.retornaNomeMaiusculo(nome)), HttpStatus.OK);

    }
    @GetMapping(value = "/nome-abreviado/{nome}")
    public ResponseEntity<String> getNomeAbreviado(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome completo: %s | Nome Abreviado: %s", nome, gerenteService.retornaNomeAbreviado(nome)), HttpStatus.OK);

    }
}
