package com.finan.orcamento.patternBuilder;

import com.finan.orcamento.model.Casa;
public interface InterfaceBuilderCasa {
    void buildQuartos();
    void buildBanheiros();
    void buildChurrasqueira();

    Casa getCasa();

}
