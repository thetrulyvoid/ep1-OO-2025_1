import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    // Limpa a tela, pq eu não achei jeito melhor e os que eu tentei de limpar o
    // terminal não deram jeito
    public static void limparTela() {
        System.out.println("");

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String args[]) {
        Scanner ler = new Scanner(System.in);

        while (true) { // Loop infinito para o menu principal
            limparTela();
            exibirMenuPrincipal();

            int selecaoDeModo = ler.nextInt();
            ler.nextLine(); // Limpa buffer

            switch (selecaoDeModo) {
                case 1: {
                    limparTela();
                    SecretariaAcademica secretaria = new SecretariaAcademica();
                    secretaria.iniciarModoAluno();
                    break;
                }
                case 2: {
                    limparTela();
                    System.out.println("Modo Disciplina/Turma Ativado");
                    // Implementação futura
                    break;
                }
                case 3: {
                    limparTela();
                    System.out.println("Modo Avaliação/Frequência Ativado");
                    // Implementação futura
                    break;
                }
                case 4: {
                    limparTela();
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                }
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                }
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("+-----------------------------------+");
        System.out.println("|   ███████╗██╗   ██╗██╗██╗         ");
        System.out.println("|   ██╔════╝██║   ██║██║██║         ");
        System.out.println("|   █████╗  ██║   ██║██║██║         ");
        System.out.println("|   ██╔══╝  ██║   ██║██║██║         ");
        System.out.println("|   ██║     ╚██████╔╝██║██║         ");
        System.out.println("|   ╚═╝      ╚═════╝ ╚═╝╚═╝         ");
        System.out.println("+-----------------------------------+");
        System.out.println("|        SISTEMA ACADÊMICO FCTE      |");
        System.out.println("+-----------------------------------+");
        System.out.println("| 1. Modo Aluno                     |");
        System.out.println("| 2. Modo Disciplina/Turma          |");
        System.out.println("| 3. Modo Avaliação/Frequência      |");
        System.out.println("| 4. Sair                           |");
        System.out.println("+-----------------------------------+");
        System.out.print("Escolha uma opção: ");
    }
}
