package Main;

import Classes.Campeonato;
import Classes.Jogador;
import Classes.Org;
import Classes.Status_jog;
import DAO.CampeonatoDAO;
import DAO.JogadorDAO;
import DAO.OrgDAO;
import DAO.Status_jogDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CampeonatoDAO c1 = new CampeonatoDAO();
        Campeonato c2 = new Campeonato();
        JogadorDAO j1 = new JogadorDAO();
        Jogador j2 = new Jogador();
        OrgDAO o1 = new OrgDAO();
        Org o2 = new Org();
        Status_jogDAO s1 = new Status_jogDAO();
        Status_jog s2 = new Status_jog();
        int cont = 0; //contador de times inscritos
        int id; //id que representa a identificacao de alguma das classes

        boolean flag = true;

        while (flag) {
            System.out.println("Escolha uma opção");
            System.out.println("1 - Inserir os dados do times:");
            System.out.println("2 - Inserir os dados dos status dos jogadores:");
            System.out.println("3 - Inserir os dados dos jogadores:");
            System.out.println("4 - Inserir os dados do campeonato:");
            System.out.println("5 - Atualizar os dados do time :");
            System.out.println("6 - Atualizar os dados dos status do jogador:");
            System.out.println("7 - Atualizar os dados dos jogador:");
            System.out.println("8 - Atualizar os dados do campeonato:");
            System.out.println("9 - Deletar algum time:");
            System.out.println("10 - Deletar algum jogador:");
            System.out.println("11 - Deletar algum status do jogador:");
            System.out.println("12 - Deletar algum campeonato");
            System.out.println("13 - Mostrar os dados da organizacao");
            System.out.println("14 - Mostrar os dados dos jogadores");
            System.out.println("15 - Mostrar os dados dos status");
            System.out.println("16 - Mostrar os dados do campeonato");
            System.out.println("17 - Sair! ");
            System.out.println("Sua opção: ");
            int op = sc.nextInt();

            switch (op) {

                case 1:
                    sc.nextLine();
                    System.out.println("Digite o nome do Time(Organizacao): ");
                    o2.nome = sc.nextLine();
                    cont++;
                    System.out.println("Digite a quantidade de membros do time");
                    o2.membros_time = sc.nextInt();
                    o1.inserirOrg(o2);
                    break;

                case 2:
                    System.out.println("Digite a quantidade de kills do jogador: ");
                    s2.kills = sc.nextInt();
                    System.out.println("Digite a quantidade de deaths do player: ");
                    s2.deaths = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a quantidade de horas treinadas para o campeonato: ");
                    s2.horas_p_dia = sc.nextLine();
                    s1.inserirStatus(s2);
                    break;

                case 3:
                        sc.nextLine();
                        System.out.println("Digite o nome do jogador: ");
                        j2.nick_apelido = sc.nextLine();
                        System.out.println("Digite a funcao do jogador: ");
                        j2.funcao = sc.nextLine();
                        System.out.println("Digite a id da Org: ");
                        j2.Org_idOrg = sc.nextInt();
                        System.out.println("Digite a id do Status: ");
                        j2.Status_jog_idStatus_jog = sc.nextInt();
                        j1.inserirJogador(j2);
                    break;


                case 4:
                    System.out.println("Digite o valor da premiação total do campeonato: ");
                    c2.premiacao = sc.nextDouble();
                    System.out.println("Quantidade de times inscritos até o momento: " + cont);
                    c2.times_inscritos = cont;
                    sc.nextLine();
                    System.out.println("Digite a data que começa o campeonato: ");
                    c2.data = sc.nextLine();
                    c1.inserirCampeonato(c2);
                    break;

                case 5:
                    System.out.println("Entre com o id do time que deseja alterar: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entre com o novo nome do time que deseja alterar: ");
                    o2.nome = sc.nextLine();
                    System.out.println("Entre com o nova quantidade de membros no time que deseja alterar: ");
                    o2.membros_time = sc.nextInt();
                    o1.atualizarOrg(id, o2);
                    break;

                case 6:
                    System.out.println("Entre com o id do status que deseja alterar: ");
                    id = sc.nextInt();
                    System.out.println("Entre com o nova quantidade de kills: ");
                    s2.kills = sc.nextInt();
                    System.out.println("Entre com o nova quantidade de deaths: ");
                    s2.deaths = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entre com o nova quantidade de horas treinadas: ");
                    s2.horas_p_dia = sc.nextLine();
                    s1.atualizarStatus(id, s2);
                    break;

                case 7:
                    System.out.println("Entre com o id do jogador que deseja alterar: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entre com o novo nick do jogador: ");
                    j2.nick_apelido = sc.nextLine();
                    System.out.println("Entre com o nova funcao do jogador deseja alterar: ");
                    j2.funcao = sc.nextLine();
                    j1.atualizarJogador(id, j2);
                    break;

                case 8:
                    System.out.println("Entre com o id do campeonato que deseja alterar: ");
                    id = sc.nextInt();
                    System.out.println("Entre com o novo valor da premiacao: ");
                    c2.premiacao = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Entre com a nova data do campeonato: ");
                    c2.data = sc.nextLine();
                    c1.atualizarCampeonato(id, c2);
                    break;

                case 9:
                    System.out.println("Entre com o id do time que deseja deletar: ");
                    id = sc.nextInt();
                    o1.deletarOrg(id);
                    break;

                case 10:
                    System.out.println("Entre com o id do jogador que deseja deletar: ");
                    id = sc.nextInt();
                    j1.deletarJogador(id);
                    break;

                case 11:
                    System.out.println("Entre com o id do status que deseja deletar: ");
                    id = sc.nextInt();
                    s1.deletarStatus(id);
                    break;

                case 12:
                    System.out.println("Entre com o id do campeonato que deseja deletar: ");
                    id = sc.nextInt();
                    c1.deletarCampeonato(id);
                    break;

                case 13:
                    ArrayList<Org> time = new ArrayList<>();
                    time = o1.buscarOrg();

                    System.out.println("=====================");
                    System.out.println("ArrayList na main ===");
                    for (int i = 0; i < time.size(); i++) {
                        System.out.println("nome do time: " + time.get(i).nome);
                        System.out.println("total de membros no time: " + time.get(i).membros_time);
                    }
                    break;

                case 14:
                    ArrayList<Jogador> player = new ArrayList<>();
                    player = j1.buscarJogador();

                    System.out.println("=====================");
                    System.out.println("ArrayList na main ===");
                    for (int k = 0; k < player.size(); k++) {
                        System.out.println("nick do jogador: " + player.get(k).nick_apelido);
                        System.out.println("funcao do jogador: " + player.get(k).funcao);
                    }
                    break;

                case 15:
                    ArrayList<Status_jog> status_jog = new ArrayList<>();
                    status_jog = s1.buscarStatus();

                    System.out.println("=====================");
                    System.out.println("ArrayList na main ===");
                    for (int k = 0; k < status_jog.size(); k++) {
                        System.out.println("kills do jogador: " + status_jog.get(k).kills);
                        System.out.println("deaths do jogador: " + status_jog.get(k).deaths);
                        System.out.println("horas jogadas: " + status_jog.get(k).horas_p_dia);
                    }
                    break;

                case 16:
                    ArrayList<Campeonato> camp = new ArrayList<>();
                    camp = c1.buscarCampeonato();

                    System.out.println("=====================");
                    System.out.println("ArrayList na main ===");
                    for (int i = 0; i < camp.size(); i++) {
                        System.out.println("premiacao do campeonato: " + camp.get(i).premiacao);
                        System.out.println("total de times: " + camp.get(i).times_inscritos);
                        System.out.println("data do campeonato: " + camp.get(i).data);
                    }
                    break;

                case 17:
                    System.out.println("Você saiu!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opção inválida, Digite novamente! ");
                    break;
            }
        }
    }
}
