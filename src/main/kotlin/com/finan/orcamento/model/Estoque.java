package com.finan.orcamento.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.finan.orcamento.repositories.Observer;

public class Estoque {
    private BigDecimal valorAnterior;
    private String produto;
    private BigDecimal valor;
    private BigDecimal desconto;
    private List<Observer> observers = new ArrayList<>();

    public Estoque() {}

    public Estoque(String produto, BigDecimal valor, BigDecimal desconto) {
        this.valorAnterior = this.valor;
        this.produto = produto;
        this.valor = valor;
        this.desconto = desconto;
    }

    public Estoque(String produto, BigDecimal valor) {
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal newValor) {
        this.valorAnterior = this.valor;
        this.valor = newValor;

        BigDecimal limite = new BigDecimal("1000.0");
        if (valor.compareTo(limite) > 0 || valor.compareTo(valorAnterior.multiply(new BigDecimal(0.9))) < 0) {
            notifyObservers();
        }
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
