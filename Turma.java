import java.util.List;
import java.util.ArrayList;

public class Turma {
    private String codigoDisciplina;
    private String professor;
    private String semestre;
    private String formaAvaliacao;
    private boolean presencial;
    private String sala;
    private String horario;
    private int capacidade;
    private List<String> alunosMatriculados;

    public Turma(String codigoDisciplina, String professor, String semestre, 
                 String formaAvaliacao, boolean presencial, String horario, int capacidade) {
        this.codigoDisciplina = codigoDisciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.formaAvaliacao = formaAvaliacao;
        this.presencial = presencial;
        this.sala = presencial ? "" : null;
        this.horario = horario;
        this.capacidade = capacidade;
        this.alunosMatriculados = new ArrayList<>();
    }

    // Getters adicionados
    public String getCodigoDisciplina() { return codigoDisciplina; }
    public String getProfessor() { return professor; }
    public String getSemestre() { return semestre; }
    public String getFormaAvaliacao() { return formaAvaliacao; }
    public boolean isPresencial() { return presencial; }
    public String getSala() { return sala; }
    public String getHorario() { return horario; }
    public int getCapacidade() { return capacidade; }
    public List<String> getAlunosMatriculados() { return alunosMatriculados; }

    public void setSala(String sala) {
        if (presencial) {
            this.sala = sala;
        }
    }

    public boolean matricularAluno(String matricula) {
        if (alunosMatriculados.size() < capacidade && !alunosMatriculados.contains(matricula)) {
            alunosMatriculados.add(matricula);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return codigoDisciplina + ";" + professor + ";" + semestre + ";" + 
               formaAvaliacao + ";" + presencial + ";" + sala + ";" + 
               horario + ";" + capacidade + ";" + String.join(",", alunosMatriculados);
    }
}