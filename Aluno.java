import java.util.List;
import java.util.ArrayList;

public class Aluno {

    private String nome;
    private String matricula;
    private String curso;
    private List<String> disciplinasMatriculadas;

    // Construtor
    public Aluno(String nome, String matricula, String curso) {

        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.disciplinasMatriculadas = new ArrayList<>();

    }

    @Override
    public String toString() {
        return nome + ";" + matricula + ";" + curso + ";" + String.join(",", disciplinasMatriculadas);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public List<String> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setDisciplinasMatriculadas(List<String> disciplinasMatriculadas) {
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }

    public class AlunoEspecial extends Aluno {

        private final int LIMITE_DISCIPLINAS = 2;

        @Override
        public void matricularEmDisciplina(String disciplina) {

            if (disciplinasMatriculadas.size() >= LIMITE_DISCIPLINAS) {

                System.out.println("Aluno especial não pode ter mais de 2 disciplinas!");

            }

            else {
                super.matricularEmDisciplina(disciplina);
            }

        }

    }

}
