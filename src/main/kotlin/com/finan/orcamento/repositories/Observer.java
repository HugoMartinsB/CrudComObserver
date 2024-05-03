package com.finan.orcamento.repositories;

import com.finan.orcamento.model.Estoque;

public interface Observer {
    public void update(Estoque estoque);
}