/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Livros;

/**
 *
 * @author Vhugo
 */
public class LivroDaoJpa implements InterfaceDao<Livros>{
    
    @Override
    public void incluir(Livros livros) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(livros);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Livros livros) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(livros);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Livros livros) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            Livros lv = em.find(Livros.class, livros.getId());
            em.remove(lv);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Livros pesquisarPorId(int id) throws Exception {
        Livros c = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            c = em.find(Livros.class, id);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return c;
    }

    @Override
    public List<Livros> listar() throws Exception {
        List<Livros> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("FROM livros v").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }

    @Override
    public List<Livros> filtrarPorNome(String nome) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();

        Query query = em.createNamedQuery("Contato.filtrarPorNome");
        query.setParameter("nome", nome);
        List<Livros> resultado = query.getResultList();
        return resultado;
    }

    @Override
    public List<Livros> listarDisponiveis() throws Exception {
        List<Livros> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            String consulta = "SELECT l FROM livros l WHERE l.id NOT IN (SELECT e.livro.id FROM emprestimo e WHERE e.dataDevolucao IS NULL)";
            lista = em.createQuery(consulta).getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }
    
    

    @Override
    public void pegarLivro(int idLivro, int idCliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Livros> listarEmprestados() throws Exception {
        List<Livros> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try{
            em.getTransaction().begin();
            String consulta = "SELECT l FROM livros l LEFT JOIN l.emprestimo e WHERE e.id IS NULL";
            lista = em.createQuery(consulta).getResultList();
            em.getTransaction().commit();
       } finally{
            em.close();
        }
        return lista;
    }
    
}
