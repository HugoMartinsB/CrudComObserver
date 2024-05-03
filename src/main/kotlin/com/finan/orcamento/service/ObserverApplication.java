package com.finan.orcamento.service;

import com.finan.orcamento.model.Estoque;
import com.finan.orcamento.model.Gerente;

import java.math.BigDecimal;

public class ObserverApplication {

    public static void main(String[] args) {
        // Cenário inicial
        BigDecimal valorInicial = new BigDecimal("1900.0");
        BigDecimal desconto = new BigDecimal("10.0");
        Gerente gerente = new Gerente("João");
        Estoque estoque = new Estoque("Camiseta", valorInicial, desconto);


        estoque.attach(gerente);


        estoque.setValor(valorInicial);


        BigDecimal valorComDesconto = valorInicial.subtract(valorInicial.multiply(desconto.divide(new BigDecimal(100))));
        estoque.setValor(valorComDesconto);


        BigDecimal valorExcedente = valorComDesconto.add(new BigDecimal("100.0"));
        estoque.setValor(valorExcedente);


        estoque.detach(gerente);


        estoque.setValor(valorExcedente.add(new BigDecimal("50.0")));


    }
}
