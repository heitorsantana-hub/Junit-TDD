import static org.junit.jupiter.api.Assertions.*; // Importa os "juízes"

import br.com.teste.modelo.GradeUtils;
import org.junit.jupiter.api.Test; // Importa o "selo" de teste
import org.junit.jupiter.api.BeforeEach;

public class GradeUtilsTest {

    //Variavel inicializada
    private GradeUtils grade;

    //Criando objeto para todos os testes
    @BeforeEach
    public void setup(){
        grade = new GradeUtils();
    }

    //Media com Sucesso
    @Test
    public void mediaRealizadaComSucesso(){
        double resultado = grade.media(5,5,5);

        assertEquals(5, resultado, "Média realizada com Sucesso");
    }

    //Testando regra de negocio com entradas fora de 0,10
    @Test
    public void entradaComNumerosInvalidos(){
        double resultado = grade.media(-2, 11);

        assertEquals(-1, resultado, "É esperado que retorne -1");
    }

    //Média com entrada de números nulos
    @Test
    public void mediaComEntradaDeNumerosNulos(){
        double resultado = grade.media(null);

        assertEquals(0.0, resultado, "É esperado que retorne 0");
    }

    //Testando funcão conceito com sucesso
    @Test
    public void testandoFuncaoConceitoComExito(){
        double resultado = grade.media(2,5,9);
        String conceito = grade.conceito(resultado);

        assertEquals("C", conceito, "É esperado que ele retorne C");

    }

    //Testando função conceito invalida
    @Test
    public void testandoFuncaoConceitoInvalida(){
        double resultado = grade.media(-2,5,13);
        String conceito = grade.conceito(resultado);

        assertEquals("Inválida", conceito, "É esperado que ele retorne Invalida");
    }

    //Testando função situação
    @Test
    public void testandoFuncaoSituacaoComExito(){
        double resultado = grade.media(2,5,9);
        String situacao = grade.situacao(resultado);

        assertEquals("Reprovado", situacao, "É esperado que retorne Reprovado");

    }

    //Testando função situação com Erro
    @Test
    public void testandoFuncaoSituacaoComErro(){
        double resultado = grade.media(-2,-4,-9);
        String situacao = grade.situacao(resultado);

        assertEquals("Inválida", situacao, "É esperado que retorne Inválida");
    }

}
