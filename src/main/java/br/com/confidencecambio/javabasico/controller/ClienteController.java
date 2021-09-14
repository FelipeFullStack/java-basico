package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.model.Cliente;
import br.com.confidencecambio.javabasico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Cliente cliente) throws Exception {
        clienteService.salvar(cliente);
        return new ResponseEntity(String.format("Cliente salvo com sucesso! ID = %d", cliente.getId()), HttpStatus.OK);
    }

    @GetMapping(value = "/primeiro-nome/{nome}")
    public ResponseEntity<String> getPrimeiroNome(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome completo: %s | Primeiro nome: %s", nome, clienteService.retornaPrimeiroNome(nome)), HttpStatus.OK);

    }

    @GetMapping(value = "/ultimo-nome/{nome}")
    public ResponseEntity<String> getUltimoNome(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome completo: %s | Ultimo nome: %s", nome, clienteService.retornaUltimoNome(nome)), HttpStatus.OK);

    }

    @GetMapping(value = "/nome-maiusculo/{nome}")
    public ResponseEntity<String> getNomeMaiusculo(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome completo: %s | Nome Maiusculo: %s", nome, clienteService.retornaNomeMaiusculo(nome)), HttpStatus.OK);

    }


    @GetMapping(value = "/nome-abreviado/{nome}")
    public ResponseEntity<String> getNomeAbreviado(@PathVariable("nome") String nome){
        return new ResponseEntity(String.format("Nome completo: %s | Nome Abreviado: %s", nome, clienteService.retornaNomeAbreviado(nome)), HttpStatus.OK);

    }
}
