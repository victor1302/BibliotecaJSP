/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author Vhugo
 */
@Entity(name = "livros")
public class Livros{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String autor;
    private String editora;
    private int edicao;
    
    
    @OneToMany(mappedBy="livro")
    private List<Emprestimo> emprestimo;
    
    
    public Livros() {
    }

    public Livros(String autor, String nome, String editora, int edicao) {
        this.autor = autor;
        this.nome = nome;
        this.editora = editora;
        this.edicao = edicao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Livros{" + "id=" + id + ", nome=" + nome + ", autor=" + autor + ", editora=" + editora + ", edicao=" + edicao + '}';
    }

    
    
}
