package service;

import dao.PrjCSV;
import model.Projeto;

private PrjCSV dao;
import java.util.ArrayList;
import java.util.List;
import dao.PrjCSV;
import model.Projeto;

public class PrjService {

    private List<Projeto> projetos;

    private PrjCSV dao;

    public PrjService() {

        projetos =  new ArrayList<>();

        dao =  new PrjCSV();
    }

    public void carregar()
            throws Exception {

        projetos = dao.listar();

    }

    public void salvar()
            throws Exception {

        dao.salvar(projetos);

    }

    public boolean adicionar(
            Projeto projeto
    ) {

        if (projeto.getNome() == null ||
                projeto.getNome().isBlank() ) {

            return false;

        }

        if (
                buscarPorId(projeto.getId()) != null
        ) {

            return false;

        }

        projetos.add(projeto);

        return true;
    }

    public List<Projeto> listar() {

        return projetos;

    }

    public Projeto buscarPorId(int id) {

        for (Projeto projeto : projetos) {

            if (projeto.getId() == id) {
                return projeto;
            }
        }
        return null;
    }

    public List<Projeto> buscarPorCategoria(
            String categoria
    ) {

        List<Projeto> resultado =  new ArrayList<>();

        for (Projeto projeto : projetos) {
            if (projeto.getCategoria().equalsIgnoreCase(categoria))
            {
                resultado.add(projeto);
            }
        }

        return resultado;
    }

    public List<Projeto> buscarPorStatus(String status) {

        List<Projeto> resultado = new ArrayList<>();

        for (Projeto projeto : projetos) {
            if (projeto.getStatus().equalsIgnoreCase(status)) {
                resultado.add(projeto);
            }
        }

        return resultado;
    }

    public boolean removerPorId(int id) {

        Projeto projeto =  buscarPorId(id);

        if (projeto != null) {

            projetos.remove(projeto);

            return true;
        }

        return false;
    }
}



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


        // Métodos que serão usados na criação de arquivos...
        public static void adicionar(Projeto projeto) {
            projetos.add(projeto);
        }

        public static List<Projeto> listar() {
            // Cria um metodo 'listar' utilizando arraylist
            for (Projeto projeto : PrjService.listar()) {
                projeto.exbDados();
                // Cria um loop que exibe os obj's projeto
                // E exibe eles com o metodo 'exbDados'
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