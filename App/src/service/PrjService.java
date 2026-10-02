package service;

import java.util.ArrayList;
import java.util.List;

import model.Projeto;

public class PrjService {
    private static List<Projeto> projetos;
    //lista que armazena objetos do tipo 'Projeto'

    private int idService, precoService;
    private String nomeService;
    //Cria uma série de variáveis para ser utilizado em objetos da classe Serviço

        public PrjService(){
            projetos = new ArrayList<>();
            // Criação prática da lista que armazena obj's do tipo projeto
        }


        public static void adicionar(Projeto projeto) {
            projetos.add(projeto);
        }

        public static List<Projeto> listar() {

            for (Projeto projeto : PrjService.listar()) {

                projeto.exbDados();

            }

            return projetos;

        }

        public PrjService(int idService, int precoService, String nomeService){
            this.idService = idService;
            this.precoService = precoService;
            this.nomeService = nomeService;
        }
    /// /////////////////////////////////////////
    public int getIdService(){
        return idService;
    }
    public int setIdService(int idService){
        this.idService = idService;
        return idService;
    }

    public int getPrecoService(){
        return precoService;
    }
    public int setPrecoService(int precoService){
        this.precoService = precoService;
        return precoService;
    }

    public String getNomeService(){
        return nomeService;
    }
    public String setNomeService(String nomeService){
        this.nomeService = nomeService;
        return nomeService;
    }

    public void exbServico(){
        System.out.println("ID do Serviço: " + idService);
        System.out.println("Nome: " + nomeService);
        System.out.println("Preço: " + precoService);
    }
}