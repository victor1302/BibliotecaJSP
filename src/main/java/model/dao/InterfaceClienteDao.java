/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.Cliente;

public interface InterfaceClienteDao<T> {
    
    public abstract void incluir(T entidade) throws Exception;

    public abstract void editar(T entidade) throws Exception;

    public abstract void excluir(T entidade) throws Exception;

    public abstract Cliente pesquisarPorId(int id) throws Exception;

    public abstract List<T> listar() throws Exception;
    
    public abstract List<T> filtrarPorNome(String nome) throws Exception;
   
    public abstract List<T> livrosEmprestados() throws Exception;
    
    public abstract void desativarCliente(int clienteId) throws Exception;
}
