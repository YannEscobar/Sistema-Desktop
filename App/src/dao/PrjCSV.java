package dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Projeto;

public class PrjCSV {
    // Essa classe vai tratar do gerenciamento de arquivos
    private Path caminho;

    public PrjCSV(){
        caminho = Path.of("dados/projetos.csv");
    }


    public void salvar(List<Projeto> projetos)
    // Metodo para salvar, utilizando como parâmetro uma lista de objetos do tipo projeto
            throws Exception {

        List<String> linhas =  new ArrayList<>();
        // Cria e instancia uma variável chamada 'linhas' como uma nova arraylist
        // Ela vai receber a primeiro momento o cabeçalho dos dados

        linhas.add("id;nome;descricao;categoria;status");

        for (Projeto projeto : projetos) {
            // Um loop que percorre os projetos e adiciona ";" após cada índice

            String linha =
                    projeto.getId() + ";" +
                            projeto.getNome() + ";" +
                            projeto.getDescricao() + ";" +
                            projeto.getCategoria() + ";" +
                            projeto.getStatus();
            // Após um ciclo de operação, pega a 'linha' e adiciona as linhas
            linhas.add(linha);
        }
        Files.write(caminho, linhas);
        // Escreve o arquivo em csv :)
    }

    public List<Projeto> listar() throws Exception {

        List<Projeto> projetos = new ArrayList<>();

        if (!Files.exists(caminho)) {

            return projetos;
        }

        List<String> linhas =
                Files.readAllLines(caminho);

        for (int i = 1; i < linhas.size(); i++) {

            String linha = linhas.get(i);

            String[] dados =
                    linha.split(";");

            int id = Integer.parseInt(dados[0]);
            String nome = dados[1];
            String descricao = dados[2];
            String categoria = dados[3];
            String status = dados[4];

            Projeto projeto =
                    new Projeto(
                            id,
                            nome,
                            descricao,
                            categoria,
                            status
                    );

            projetos.add(projeto);
        }

        return projetos;
    }

}