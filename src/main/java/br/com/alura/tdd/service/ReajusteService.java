package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        final BigDecimal percentualReajuste = desempenho.percentualReajuste();
        final BigDecimal reajuste = funcionario.getSalario().multiply(percentualReajuste);
        funcionario.reajustarSalario(reajuste);
    }
}
