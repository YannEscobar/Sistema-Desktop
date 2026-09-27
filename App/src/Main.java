import model.Projeto;
//Importa uma classe

public class Main{
  public static void main(String[] args) {
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

    System.out.println("Projeto 1 características: ");
    System.out.println(projeto1.getNome());
    System.out.println(projeto1.getDescricao());
    System.out.println(projeto1.getCategoria());
    System.out.println(projeto1.getStatus());
  }
}