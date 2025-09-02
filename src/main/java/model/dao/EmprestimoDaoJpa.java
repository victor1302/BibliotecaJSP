/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cliente;
import model.Emprestimo;

/**
 *
 * @author Vhugo
 */
public class EmprestimoDaoJpa implements InterfaceEmprestimoJpa<Emprestimo>{

    @Override
    public void incluir(Emprestimo emprestimo) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(emprestimo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Emprestimo emprestimo) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(emprestimo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Emprestimo emprestimo) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            Emprestimo c1 = em.find(Emprestimo.class, emprestimo.getId());
            em.remove(c1);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Emprestimo pesquisarPorId(int id) throws Exception {
        Emprestimo c = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            c = em.find(Emprestimo.class, id);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public List<Emprestimo> listar() throws Exception {
        List<Emprestimo> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("SELECT e FROM emprestimo e WHERE e.dataDevolucao IS NULL").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }

    @Override
    public List<Emprestimo> filtrarPorNome(String nome) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();

        Query query = em.createNamedQuery("Contato.filtrarPorNome");
        query.setParameter("nome", nome);
        List<Emprestimo> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public void devolverLivro(int emprestimoId) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        Emprestimo emp = em.find(Emprestimo.class, emprestimoId);
        
        if(emp != null && emp.getDataDevolucao() == null){
            em.getTransaction().begin();
            emp.setDataDevolucao(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            em.merge(emp);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<Emprestimo> listarHistorico() throws Exception {
        List<Emprestimo> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("SELECT e FROM emprestimo e", Emprestimo.class).getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }
    
    
    
}
