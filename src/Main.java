import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // VARIAVEIS DE ESPAÇAMENTO
        String separadorduplo = "=".repeat(40);
        String separadorsimples = "-".repeat(40);

        // ARMAZENAMENTO DE VARIAVEIS
        // CADASTRO DO ANIMAL
        ArrayList<String> nomesAnimais = new ArrayList<>();
        ArrayList<String> especiesAnimais = new ArrayList<>();
        ArrayList<Integer> idadesAnimais = new ArrayList<>();
        ArrayList<String> nomesTutores = new ArrayList<>();
        ArrayList<String> telefonesTutores = new ArrayList<>();

        // CADASTRO VETERINARIO
        ArrayList<String> nomesVets = new ArrayList<>();
        ArrayList<String> crmvsVets = new ArrayList<>();
        ArrayList<String> telefonesVets = new ArrayList<>();

        // CADASTRO CONSULTA
        ArrayList<Integer> consVetIndex = new ArrayList<>();    // Liga a consulta ao veterinário escolhido
        ArrayList<Integer> consAnimalIndex = new ArrayList<>(); // Liga a consulta ao animal escolhido
        ArrayList<String> datasConsultas = new ArrayList<>();
        ArrayList<Integer> horasConsultas = new ArrayList<>();
        ArrayList<Integer> minutosConsultas = new ArrayList<>();
        ArrayList<String> statusConsultas = new ArrayList<>();
        ArrayList<String> observacoesConsultas = new ArrayList<>();

// TESTE RAPIDO
        // Animais pre-cadastrados
        nomesAnimais.add("Tigre");
        especiesAnimais.add("cão");
        idadesAnimais.add(4);
        nomesTutores.add("Anderson");
        telefonesTutores.add("51999991111");

        nomesAnimais.add("Bota");
        especiesAnimais.add("gato");
        idadesAnimais.add(2);
        nomesTutores.add("Mariana");
        telefonesTutores.add("51988882222");

        nomesAnimais.add("Thor");
        especiesAnimais.add("cão");
        idadesAnimais.add(6);
        nomesTutores.add("Carlos");
        telefonesTutores.add("51977773333");

        // Veterinários pre-cadastrados
        nomesVets.add("Anderson");
        crmvsVets.add("12345-RS");
        telefonesVets.add("51991112222");

        nomesVets.add("Camila");
        crmvsVets.add("67890-RS");
        telefonesVets.add("51993334444");

        nomesVets.add("Rafael");
        crmvsVets.add("54321-RS");
        telefonesVets.add("51995556666");

// CONSULTAS PRE-CADASTRADAS
        // Consulta 1: Dr. Anderson
        consVetIndex.add(0);
        consAnimalIndex.add(0);
        datasConsultas.add("20/11/2026");
        horasConsultas.add(9);
        minutosConsultas.add(0);
        statusConsultas.add("agendada");
        observacoesConsultas.add("");

        // Consulta 2: Dr. Anderson
        consVetIndex.add(0);
        consAnimalIndex.add(1);
        datasConsultas.add("20/11/2026");
        horasConsultas.add(14);
        minutosConsultas.add(30);
        statusConsultas.add("agendada");
        observacoesConsultas.add("");

        // Consulta 3: Dra. Camila
        consVetIndex.add(1);
        consAnimalIndex.add(2);
        datasConsultas.add("18/11/2026");
        horasConsultas.add(10);
        minutosConsultas.add(0);
        statusConsultas.add("realizada");
        observacoesConsultas.add("Vacinação anual aplicada sem intercorrências.");

// CRIAÇÃO DO MENU
        int opcao = 0;
        while (opcao != 6) {
            System.out.println(separadorduplo);
            System.out.println("CLÍNICA VETERINÁRIA VIDAPET");
            System.out.println("(1) - Cadastrar Animal.");
            System.out.println("(2) - Cadastrar Veterinário.");
            System.out.println("(3) - Agendar Consulta.");
            System.out.println("(4) - Cancelar Consulta.");
            System.out.println("(5) - Agenda do Veterinário.");
            System.out.println("(6) - Finalizar Sistema.");
            System.out.println(separadorsimples);
            System.out.print("Escolha uma das opções acima: ");

            // TRATAMENTO DE ERRO PARA DIGITOS INVALIDOS
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números de 1 a 6!");
                continue;
            }

            // EXECUÇÃO DAS OPÇÕES DO MENU
            switch (opcao) {

// CADASTRO DO ANIMAL
                case 1:
                    System.out.println(separadorduplo);
                    System.out.println("CADASTRO DO ANIMAL");
                    System.out.print("Nome do animal: ");
                    String nomeAnimal = scanner.nextLine();

                    System.out.print("Espécie (cão/gato): ");
                    String especieAnimal = scanner.nextLine();
                    if (!especieAnimal.equalsIgnoreCase("cão") && !especieAnimal.equalsIgnoreCase("cao") && !especieAnimal.equalsIgnoreCase("gato")) {
                        System.out.println("Erro: Espécie inválida. Informe apenas 'cão' ou 'gato'.");
                        break;
                    }

                    int idadeAnimal = 0;
                    try {
                        System.out.print("Idade do animal (em anos): ");
                        idadeAnimal = Integer.parseInt(scanner.nextLine());
                        if (idadeAnimal < 0) {
                            System.out.println("Erro: A idade não pode ser negativa.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Idade inválida. Digite um número inteiro.");
                        break;
                    }

                    System.out.print("Nome do tutor: ");
                    String nomeTutor = scanner.nextLine();

                    System.out.print("Telefone do tutor: ");
                    String telefoneTutor = scanner.nextLine();

                    // Adiciona nas listas apenas apos validar tudo
                    nomesAnimais.add(nomeAnimal);
                    especiesAnimais.add(especieAnimal);
                    idadesAnimais.add(idadeAnimal);
                    nomesTutores.add(nomeTutor);
                    telefonesTutores.add(telefoneTutor);

                    System.out.println(separadorsimples);
                    System.out.println("Paciente: " + nomeAnimal + " (" + especieAnimal + ") cadastrado com sucesso!");
                    break;

//CADASTRO DO VETERINARIO
                case 2:
                    System.out.println(separadorduplo);
                    System.out.println("CADASTRO DE VETERINÁRIO");
                    System.out.print("Nome completo do veterinário: ");
                    String nomeVet = scanner.nextLine();

                    System.out.print("CRMV do veterinário: ");
                    String crmvVet = scanner.nextLine();

                    System.out.print("Telefone do veterinário: ");
                    String telefoneVet = scanner.nextLine();

                    // Adiciona nas listas
                    nomesVets.add(nomeVet);
                    crmvsVets.add(crmvVet);
                    telefonesVets.add(telefoneVet);

                    System.out.println(separadorsimples);
                    System.out.println("Veterinário: Dr(a). " + nomeVet + " (CRMV: " + crmvVet + ") cadastrado(a) com sucesso!");
                    break;

// AGENDAMENTO DE CONSULTA
                case 3:
                    System.out.println(separadorduplo);
                    System.out.println("AGENDAR CONSULTA");

                    if (nomesAnimais.isEmpty() || nomesVets.isEmpty()) {
                        System.out.println("Erro: É necessário ter ao menos 1 animal e 1 veterinário cadastrados.");
                        break;
                    }

                    try {
// Escolha do Veterinário
                        System.out.println(separadorsimples);
                        System.out.println("VETERINÁRIOS DISPONÍVEIS:");
                        for (int i = 0; i < nomesVets.size(); i++) {
                            System.out.println("(" + (i + 1) + ")" + " - Dr(a). " + nomesVets.get(i) + " (CRMV: " + crmvsVets.get(i) + ")");
                        }
                        System.out.println(separadorsimples);
                        System.out.print("Escolha uma das opções acima: ");
                        int idxVet = Integer.parseInt(scanner.nextLine()) - 1;

                        if (idxVet < 0 || idxVet >= nomesVets.size()) {
                            System.out.println("Erro: Veterinário inválido.");
                            break;
                        }

// Escolha do Animal
                        System.out.println(separadorsimples);
                        System.out.println("ANIMAIS CADASTRADOS:");
                        for (int i = 0; i < nomesAnimais.size(); i++) {
                            System.out.println("(" + (i + 1) + ")" + " - " + nomesAnimais.get(i) + " (Tutor: " + nomesTutores.get(i) + ")");
                        }
                        System.out.println(separadorsimples);
                        System.out.print("Escolha uma das opções acima: ");
                        int idxAnimal = Integer.parseInt(scanner.nextLine()) - 1;

                        if (idxAnimal < 0 || idxAnimal >= nomesAnimais.size()) {
                            System.out.println("Erro: Paciente inválido.");
                            break;
                        }

// Coleta de Data e Horário
                        System.out.println(separadorsimples);
                        System.out.print("Informe a data (DD/MM/AAAA): ");
                        String novaData = scanner.nextLine();

                        int diaSemana = 0;
                        int novaHora = 0;
                        int novoMinuto = 0;

                        // Loop que repete do "Dia da semana" até tudo estar válido
                        while (true) {
                            System.out.println(separadorsimples);
                            System.out.print("Dia da semana (1-Seg | 2-Ter | 3-Qua | 4-Qui | 5-Sex): ");
                            diaSemana = Integer.parseInt(scanner.nextLine());
                            if (diaSemana < 1 || diaSemana > 5) {
                                System.out.println("Horário Indisponível: Informe um número válido de 1 a 5 (segunda a sexta-feira). Tente novamente.");
                                continue;
                            }

                            System.out.println(separadorsimples);
                            System.out.println("Inicio as (08:00) até (17:00).");   // futuramento podemos colocar aqui os horariso vagos para consulta
                            System.out.print("Horário da consulta (HH:MM): ");
                            String horarioStr = scanner.nextLine().trim();

                            // Verifica se tem ":" e se está dividido em 2 partes (hora e minuto)
                            if (!horarioStr.contains(":")) {
                                System.out.println("Formato inválido! Digite no padrão HH:MM (ex: 14:30). Tente novamente.");
                                continue;
                            }

                            String[] partes = horarioStr.split(":");
                            if (partes.length != 2) {
                                System.out.println("Formato inválido! Digite no padrão HH:MM (ex: 14:30). Tente novamente.");
                                continue;
                            }

                            try {
                                novaHora = Integer.parseInt(partes[0]);
                                novoMinuto = Integer.parseInt(partes[1]);
                            } catch (NumberFormatException e) {
                                System.out.println("Formato inválido! Digite no padrão HH:MM (ex: 14:30). Tente novamente.");
                                continue;
                            }

                            if (novaHora < 8 || novaHora > 17 || (novoMinuto != 0 && novoMinuto != 30)) {
                                System.out.println("Horário Indisponível: Horário comercial das 8h às 18h em blocos de 30 minutos. Tente novamente.");
                                continue;
                            }

                            break; // Tudo valido sai do loop e vai verificar conflito na agenda
                        }

                        // Verifica conflito apenas na agenda do veterinário escolhido
                        boolean horarioOcupado = false;
                        for (int i = 0; i < statusConsultas.size(); i++) {
                            if (consVetIndex.get(i).equals(idxVet) &&
                                    statusConsultas.get(i).equals("agendada") &&
                                    datasConsultas.get(i).equals(novaData) &&
                                    horasConsultas.get(i).equals(novaHora) &&
                                    minutosConsultas.get(i).equals(novoMinuto)) {
                                horarioOcupado = true;
                                break;
                            }
                        }

                        if (horarioOcupado) {
                            System.out.println("Horário Indisponível: Dr(a). " + nomesVets.get(idxVet) + " já possui consulta neste dia e horário.");
                            break;
                        }

                        // Salva o agendamento
                        consVetIndex.add(idxVet);
                        consAnimalIndex.add(idxAnimal);
                        datasConsultas.add(novaData);
                        horasConsultas.add(novaHora);
                        minutosConsultas.add(novoMinuto);
                        statusConsultas.add("agendada");
                        observacoesConsultas.add("");

                        String minutoFormatado = (novoMinuto == 0) ? "00" : "30";
                        System.out.println(separadorsimples);
                        System.out.println("Consulta AGENDADA para " + nomesAnimais.get(idxAnimal) +
                                " com Dr(a). " + nomesVets.get(idxVet) +
                                " em " + novaData + " às " + novaHora + ":" + minutoFormatado + ".");

                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Entrada numérica inválida durante o agendamento.");
                    }
                    break;

// CANCELAR CONSULTA
                case 4:
                    System.out.println(separadorduplo);
                    System.out.println("CANCELAR CONSULTA COM");

                    if (nomesVets.isEmpty() || statusConsultas.isEmpty()) {
                        System.out.println("Nenhuma consulta encontrada no sistema.");
                        break;
                    }

                    try {
                        // Escolhe o veterinário para ver as consultas dele
                        for (int i = 0; i < nomesVets.size(); i++) {
                            System.out.println("(" + (i + 1) + ") - Dr(a). " + nomesVets.get(i) + " (CRMV: " + crmvsVets.get(i) + ").");
                        }

                        System.out.println(separadorsimples);
                        System.out.print("Escolha uma das opções acima: ");
                        int idxVetCancel = Integer.parseInt(scanner.nextLine()) - 1;

                        if (idxVetCancel < 0 || idxVetCancel >= nomesVets.size()) {
                            System.out.println("Erro: Veterinário inválido.");
                            break;
                        }

                        System.out.println(separadorsimples);
                        boolean temConsultaVet = false;
                        for (int i = 0; i < statusConsultas.size(); i++) {
                            if (consVetIndex.get(i).equals(idxVetCancel)) {
                                String minFmt = (minutosConsultas.get(i) == 0) ? "00" : "30";
                                String pac = nomesAnimais.get(consAnimalIndex.get(i));
                                System.out.println("(" + (i + 1) + ") - Paciente: " + pac + " | Data: " + datasConsultas.get(i) +
                                        " às " + horasConsultas.get(i) + ":" + minFmt + " | Status: " + statusConsultas.get(i).toUpperCase());
                                temConsultaVet = true;
                            }
                        }

                        if (!temConsultaVet) {
                            System.out.println("Este veterinário não possui consultas registradas.");
                            break;
                        }

                        System.out.println(separadorsimples);
                        System.out.print("Escolha uma das consultas para 'CANSELAR': ");
                        int idConsultaCancel = Integer.parseInt(scanner.nextLine()) - 1;

                        if (idConsultaCancel < 0 || idConsultaCancel >= statusConsultas.size() || !consVetIndex.get(idConsultaCancel).equals(idxVetCancel)) {
                            System.out.println("Erro: opção inválida.");
                            break;
                        }

                        if (!statusConsultas.get(idConsultaCancel).equals("agendada")) {
                            System.out.println("Cancelamento Negado: Apenas consultas com status 'agendada' podem ser canceladas (status atual: " + statusConsultas.get(idConsultaCancel) + ").");
                            break;
                        }

                        System.out.println(separadorsimples);
                        System.out.print("Confirmar cancelamento? (1 - Sim / 2 - Não): ");
                        int confirma = Integer.parseInt(scanner.nextLine());
                        if (confirma == 1) {
                            statusConsultas.set(idConsultaCancel, "cancelada");
                            System.out.println("Consulta 'CANSELADA' com sucesso!");
                        } else {
                            System.out.println("Operação abortada.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Entrada numérica inválida.");
                    }
                    break;

// AGENDA DOs VETERINÁRIOs
                case 5:
                    System.out.println(separadorduplo);
                    System.out.println("AGENDA DE VETERINÁRIO(S).");

                    if (nomesVets.isEmpty()) {
                        System.out.println("Nenhum veterinário cadastrado.");
                        break;
                    }

                    try {
                        for (int i = 0; i < nomesVets.size(); i++) {
                            System.out.println("(" + (i + 1) + ") - Dr(a). " + nomesVets.get(i) + " (CRMV: " + crmvsVets.get(i) + ")");
                        }

                        System.out.println(separadorsimples);
                        System.out.print("Escolha uma opção a cima: ");
                        int idxVetAgenda = Integer.parseInt(scanner.nextLine()) - 1;

                        if (idxVetAgenda < 0 || idxVetAgenda >= nomesVets.size()) {
                            System.out.println("Erro: Veterinário inválido.");
                            break;
                        }

                        System.out.println(separadorsimples);
                        System.out.println("Agenda de Dr(a). " + nomesVets.get(idxVetAgenda) + " (CRMV: " + crmvsVets.get(idxVetAgenda) + ")");
                        System.out.println(separadorsimples);

                        boolean encontrouAgenda = false;
                        for (int i = 0; i < statusConsultas.size(); i++) {
                            if (consVetIndex.get(i).equals(idxVetAgenda)) {
                                String minFmt = (minutosConsultas.get(i) == 0) ? "00" : "30";
                                int idxPac = consAnimalIndex.get(i);
                                System.out.println("(" + (i + 1) + ") - Paciente: " + nomesAnimais.get(idxPac) + " (" + especiesAnimais.get(idxPac) + ")" +
                                        " | Data: " + datasConsultas.get(i) + " às " + horasConsultas.get(i) + ":" + minFmt +
                                        " | Status: " + statusConsultas.get(i).toUpperCase());
                                if (!observacoesConsultas.get(i).isEmpty()) {
                                    System.out.println("       Obs: " + observacoesConsultas.get(i));
                                }
                                encontrouAgenda = true;
                            }
                        }

                        if (!encontrouAgenda) {
                            System.out.println("Nenhuma consulta na agenda deste veterinário.");
                            break;
                        }

                        System.out.println(separadorsimples);
                        System.out.print("Deseja registrar alguma consulta como REALIZADA? (1 - Sim / 2 - Voltar): ");
                        int acaoVet = Integer.parseInt(scanner.nextLine());

                        if (acaoVet == 1) {
                            System.out.println(separadorsimples);
                            System.out.print("Informe a opção da consulta que foi finalizada: ");
                            int idConsultaFin = Integer.parseInt(scanner.nextLine()) - 1;

                            if (idConsultaFin < 0 || idConsultaFin >= statusConsultas.size() || !consVetIndex.get(idConsultaFin).equals(idxVetAgenda)) {
                                System.out.println("Erro: ID de consulta inválido para este veterinário.");
                                break;
                            }

                            if (!statusConsultas.get(idConsultaFin).equals("agendada")) {
                                System.out.println("Status Inválido: Apenas consultas 'agendadas' podem ser finalizadas (status atual: " + statusConsultas.get(idConsultaFin) + ").");
                                break;
                            }

                            System.out.println(separadorsimples);
                            System.out.print("Digite as observações do atendimento: ");
                            String obs = scanner.nextLine();

                            observacoesConsultas.set(idConsultaFin, obs);
                            statusConsultas.set(idConsultaFin, "realizada");

                            System.out.println(separadorsimples);
                            System.out.println("Sucesso: Consulta marcada como 'REALIZADA'!");
                            System.out.println("Observações registradas: " + obs);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Opção inválida.");
                    }
                    break;

// FINALIZAR SISTEMA
                case 6:
                    System.out.println(separadorduplo);
                    System.out.println("Encerrando o sistema da Clínica Veterinária VidaPet...");
                    System.out.println("Até logo!");
                    System.out.println(separadorduplo);
                    break;

                default:
                    System.out.println("Opção inválida! Escolha um número entre 1 e 6.");
                    break;
            }
        }
        scanner.close();
    }
}