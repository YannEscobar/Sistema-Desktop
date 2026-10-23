package service;

import dao.PrjCSV;
import model.Projeto;

import java.util.ArrayList;
import java.util.List;

public class PrjService {
    private static List<Projeto> projetos;

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

    public static boolean adicionar(Projeto projeto) {
        if (projeto.getNome() == null || projeto.getNome().isBlank() ) {
            // Se projeto pegar nome ou se não tiver nome retorna falso
            return false;
        }

        if (buscarPorId(projeto.getId()) != null) {

            return false;

        }
        projetos.add(projeto);

        return true;
    }

    public static List<Projeto> listar() {
        return projetos;
    }

    // Metodo para atualizar (alterar)

    public boolean alterar(Projeto projetoAtualizado){

        Projeto projeto = buscarPorId(projetoAtualizado.getId());
        // Primeiro procuramos pelo projeto

        if (projeto == null) {
            // Se projeto não existir (NULL) retornar falso
            return false;
            // Retorna falso se não existe
        }

        // Se o projeto existir podemos atualizar os dados

        projeto.setNome(projetoAtualizado.getNome());
        // A variável projetoAtualizado vai guardar os valores da atualização
        projeto.setDescricao(projetoAtualizado.getDescricao());

        projeto.setCategoria(projetoAtualizado.getCategoria());

        projeto.setStatus(projetoAtualizado.getStatus());
        // BRUH, esqueci do 'setStatus'
        // E depois, retornamos:
        return true;

    }


    public static Projeto buscarPorId(int id) {

        for (Projeto projeto : projetos) {

            if (projeto.getId() == id) {
                return projeto;
            }
        }
        return null;
    }

    public List<Projeto> buscarPorCategoria(String categoria) {
        // Criamos uma lista vazia e depois percorremos...

        List<Projeto> resultado =  new ArrayList<>();

        for (Projeto projeto : projetos){
        // Laço para percorrer os projetos
            if (projeto.getCategoria().equalsIgnoreCase(categoria)){
            // Comparamos a categoria do obj projeto em questão no ciclo de execução e fazemos...
                resultado.add(projeto);
                // Adicionamos esse obj nessa variável "local" chamada 'resultado', ciclo reinicia
            }
        }
        // Quando não há mais obj's para percorrer retornamos o resultado
        return resultado;
    }

    public List<Projeto> buscarPorStatus(String status) {

        List<Projeto> resultado = new ArrayList<>();

        for (Projeto projeto : projetos) {
            if (projeto.getStatus().equalsIgnoreCase(status))
            {
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
        // Retorna false caso nada seja encontrado
    }

    public void exbServico() {
    }

}
