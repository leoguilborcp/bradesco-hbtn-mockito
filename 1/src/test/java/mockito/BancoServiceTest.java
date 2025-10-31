
package test.java.mockito;

import main.java.mockito.BancoService;

import main.java.mockito.Conta;
import main.java.mockito.ContaRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BancoServiceTest {
    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório
        ContaRepository contaRepository = mock(ContaRepository.class);

        // Criando conta simulada
        Conta conta = new Conta("123", 100.0);

        // Definindo comportamento do mock
        when(contaRepository.buscarConta("123")).thenReturn(conta);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepository);

        // Testando consulta de saldo
        double saldo = bancoService.consultarSaldo("123");

        // Verificando se o saldo está correto
        assertEquals(100.0, saldo);

        // Verificando se o método buscarConta foi chamado
        verify(contaRepository, times(1)).buscarConta("123");
    }


    @Test
    public void testDepositar() {
        // Criando mock do repositório
        ContaRepository contaRepository = mock(ContaRepository.class);

        // Criando conta simulada
        Conta conta = new Conta("123", 100.0);

        // Definindo comportamento do mock
        when(contaRepository.buscarConta("123")).thenReturn(conta);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepository);

        // Executando depósito
        bancoService.depositar("123", 50.0);

        // Verificando se o saldo foi atualizado
        assertEquals(150.0, conta.getSaldo());

        // Verificando se os métodos foram chamados corretamente
        verify(contaRepository, times(1)).buscarConta("123");
        verify(contaRepository, times(1)).salvar(conta);
    }
}
