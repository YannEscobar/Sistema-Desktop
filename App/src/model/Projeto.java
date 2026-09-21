package model;
import java.util.Scanner;

public class Projeto {

    private id = int;
    private String nome;
    private String descricao;
    private String categoria;
    private Scanner status;
    //Cria uma série de variáveis para ser utilizado por outros métodos e classes


    //Getter e Setters
    //Como as variáveis são privates precisamos de getters e Setter
    ///////////////////////////////////////////////////////////////
    public int getId() {
        return id;
    }
    //'getId' retorna uma variável "int id"

    //Sem retorno
    public void setId(int id){
        this.id = id;
    }

    public String getNome(String nome){
        this.nome = nome;
    }
    public String getDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getCategoria(String categoria){
        this.categoria = categoria;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}