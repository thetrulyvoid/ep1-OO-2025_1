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

        int selecaoDeModo = 0;
        Scanner ler = new Scanner(System.in);

        System.out.println("+-----------------------------------+");
        System.out.println("|   ███████╗███████╗ ██████╗ ██╗   ██╗");
        System.out.println("|   ██╔════╝██╔════╝██╔═══██╗██║   ██║");
        System.out.println("|   ███████╗█████╗  ██║   ██║██║   ██║");
        System.out.println("|   ╚════██║██╔══╝  ██║   ██║╚██╗ ██╔╝");
        System.out.println("|   ███████║███████╗╚██████╔╝ ╚████╔╝ ");
        System.out.println("|   ╚══════╝╚══════╝ ╚═════╝   ╚═══╝  ");
        System.out.println("+-----------------------------------+");
        System.out.println("|        SISTEMA ACADÊMICO FCTE      |");
        System.out.println("+-----------------------------------+");
        System.out.println("| 1. Modo Aluno                     |");
        System.out.println("| 2. Modo Disciplina/Turma          |");
        System.out.println("| 3. Modo Avaliação/Frequência      |");
        System.out.println("| 4. Sair                           |");
        System.out.println("+-----------------------------------+");
        System.out.print("Escolha uma opção: ");

        while (selecaoDeModo == 0 || selecaoDeModo > 4) {

            selecaoDeModo = ler.nextInt();

            if (selecaoDeModo == 1) {

                limparTela();
                System.out.println("Modo Aluno Ativado");

            }

            else if (selecaoDeModo == 2) {

                limparTela();
                System.out.println("Modo Disciplina/Turma Ativado");

            }

            else if (selecaoDeModo == 3) {

                limparTela();
                System.out.println("Modo Avaliação/Frequência Ativado");

            }

            else if (selecaoDeModo == 4) {

                limparTela();
                System.out.println("Você escolheu sair!");

            }

            else {

                System.out.println("Esse número não é válido, tente de novo!");
                System.out.print("Escolha uma opção: ");

            }

        }
    }

}