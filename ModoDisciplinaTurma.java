import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ModoDisciplinaTurma {
    private List<Disciplina> disciplinas;
    private List<Turma> turmas;
    private Scanner scanner;

    public ModoDisciplinaTurma() {
        this.disciplinas = DisciplinaTurmaFileHandler.carregarDisciplinas();
        this.turmas = new ArrayList<>(); // Carregar turmas do arquivo também
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("\n=== MODO DISCIPLINA/TURMA ===");
            System.out.println("1. Cadastrar Disciplina");
            System.out.println("2. Criar Turma");
            System.out.println("3. Listar Disciplinas");
            System.out.println("4. Listar Turmas");
            System.out.println("5. Adicionar Pré-requisito");
            System.out.println("6. Matricular Aluno em Turma");
            System.out.println("7. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    criarTurma();
                    break;
                case 3:
                    listarDisciplinas();
                    break;
                case 4:
                    listarTurmas();
                    break;
                case 5:
                    adicionarPreRequisito();
                    break;
                case 6:
                    matricularAlunoEmTurma();
                    break;
                case 7:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            // Salva as alterações após cada operação
            DisciplinaTurmaFileHandler.salvarDisciplinas(disciplinas);

        } while (opcao != 7);
    }

    private void cadastrarDisciplina() {
        System.out.println("\n--- CADASTRAR DISCIPLINA ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        disciplinas.add(new Disciplina(nome, codigo, cargaHoraria));
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    private void criarTurma() {
        System.out.println("\n--- CRIAR TURMA ---");
        System.out.print("Código da Disciplina: ");
        String codigoDisciplina = scanner.nextLine();

        // Verifica se a disciplina existe
        if (disciplinas.stream().noneMatch(d -> d.getCodigo().equals(codigoDisciplina))) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        System.out.print("Professor: ");
        String professor = scanner.nextLine();

        System.out.print("Semestre (ex: 2023.1): ");
        String semestre = scanner.nextLine();

        System.out.print("Forma de Avaliação: ");
        String formaAvaliacao = scanner.nextLine();

        System.out.print("É presencial? (S/N): ");
        boolean presencial = scanner.nextLine().equalsIgnoreCase("S");

        String sala = "";
        if (presencial) {
            System.out.print("Sala: ");
            sala = scanner.nextLine();
        }

        System.out.print("Horário: ");
        String horario = scanner.nextLine();

        System.out.print("Capacidade Máxima: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();

        Turma turma = new Turma(codigoDisciplina, professor, semestre,
                formaAvaliacao, presencial, horario, capacidade);
        if (presencial) {
            turma.setSala(sala);
        }

        turmas.add(turma);
        System.out.println("Turma criada com sucesso!");
    }

    private void listarDisciplinas() {
        System.out.println("\n--- LISTA DE DISCIPLINAS ---");
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        System.out.printf("%-10s %-30s %-10s %-20s%n",
                "CÓDIGO", "NOME", "HORAS", "PRÉ-REQUISITOS");
        for (Disciplina disciplina : disciplinas) {
            System.out.printf("%-10s %-30s %-10d %-20s%n",
                    disciplina.getCodigo(),
                    disciplina.getNome(),
                    disciplina.getCargaHoraria(),
                    String.join(", ", disciplina.getPreRequisitos()));
        }
    }

    private void listarTurmas() {
        System.out.println("\n--- LISTA DE TURMAS ---");
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        System.out.printf("%-10s %-20s %-10s %-15s %-10s %-10s %-15s%n",
                "DISCIPLINA", "PROFESSOR", "SEMESTRE", "MODALIDADE",
                "SALA", "HORÁRIO", "VAGAS");

        for (Turma turma : turmas) {
            String modalidade = turma.isPresencial() ? "Presencial" : "Remota";
            String sala = turma.isPresencial() ? turma.getSala() : "N/A";

            System.out.printf("%-10s %-20s %-10s %-15s %-10s %-10s %d/%d%n",
                    turma.getCodigoDisciplina(),
                    turma.getProfessor(),
                    turma.getSemestre(),
                    modalidade,
                    sala,
                    turma.getHorario(),
                    turma.getAlunosMatriculados().size(),
                    turma.getCapacidade());
        }
    }

    private void adicionarPreRequisito() {
        System.out.println("\n--- ADICIONAR PRÉ-REQUISITO ---");
        System.out.print("Código da Disciplina: ");
        String codigo = scanner.nextLine();

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);

        if (disciplina == null) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        System.out.print("Código da Disciplina Pré-requisito: ");
        String codigoPreReq = scanner.nextLine();

        if (disciplinas.stream().noneMatch(d -> d.getCodigo().equals(codigoPreReq))) {
            System.out.println("Disciplina pré-requisito não encontrada!");
            return;
        }

        disciplina.adicionarPreRequisito(codigoPreReq);
        System.out.println("Pré-requisito adicionado com sucesso!");
    }

    private void matricularAlunoEmTurma() {
        System.out.println("\n--- MATRICULAR ALUNO EM TURMA ---");
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.getCodigoDisciplina().equals(codigoTurma))
                .findFirst()
                .orElse(null);

        if (turma == null) {
            System.out.println("Turma não encontrada!");
            return;
        }

        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();

        if (turma.matricularAluno(matricula)) {
            System.out.println("Aluno matriculado com sucesso!");
        } else {
            System.out.println("Turma lotada ou aluno já matriculado!");
        }
    }
}