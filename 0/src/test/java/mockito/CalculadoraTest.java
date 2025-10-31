package test.java.mockito;

import main.java.mockito.Calculadora;
import main.java.mockito.ServicoMatematico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculadoraTest {
    @Test
    public void testSomarComMock() {
        ServicoMatematico servicoMock = mock(ServicoMatematico.class);
        when(servicoMock.somar(2, 3)).thenReturn(5);

        Calculadora calculadora = new Calculadora(servicoMock);
        int resultado = calculadora.somar(2, 3);

        assertEquals(5, resultado);
    }
}
