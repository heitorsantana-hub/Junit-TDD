import static org.junit.jupiter.api.Assertions.*; // Importa os "juízes"

import br.com.teste.modelo.ContaBancaria;
import org.junit.jupiter.api.Test; // Importa o "selo" de teste


public class ContaBancariaTest {

    //Teste para verificar se estar aumentando o saldo
    @Test
    public void deveAumentarSaldoAoDepositar(){
        ContaBancaria contaBancaria = new ContaBancaria(100.00); //Começando com 100
        contaBancaria.depositar(50);

        assertEquals(150, contaBancaria.getSaldo(), "O Saldo deve estar com 150, pois foi adiconado anteriormente");
    }

    //Teste deposito de valor nulo
    @Test
    public void depositoDeValorNulo(){
        ContaBancaria contaBancaria = new ContaBancaria(7.00); //Começando com 7
        contaBancaria.depositar(0.00);

        assertEquals(7, contaBancaria.getSaldo(), "O saldo deve continuar o mesmo que anteriormente");
    }

    //Teste deposito de valor negativo
    @Test
    public void depositoDeValorNegativo(){
        ContaBancaria contaBancaria = new ContaBancaria(0.00);
        boolean resultado = contaBancaria.depositar(-20);

        assertFalse(resultado, "O deposito não era acontecer pois não pode depositar valor negativo");
        assertEquals(0.00, contaBancaria.getSaldo(), "O saldo deve continuar o mesmo que antes");
    }

    //Sacar valor menor que o saldo
    @Test
    public void saqueDeValorMenorQueSaldo(){
        ContaBancaria contaBancaria = new ContaBancaria(90.00);
        boolean result = contaBancaria.sacar(40);

        assertTrue(result, "Operação deu tudo certo"); //Método deu certo
        assertEquals(50, contaBancaria.getSaldo(), "Deve diminiur valor do saldo da conta");
    }

    //Saque valor exato da conta
    @Test
    public void saqueValorDoSaldo(){
        ContaBancaria contaBancaria = new ContaBancaria(25.00);
        boolean result = contaBancaria.sacar(25.00);

        assertTrue(result, "Conseguiu sacar com sucesso"); //Saque tirou todo valor da conta
        assertEquals(0.00, contaBancaria.getSaldo(), "Foi removido todo valor do saldo");
    }

    //Saque maior valor que tem no saldo
    @Test
    public void saqueValorMaiorSaldo(){
        ContaBancaria contaBancaria = new ContaBancaria(70.00);
        boolean result = contaBancaria.sacar(90.00);

        assertFalse(result, "Não deu certo, regra de negocio funcionando"); //Se der falso esta correto, informa que não é possivel sacar mais que o saldo
        assertEquals(70.00, contaBancaria.getSaldo(), "Vai retornar o saldo anterior");
    }

    //Transferência bem-sucedida
    @Test
    public void transferenciaSucedida(){
        ContaBancaria contaOrigem = new ContaBancaria(29.00); //Conta que vai mandar o dinheiro
        ContaBancaria contaDestino = new ContaBancaria(30.00); //Conta que vai receber o dinheiro
        boolean result = contaOrigem.transferir(contaDestino, 20.00); //Conta Origem vai mandar 20 para Conta Destino

        assertTrue(result, "Foi enviado 20 reais para conta Destino"); //Enviado com sucesso
        assertEquals(9.00, contaOrigem.getSaldo(), "Deve remover o valor do saldo"); //Saque do saldo com sucesso
        assertEquals(50.00, contaDestino.getSaldo(), "A conta destino tem que estar com 50" ); //Deposito certo
    }

    //Transferência saldo insuficiente
    @Test
    public void transferenciaSaldoErro(){
        ContaBancaria contaOrigem = new ContaBancaria(60.00); //Conta que vai mandar o dinheiro
        ContaBancaria contaDestino = new ContaBancaria(30.00); //Conta que vai receber o dinheiro
        boolean result = contaOrigem.transferir(contaDestino, 80.00); //Conta Origem iria mandar 80 para Conta Destino

        assertFalse(result, "Não enviado nada, esta funcionando regra de negocio"); //Não foi possivel enviar
        assertEquals(60.00, contaOrigem.getSaldo(), "Deve continuar o valor do saldo"); //Saque do saldo erro
        assertEquals(30.00, contaDestino.getSaldo(), "A conta destino tem que estar com mesmo valor" ); //Deposito erro
    }
}
