import java.util.List;
import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private List<String> preRequisitos;

    public Disciplina(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.preRequisitos = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public int getCargaHoraria() { return cargaHoraria; }
    public List<String> getPreRequisitos() { return preRequisitos; }

    public void adicionarPreRequisito(String codigoDisciplina) {
        if (!preRequisitos.contains(codigoDisciplina)) {
            preRequisitos.add(codigoDisciplina);
        }
    }

    @Override
    public String toString() {
        return nome + ";" + codigo + ";" + cargaHoraria + ";" + String.join(",", preRequisitos);
    }
}