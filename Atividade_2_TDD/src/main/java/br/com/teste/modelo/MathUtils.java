package br.com.teste.modelo;

public class MathUtils {
    public int sum(int a, int b) {
        return a + b;
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Retorna -1 para entradas inválidas ou que possam causar overflow
    public int factorial(int n) {
        if (n < 0 || n > 12) return -1; // 13! estoura int
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}

