import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoFileHandler {
    private static final String ARQUIVO_ALUNOS = "alunos.txt";

    // Carregar os alunos do txt
    public static List<Aluno> carregarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ALUNOS))) {
            String linha;
            boolean primeiraLinha = true;
            
            while ((linha = reader.readLine()) != null) {
                if (primeiraLinha) { // Pula a primeira linha de cabeçalho q tá no txt
                    primeiraLinha = false;
                    continue;
                }
                
                String[] dados = linha.split(";");
                if (dados.length >= 3) {
                    Aluno aluno = new Aluno(dados[0], dados[1], dados[2]);
                    
                    if (dados.length > 3 && !dados[3].isEmpty()) {
                        for (String disciplina : dados[3].split(",")) {
                            aluno.getDisciplinasMatriculadas().add(disciplina);
                        }
                    }
                    
                    alunos.add(aluno);
                }
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado. Criando novo...");
        }
        
        return alunos;
    }

    // Salvar os alunos que já tem
    public static void salvarAlunos(List<Aluno> alunos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ALUNOS))) {
            writer.write("NOME;MATRICULA;CURSO;DISCIPLINAS");
            writer.newLine();
            
            for (Aluno aluno : alunos) {
                writer.write(aluno.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}