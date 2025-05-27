import java.util.List;
import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private List<String> disciplinasMatriculadas;

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.disciplinasMatriculadas = new ArrayList<>();
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

    // Método para matricular em disciplina
    public boolean matricularEmDisciplina(String codigoDisciplina, List<Disciplina> disciplinas) {
        boolean disciplinaExiste = disciplinas.stream()
                .anyMatch(d -> d.getCodigo().equals(codigoDisciplina));

        if (disciplinaExiste && !disciplinasMatriculadas.contains(codigoDisciplina)) {
            disciplinasMatriculadas.add(codigoDisciplina);
            return true;
        }
        return false;
    }

    // Método obter detalhes das disciplinas
    public String getDetalhesDisciplinas(List<Disciplina> disciplinas) {
        StringBuilder sb = new StringBuilder();
        for (String codigo : disciplinasMatriculadas) {
            disciplinas.stream()
                    .filter(d -> d.getCodigo().equals(codigo))
                    .findFirst()
                    .ifPresent(d -> sb.append("\n- ").append(d.getNome())
                            .append(" (").append(d.getCodigo()).append(")")
                            .append(" - ").append(d.getCargaHoraria()).append("h"));
        }
        return sb.toString();
    }

    public static class AlunoEspecial extends Aluno {
        private final int LIMITE_DISCIPLINAS = 2;

        public AlunoEspecial(String nome, String matricula, String curso) {
            super(nome, matricula, curso);
        }

        @Override
        public boolean matricularEmDisciplina(String codigoDisciplina, List<Disciplina> disciplinas) {
            if (getDisciplinasMatriculadas().size() >= LIMITE_DISCIPLINAS) {
                System.out.println("Aluno especial não pode ter mais de " + LIMITE_DISCIPLINAS + " disciplinas!");
                return false;
            }

            return super.matricularEmDisciplina(codigoDisciplina, disciplinas);
        }

        @Override
        public String getDetalhesDisciplinas(List<Disciplina> disciplinas) {
            StringBuilder sb = new StringBuilder(super.getDetalhesDisciplinas(disciplinas));
            sb.append("\n[ALUNO ESPECIAL - LIMITE: ").append(LIMITE_DISCIPLINAS).append(" DISCIPLINAS]");
            return sb.toString();
        }
    }
}