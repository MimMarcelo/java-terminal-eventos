import java.util.Scanner;

public class Eventos{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int opcao; // Armazena escolha do menu

        // Armazenam os dados do/s evento/s
        String nomeEvento = "Evento Padrão";
        String dataEvento = "2026-10-27";
        int inicioEvento = 1045;
        int duracaoEvento = 90;
        int totalParticipantesEvento = 15;

        System.out.println("---------- Sistema de Gerenciamento de Eventos ----------");
        System.out.println("| 1 - Cadastrar evento                                  |");
        System.out.println("| 2 - Listar eventos                                    |");
        System.out.println("|                                                       |");
        System.out.println("| 0 - Encerrar                                          |");
        System.out.print("---------------------------------- Selecione sua opção: ");

        opcao = teclado.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("|----------------- Cadastro de Evento ------------------|");
                System.out.print("| Nome: ");
                nomeEvento = teclado.nextLine();
                System.out.print("| Data de realização (YYYY-MM-DD): ");
                dataEvento = teclado.nextLine();
                System.out.print("| Hora de início (HHMM): ");
                inicioEvento = teclado.nextInt();
                System.out.print("| Duração (em minutos): ");
                duracaoEvento = teclado.nextInt();
                System.out.print("| Total de participantes: ");
                totalParticipantesEvento = teclado.nextInt();
                System.out.println("|------------ Evento cadastrado com sucesso ------------|");
                break;
            case 2:
                System.out.println("|------------------ Lista de Evento/s ------------------|");
                System.out.printf("| Nome: %s%n", nomeEvento);
                System.out.printf("| Data: %s%n", dataEvento);

                // Separa horário de início em horas e minutos
                int horasInicio = inicioEvento/100;
                int minutosInicio = inicioEvento-horasInicio*100;
                System.out.printf("| Hora de início: %d:%d%n", horasInicio, minutosInicio);
                
                // Separa duração do evento em horas e minutos
                int horasDuracao = duracaoEvento/60;
                int minutosDuracao = duracaoEvento%60;
                System.out.printf("| Duração: %d:%d%n", horasDuracao, minutosDuracao);

                // Calcula hora de encerramento do evento
                int horasEncerramento = horasInicio + horasDuracao;
                int minutosEncerramento = minutosInicio + minutosDuracao;
                if(minutosEncerramento >= 60){
                    minutosEncerramento = minutosEncerramento%60;
                    horasEncerramento += 1;
                }
                System.out.printf("| Hora de encerramento: %d:%d%n", horasEncerramento, minutosEncerramento);
                System.out.printf("| Total de participantes: %d%n", totalParticipantesEvento);
                System.out.println("|-------------------------------------------------------|");
                break;
            default:
                System.out.println("Opção inválida!");
        }
        teclado.close(); // Libera o espaço de memória do Scanner
    }
}