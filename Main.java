import java.util.Scanner;

public class Main {

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // Se nada funcionar, imprime várias linhas em branco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
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

                clearConsole();
                System.out.println("Modo Aluno Ativado");

            }

            else if (selecaoDeModo == 2) {

                clearConsole();
                System.out.println("Modo Disciplina/Turma Ativado");

            }

            else if (selecaoDeModo == 3) {

                clearConsole();
                System.out.println("Modo Avaliação/Frequência Ativado");

            }

            else if (selecaoDeModo == 4) {

                clearConsole();
                System.out.println("Você escolheu sair!");

            }

            else {

                System.out.println("Esse número não é válido, tente de novo!");
                System.out.print("Escolha uma opção: ");

            }

        }
    }

}