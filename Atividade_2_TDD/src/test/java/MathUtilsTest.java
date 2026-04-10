import static org.junit.jupiter.api.Assertions.*; // Importa os "juízes"

import br.com.teste.modelo.MathUtils;
import org.junit.jupiter.api.Test; // Importa o "selo" de teste
import org.junit.jupiter.api.BeforeEach;

public class MathUtilsTest {

    private MathUtils math;

    @BeforeEach
    public void setup(){
        math = new MathUtils();
    }

    //Soma padrão
    @Test
    public void somaPadrão(){
        assertEquals(2, math.sum(1,1), "É esperado o valor como resultado 2" ); //Soma de número padrões
    }

    //Soma de número negativos
    @Test
    public void somaDeNumeroNegativos(){
        assertEquals(-7, math.sum(-3, -4), "É esperado o valor como resultado -7"); //soma de número negativo
    }

    //Soma de número negativo mais positivo
    @Test
    public void somaDeNumeroPositivoNegativo(){
        assertEquals(7 ,math.sum(9,-2), "// -2 + 9 = 7, é esperado esse resultado");
    }

    //Para ver se numero é par com sucesso
    @Test
    public void numeroPar(){
        boolean result = math.isEven(4);

        assertTrue(result, "Numero par"); //4 é par
    }

    //Numero impar
    @Test
    public void numeroImpar(){
        boolean result = math.isEven(7);

        assertFalse(result, "Numero impar"); //7 é impar
    }

    //Fatorial de 0
    @Test
    public void fatorialZero(){
        assertEquals(1, math.factorial(0), "É esperado o resultado 1");
    }

    //Fatorial limite 12
    @Test
    public void fatorialDoze(){

        assertEquals(479001600, math.factorial(12), "É esperado o resutaldo grande ai");
    }

    //Fatorial passando do limite
    @Test
    public void deveRetornarMenosUmQuandoEntradaForMaiorQueDoze(){
        assertEquals(-1, math.factorial(13), "É esperado que retorne -1");
    }

}
