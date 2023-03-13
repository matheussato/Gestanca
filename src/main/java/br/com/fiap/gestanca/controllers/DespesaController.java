package br.com.fiap.gestanca.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import br.com.fiap.gestanca.models.Despesa;

@RestController
public class DespesaController {
    
    Logger log = LoggerFactory.getLogger(DespesaController.class);

    List<Despesa> despesas = new ArrayList<>();

    @GetMapping("/api/despesas")
    public List<Despesa> index(){        
        return despesas;
        
    }

    @GetMapping("api/despesa/{id}")//{id} - significa que é uma variável de path
    public ResponseEntity<Despesa> show(@PathVariable Long id){
        log.info("buscar empresa com id : " + id);
        var despesaEncontrada = despesas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(despesaEncontrada.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(despesaEncontrada.get());
    }

    @PostMapping("api/despesas")
    public ResponseEntity<Despesa> create(@RequestBody Despesa despesa){
        log.info("cadastrar despesas: " + despesa);
        despesa.setId(despesas.size() + 1l);//1l converte para long
        despesas.add(despesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(despesa);
    }
    
    @DeleteMapping("api/despesa/{id}")
    public ResponseEntity<Despesa> destroy(@PathVariable Long id){
        log.info("apagar despesa" + id);
        
        var despesaEncontrada = despesas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(despesaEncontrada.isEmpty()) 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        despesas.remove(despesaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("api/despesa/{id}")
    public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa despesa){
        log.info("apagar despesa" + id);
        
        var despesaEncontrada = despesas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(despesaEncontrada.isEmpty()) 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        despesas.remove(despesaEncontrada.get());
        despesa.setId(id);
        despesas.add(despesa);

        return ResponseEntity.ok(despesa);
    }


}
