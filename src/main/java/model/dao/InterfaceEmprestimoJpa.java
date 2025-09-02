/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.Emprestimo;

/**
 *
 * @author Vhugo
 */
public interface InterfaceEmprestimoJpa<T> {
    
    public abstract void incluir(T entidade) throws Exception;

    public abstract void editar(T entidade) throws Exception;

    public abstract void excluir(T entidade) throws Exception;
            
    public abstract Emprestimo pesquisarPorId(int id) throws Exception;

    public abstract List<T> listar() throws Exception;
    
    public abstract List<T> listarHistorico() throws Exception;
    
    public abstract List<T> filtrarPorNome(String nome) throws Exception;
    
    public abstract void devolverLivro(int emprestimoId) throws Exception;
    
    
}
