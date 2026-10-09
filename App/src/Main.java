import model.Projeto;
//Importa uma classe

import service.PrjService;
//Como visto no superior importa uma classe

import dao.PrjCSV;

import java.sql.Struct;
import java.util.Scanner;

public class Main{
  public static void main(String[] args) throws Exception{
    Scanner input = new Scanner(System.in);

    System.out.println("======================");
    System.out.println("SISTEMA DESKTOP EM JAVA");
    System.out.println("======================");
    
    System.out.println("Projeto: Portfólio Acadêmico");
    System.out.println("Desenvolvido em Java");
    System.out.println("Versão: 0.1 Alpha");

    Projeto projeto = new Projeto();
    //Declaramos uma variável para armazenar um objeto Projeto: 'projeto'
    //Instacia-mos

    PrjService service = new PrjService();
    //Declaramos uma variável para armazenar um objeto PrjService: 'service'
    //Instacia-mos

    PrjCSV dao = new PrjCSV();
    //

    int opcao = -1;

    while(opcao !=0) {
        System.out.println(
                "1 - Listar projetos"
        );

        System.out.println(
                "2 - Buscar projeto"
        );

        System.out.println(
                "3 - Cadastrar projeto"
        );

        System.out.println(
                "4 - Alterar projeto"
        );

        System.out.println(
                "5 - Excluir projeto"
        );

        System.out.println(
                "0 - Sair"
        );

        System.out.print("Escolha: ");
    }

    opcao = input.nextInt();
    // Recebe a entrada do usuário numa variável do tipo int

    switch (opcao) {
      case 1:
        System.out.println(
                "\n--- LISTA DE PROJETOS ---"
        );

        for (Projeto projeto : PrjService.listar()) {
          projeto.exbDados();
          System.out.println(
                  "-------------------------"
          );
        }

        break;

        // Busca por projetos //
        case 2:
          System.out.println("Buscar projeto");
          System.out.print("Qual o id do projeto?");
          System.out.println("\n--- BUSCANDO ---");

          int IDbusca = input.nextInt();
          projeto = PrjService.buscarPorId(IDbusca);

          if (projeto != null){
            projeto.exbDados();
          }
          else {
            System.out.println("Projeto não encontrado");
          }
          break;

          // Cadastro de projetos
          case 3:
            System.out.println("Cadastrar projeto");
            System.out.println("Atribua um ID ao seu novo projeto: ");
            int id = input.nextInt();
            input.nextLine();

            System.out.print("Digite o nome do seu novo projeto: ");
            String nome = input.nextLine();

            System.out.print("Descrição do projeto");
            String desc = input.nextLine();

            System.out.print("Qual a categoria do seu novo projeto?");
            String cat = input.nextLine();

            System.out.print("Status de progressão do projeto");
            String stats = input.nextLine();

            // Criando um novo objeto:
            Projeto projeto = new Projeto(id, nome, desc, cat, stats);

            boolean cadastrado = PrjService.adicionar(projeto);

            if (cadastrado){
              service.salvar();
              System.out.println("Projeto salvo, parabéns!");
            }
            else {
              System.out.println("Algo deu errado");
            }

            break;

            case 4:
              System.out.println("Alterar projeto");
              System.out.println("ID do projeto que você quer alterar");

              int idAlterar = input.nextInt();

              input.nextLine();

              Projeto existente = PrjService.buscarPorId(idAlterar);

              if (existente == null){
                System.out.println("Projeto não encontrado!");
                break;
              }

              System.out.println("\n Projeto atual:");
              existente.exbDados();

              System.out.print("Novo nome: ");
              String nome = input.nextLine();

              System.out.print("Nova descrição: ");
              String descricao =
                      input.nextLine();

              System.out.print("Nova categoria: ");
              String categoria =
                      input.nextLine();

              System.out.print("Novo status: ");
              String status =
                      input.nextLine();

              Projeto atualizado = new Projeto(idAlterar,nome,descricao,categoria,status);

              boolean alterado = service.alterar(atualizado);

              if (alterado) {
                service.salvar();
                System.out.println("Projeto alterado com sucesso.");
              }
              else {
                System.out.println("Não foi possível alterar.");
              }

              break;

      case 5:
        System.out.println("Excluir projeto");
        break;

      case 0:
        System.out.println("Encerrando...");
        break;

      default:
        System.out.println("Opção inválida.");
    }




    Projeto projeto1 = new Projeto(1,"Sistema Acadêmico","Sistema para gerenciamento acadêmico","Software","Em desenvolvimento");
    PrjService.adicionar(projeto1);



    projeto1.exbDados();
    if (projeto1.statusCompleto()){
      System.out.println("O projeto está concluído, parabéns!");
    }
    else {
      System.out.println("O projeto não está concluído :(");
    }

    projeto1.setStatus("Concluído");
    projeto1.exbDados();
    service.exbServico();

    dao.salvar(PrjService.listar());

    // para fins de debug:

    Projeto novo =
            new Projeto(
                    1,
                    "Sistema Acadêmico 2.0",
                    "Nova versão do sistema acadêmico",
                    "Software",
                    "Concluído"
            );

    boolean alterado = service.alterar(novo);

    if (alterado) {

      service.salvar();

      System.out.println(
              "Projeto alterado com sucesso."
      );}
    else {

      System.out.println(
              "Projeto não encontrado."
      );
    }

  }
}