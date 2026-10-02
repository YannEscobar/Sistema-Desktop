package dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Projeto;

public class PrjCSV {
    // Essa clase vai tratar do gerenciamento de arquivos
    private Path caminho;

    public PrjCSV(){
        caminho = Path.of("dados/projetos.csv");
    }

    public void salvar(List<Projeto> projetos)
        throws Exception {

            List<String> linhas = new ArrayList<String>();

            linhas.add("id;nome;descricao;categoria;status");

            for (Projeto projeto : projetos){

                String linha =
                        projeto.getId() + ";" +
                        projeto.getNome() + ";" +
                        projeto.getDescricao() + ";" +
                        projeto.getCategoria() + ";" +
                        projeto.getStatus();

                linhas.add(linha);
            }

            Files.write(caminho, linhas);
        }
}
