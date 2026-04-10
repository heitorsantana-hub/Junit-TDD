package br.com.teste.modelo;

public class GradeUtils {
    // Média simples; retorna -1.0 se houver nota fora de [0,10]
    public double media(double... notas) {
        if (notas == null || notas.length == 0) return 0.0;
        double soma = 0.0;
        for (double n : notas) {
            if (n < 0.0 || n > 10.0) return -1.0;
            soma += n;
        }
        return soma / notas.length;
    }

    // Conceitos: D [0-4.9], C [5-6.9], B [7-8.9], A [9-10]; "Inválida" fora de [0,10
    public String conceito(double media) {
        if (media < 0.0 || media > 10.0) return "Inválida";
        if (media >= 9.0) return "A";
        if (media >= 7.0) return "B";
        if (media >= 5.0) return "C";
        return "D";
    }
    
    
    /**
     * DESAFIO!
     * Retorna "Aprovado" para média >= 6.0, "Reprovado" caso contrário.
     * Para médias inválidas (<0 ou >10), retorna "Inválida".
     */
    public String situacao(double media) {
        if (media < 0.0 || media > 10.0) return "Inválida";
        return media >= 6.0 ? "Aprovado" : "Reprovado";
    }

    
}

