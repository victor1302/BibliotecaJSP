/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Emprestimo;
import model.Livros;
import model.dao.ClienteDaoFactory;
import model.dao.EmprestimoDaoFactory;
import model.dao.InterfaceClienteDao;
import model.dao.InterfaceDao;
import model.dao.InterfaceEmprestimoJpa;
import model.dao.LivroDaoFactory;

/**
 *
 * @author Vhugo
 */
public class Principal {
    public static void main(String[] args) {
        try {
            InterfaceDao dao = LivroDaoFactory.novoLivroDao();
            InterfaceClienteDao daoCliente = ClienteDaoFactory.novoClienteDAO();
            InterfaceEmprestimoJpa daoEmprestimo = EmprestimoDaoFactory.novoEmprestimoDao();
            
            Cliente c = new Cliente();
            Livros l = new Livros();
            Emprestimo e = new Emprestimo();
            
            
            System.out.println(dao.listar());
            
            
            
            
            
           
            
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
