import java.util.List;
import java.util.ArrayList;

public class SecretariaAcademica {

    private List<Aluno> alunos;

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
        AlunoFileHandler.salvarAlunos(alunos); // Salva no arquivo após cada cadastro
    }

    public void editarAlunos(String matricula, String novoNome, String novoCurso) {

    }

    public void listarAlunos() {
        System.out.println("=== ALUNOS CADASTRADOS ===");
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + " | Matrícula: " + aluno.getMatricula());
        }
    }

}
