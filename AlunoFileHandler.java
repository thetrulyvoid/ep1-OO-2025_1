import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AlunoFileHandler {
    private static final String ARQUIVO_ALUNOS = "alunos.txt";

    public static void salvarAlunos(List<Aluno> alunos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ALUNOS))) {
            writer.write("NOME;MATRICULA;CURSO;DISCIPLINAS"); // Cabeçalho
            writer.newLine();
            
            for (Aluno aluno : alunos) {
                writer.write(aluno.toString());
                writer.newLine();
            }
            
            System.out.println("Dados salvos em " + ARQUIVO_ALUNOS);
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}