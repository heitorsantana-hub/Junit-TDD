package br.com.teste.modelo;

/**
 * Representa uma conta bancária simples com operações de depósito e saque.
 */
public class ContaBancaria {

    private double saldo;

    /**
     * Cria uma conta com um saldo inicial.
     * @param saldoInicial O saldo inicial da conta.
     */
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    /**
     * Retorna o saldo atual da conta.
     * @return O valor do saldo.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Adiciona um valor ao saldo da conta.
     * @param valor O valor a ser depositado. Deve ser positivo.
     * @return true se o depósito foi bem-sucedido, false caso contrário.
     */
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        // Retorna false se o valor for zero ou negativo.
        return false;
    }

    /**
     * Retira um valor do saldo da conta.
     * @param valor O valor a ser sacado. Não pode ser superior ao saldo.
     * @return true se o saque foi bem-sucedido, false caso contrário.
     */
    public boolean sacar(double valor) {
        // Regra de negócio: não permitir saques de valor negativo ou zero.
        if (valor <= 0) {
            return false;
        }
        
        // Regra de negócio: não permitir saque se o saldo for insuficiente.
        if (valor > this.saldo) {
            return false;
        }

        this.saldo -= valor;
        return true;
    }
    
    
    /**
     * DESAFIO!
     * Transfere um valor desta conta para uma conta de destino.
     * @param destino A conta que receberá o valor.
     * @param valor O valor a ser transferido.
     * @return true se a transferência foi bem-sucedida, false caso contrário.
     */
    public boolean transferir(ContaBancaria destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    
}

