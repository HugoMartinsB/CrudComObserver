package com.finan.orcamento.model;

import com.finan.orcamento.repositories.Observer;

import java.math.BigDecimal;

import static java.lang.System.exit;

public class Gerente implements Observer {

    private String nome;
    private Estoque estoqueObservado;

    public Gerente(String nome) {
        this.nome = nome;
    }

    public void registrarEstoque(Estoque estoque) {
        this.estoqueObservado = estoque;
        estoque.attach(this);
    }

    public void desregistrarEstoque() {
        if (estoqueObservado != null) {
            estoqueObservado.detach(this);
            estoqueObservado = null;
        }
    }

    @Override
    public void update(Estoque estoque) {
        BigDecimal valorAtual = estoque.getValor();
        BigDecimal limite = new BigDecimal("1000.0");

        if (valorAtual.compareTo(limite) > 0) {
            String mensagem = "Gerente " + nome + ": Valor do produto "
                    + estoque.getProduto() + " excedeu R$1.000,00";
            System.out.println(mensagem);
            exit(1);
        }
    }


}
