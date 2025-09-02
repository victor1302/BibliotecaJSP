/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Vhugo
 */
@Entity(name = "emprestimo")
public class Emprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dataEmprestimo;
    private String dataDevolucao;
   
    // Relacionamento com Livro (um livro tem no máximo 1 cliente, um cliente tem vários livros)
    @OneToOne
    @JoinColumn(name = "livro_id")
    private Livros livro;
    
    // Relacionamento com Cliente (um cliente pode pegar vários livros emprestados)
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Emprestimo() {
    }

    public Emprestimo(String dataEmprestimo, Livros livro, Cliente cliente) {
        this.dataEmprestimo = dataEmprestimo;
        this.livro = livro;
        this.cliente = cliente;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
