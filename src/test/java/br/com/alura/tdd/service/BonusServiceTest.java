package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    void deveRetornarZeroParaSalariosComBonusAcima1000() {
        BonusService bonusService = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("25000"))));

//        try { TODO se precisar testar a mensagem de erro/validacao
//            bonusService.calcularBonus(new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("25000")));
//            fail("Não deu exception!");
//        } catch (Exception e) {
//            assertEquals("Funcionário com salário maior do que R$ 1000,00 não pode receber bonus", e.getMessage());
//        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerIgualA1000() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
