import model.Projeto;
//Importa uma classe

import service.PrjService;
//Como visto no superior importa uma classe

import dao.PrjCSV;

public class Main{
  public static void main(String[] args) throws Exception{
    System.out.println("======================");
    System.out.println("SISTEMA DESKTOP EM JAVA");
    System.out.println("======================");
    
    System.out.println("Projeto: Portfólio Acadêmico");
    System.out.println("Desenvolvido em Java");
    System.out.println("Versão: 0.1 Alpha");

    Projeto projeto = new Projeto();
    //Declaramos uma variável para armazenar um objeto Projeto: 'projeto'
    //Instacia-mos

    Projeto projeto1 = new Projeto(
            1,
            "Sistema Acadêmico",
            "Sistema para gerenciamento acadêmico",
            "Software",
            "Em desenvolvimento"
    );

    PrjService.adicionar(projeto1);

    PrjCSV dao = new PrjCSV();

    PrjService prjService1 = new PrjService(
            0,
            100,
            "Otimização de código"
    );

    projeto1.exbDados();
    if (projeto1.statusCompleto()){
      System.out.println("O projeto está concluído, parabéns!");
    }
    else {
      System.out.println("O projeto não está concluído :(");
    }

    projeto1.setStatus("Concluído");
    projeto1.exbDados();
    prjService1.exbServico();

    dao.salvar(PrjService.listar());
  }
}