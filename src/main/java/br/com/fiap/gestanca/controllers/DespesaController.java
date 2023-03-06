package br.com.fiap.gestanca.controllers;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.gestanca.models.Despesa;

@RestController
public class DespesaController {

    @GetMapping("/api/despesas")
    public Despesa index(){
        Despesa despesa = new Despesa(new BigDecimal(100),LocalDate.now(),"Cinema");
        
        return despesa;
        

    }
    
}
