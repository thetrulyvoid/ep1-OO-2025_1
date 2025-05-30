import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class SecretariaAcademica {
    private List<Aluno> alunos;
    private List<Disciplina> disciplinas;
    private Scanner scanner;

    public SecretariaAcademica() {
        this.alunos = AlunoFileHandler.carregarAlunos();
        this.disciplinas = disciplinas;
        this.scanner = new Scanner(System.in);
    }

    public SecretariaAcademica(List<Disciplina> disciplinas) {
        this.alunos = AlunoFileHandler.carregarAlunos();
        this.disciplinas = disciplinas;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarModoAluno() {
        int opcao;
        do {
            System.out.println("\n=== MODO ALUNO ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Editar Aluno");
            System.out.println("3. Listar Alunos");
            System.out.println("4. Buscar Aluno por Matrícula");
            System.out.println("5. Remover Aluno");
            System.out.println("6. Matricular Aluno em Disciplina");
            System.out.println("7. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    editarAluno();
                    break;
                case 3:
                    listarAlunos();
                    break;
                case 4:
                    buscarAlunoPorMatricula();
                    break;
                case 5:
                    removerAluno();
                    break;
                case 6:
                    matricularAlunoEmDisciplina();
                    break;
                case 7:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            AlunoFileHandler.salvarAlunos(alunos);
        } while (opcao != 7);
    }

    private void cadastrarAluno() {
        System.out.println("\n--- CADASTRO DE ALUNO ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        if (alunoExiste(matricula)) {
            System.out.println("Erro: Matrícula já cadastrada!");
            return;
        }

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        System.out.print("Tipo (1-Normal / 2-Especial): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno;
        if (tipo == 2) {
            aluno = new Aluno.AlunoEspecial(nome, matricula, curso);
        } else {
            aluno = new Aluno(nome, matricula, curso);
        }

        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void editarAluno() {
        System.out.print("\nDigite a matrícula do aluno a editar: ");
        String matricula = scanner.nextLine();

        Aluno aluno = buscarAluno(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        System.out.println("\nEditando aluno: " + aluno.getNome());
        System.out.print("Novo nome (enter para manter atual): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isEmpty()) {
            aluno.setNome(novoNome);
        }

        System.out.print("Novo curso (enter para manter atual): ");
        String novoCurso = scanner.nextLine();
        if (!novoCurso.isEmpty()) {
            aluno.setCurso(novoCurso);
        }

        System.out.println("Dados atualizados com sucesso!");
    }

    private void listarAlunos() {
        System.out.println("\n--- LISTA DE ALUNOS ---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.printf("%-20s %-15s %-20s %-10s%n",
                "NOME", "MATRÍCULA", "CURSO", "TIPO");
        for (Aluno aluno : alunos) {
            String tipo = (aluno instanceof Aluno.AlunoEspecial) ? "Especial" : "Normal";
            System.out.printf("%-20s %-15s %-20s %-10s%n",
                    aluno.getNome(),
                    aluno.getMatricula(),
                    aluno.getCurso(),
                    tipo);
        }
    }

    private void buscarAlunoPorMatricula() {
        System.out.print("\nDigite a matrícula: ");
        String matricula = scanner.nextLine();

        Aluno aluno = buscarAluno(matricula);
        if (aluno != null) {
            System.out.println("\n--- DADOS DO ALUNO ---");
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println("Curso: " + aluno.getCurso());
            System.out.println("Tipo: " + ((aluno instanceof Aluno.AlunoEspecial) ? "Especial" : "Normal"));
            System.out.println("Disciplinas Matriculadas: " + aluno.getDetalhesDisciplinas(disciplinas));
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private void removerAluno() {
        System.out.print("\nDigite a matrícula do aluno a remover: ");
        String matricula = scanner.nextLine();

        if (alunos.removeIf(a -> a.getMatricula().equals(matricula))) {
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private void matricularAlunoEmDisciplina() {
        System.out.print("\nDigite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        Aluno aluno = buscarAluno(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        System.out.println("\nDisciplinas disponíveis:");
        disciplinas.forEach(d -> System.out.println(
                "- " + d.getCodigo() + ": " + d.getNome() + " (" + d.getCargaHoraria() + "h)"));

        System.out.print("\nCódigo da disciplina: ");
        String codigoDisciplina = scanner.nextLine();

        if (aluno.matricularEmDisciplina(codigoDisciplina, disciplinas)) {
            System.out.println("Matrícula realizada com sucesso!");
        } else {
            System.out
                    .println("Falha na matrícula. Verifique se a disciplina existe ou se o aluno já está matriculado.");
        }
    }

    private boolean alunoExiste(String matricula) {
        return alunos.stream().anyMatch(a -> a.getMatricula().equals(matricula));
    }

    private Aluno buscarAluno(String matricula) {
        return alunos.stream()
                .filter(a -> a.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
    }
}