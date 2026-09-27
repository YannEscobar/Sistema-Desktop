package model;
//Pertence ao pacote model
import java.util.Scanner;

public class Projeto {

    private int id;
    private String nome, descricao, categoria,status;
    //Cria uma série de variáveis para ser utilizado por outros métodos e classes

    public Projeto() {
    }

    public Projeto(int id, String nome, String descricao,
                   String categoria, String status) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = status;
    }

    //Getter e Setters
    //Como as variáveis são privates precisamos de getters e Setter
    ///////////////////////////////////////////////////////////////

    public int getId(){ //cria um metodo int público para 'puxar' um 'id'
        return id;
    }
    public int setId(int id){
        //'id' é um parâmetro recebido pelo metodo
        this.id = id;
        //this referência a si mesmo e atribui um atributo a um objeto
        return id; //Porque desse return aqui, não me pergunte!
    }

    public String getNome(){
        return nome;
    }
    public String setNome(String nome){
        this.nome = nome;
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }
    public String setDescricao(String descricao){
        this.descricao = descricao;
        return descricao;
    }

    public String getCategoria(){
        return categoria;
    }
    public String setCategoria(String categoria){
        this.categoria = categoria;
        return categoria;
    }

    public String getStatus(){ return status;    }
    public String setStatus(String status){ this.status = status; return status; }
}