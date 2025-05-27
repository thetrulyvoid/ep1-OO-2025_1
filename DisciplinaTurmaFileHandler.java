import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class DisciplinaTurmaFileHandler {
    private static final String ARQUIVO_DISCIPLINAS = "disciplinas.txt";

    public static List<Disciplina> carregarDisciplinas() {
        List<Disciplina> disciplinas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_DISCIPLINAS))) {
            // Leitura do arquivo
        } catch (IOException e) {
            System.out.println("Arquivo de disciplinas não encontrado. Será criado um novo.");
        }
        return disciplinas;
    }

    public static void salvarDisciplinas(List<Disciplina> disciplinas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_DISCIPLINAS))) {
            // Gravação no arquivo
        } catch (IOException e) {
            System.err.println("Erro ao salvar disciplinas: " + e.getMessage());
        }
    }
}