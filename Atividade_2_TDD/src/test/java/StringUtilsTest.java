import static org.junit.jupiter.api.Assertions.*; // Importa os "juízes"

import br.com.teste.modelo.StringUtils;
import org.junit.jupiter.api.Test; // Importa o "selo" de teste
import org.junit.jupiter.api.BeforeEach;

public class StringUtilsTest {

    private StringUtils string;

    //Sera executado antes de todo os testes
    @BeforeEach
    public void setup(){
        string = new StringUtils();
    }

    //Funcioamento da função reverse
    @Test
    public void fazendoAPalavraRetonarAocontrario(){
        String palavra = string.reverse("banana");

        assertEquals("ananab", palavra, "Retornando a palavra ao contrario");
    }

    //Funcionamento da Regra de Negocio
    @Test
    public void entradaComValorFazio(){
        String resultado = string.reverse(null);

        assertNull(resultado, "É esperado que retorne nulo" );
    }

    //Contando vogal
    @Test
    public void contantoQuantidadeDeVogal(){
            int quantidade = string.countVowels("Carro");

            assertEquals(2, quantidade, "É esperado o retorno = 2");
    }

    //Contando vogal com número vazio
    @Test
    public void contandoVogalComEntradaVazia(){
        int quantidade = string.countVowels(null);

        assertEquals(0, quantidade, "É esperado que retorne 0");
    }

    //Contando Vogal com letra maiscula
    @Test
    public void contandoVogalComLetraMaiscula(){
        int quantidade = string.countVowels("Abacaxi");

        assertEquals(4, quantidade, "É esperado que retorne 4");
    }

    //Testando Palíndromo
    @Test
    public void testandoFuncaoComExito(){
        boolean result = string.isPalindrome("ana");

        assertTrue(result, "Conseguiu retornar o Palíndromo");
    }

    //Testando função Palíndromo com entrada vazia
    @Test
    public void testandpFuncaoComEntradaVazia(){
        boolean result = string.isPalindrome(null);

        assertFalse(result, "Seguiu a regra de negocio");
    }
}
